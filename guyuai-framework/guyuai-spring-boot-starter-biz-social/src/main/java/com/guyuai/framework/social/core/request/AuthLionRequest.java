package com.guyuai.framework.social.core.request;

import com.alibaba.fastjson.JSONObject;
import com.guyuai.framework.common.util.json.JsonUtils;
import com.guyuai.framework.social.core.enums.AuthExtendSource;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.cache.AuthStateCache;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.enums.AuthResponseStatus;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthDefaultRequest;
import me.zhyd.oauth.utils.HttpUtils;
import me.zhyd.oauth.utils.UrlBuilder;

/**
 * @company: 谷雨互动
 * @author: whx
 * @date: 2023/7/17
 * @version:
 */
@Slf4j
public class AuthLionRequest extends AuthDefaultRequest {

    public AuthLionRequest(AuthConfig config) {
        super(config, AuthExtendSource.LIONSSO);
    }

    public static void main(String[] args){
        AuthConfig config=new AuthConfig ();
        config.setClientId("a");
        config.setClientSecret("a");
        config.setRedirectUri("http://localhost/");
        AuthSource source=  AuthExtendSource.LIONSSO;
        AuthLionRequest authLionRequest=new AuthLionRequest(config);
        AuthToken authToken=new AuthToken();
        String a=" {\"uuid\":\"878675003774599168\",\"username\":\"et-test\",\"nickname\":\"埋点测试\",\"source\":\"LIONSSO\",\"token\":{\"accessToken\":\"96f9cb69-7f8b-4495-9359-e526193fc55f\",\"expireIn\":3599,\"refreshTokenExpireIn\":0,\"scope\":\"read\",\"tokenType\":\"bearer\"},\"rawUserInfo\":{\"displayName\":\"埋点测试\",\"departmentId\":\"845748108640911360\",\"createdate\":\"2023-07-18 13:41:51\",\"userId\":\"878675003774599168\",\"online_ticket\":\"OT-879036068236623872\",\"realname\":\"埋点测试\",\"institution\":\"793521660576661504\",\"randomId\":\"ac41616c-7f5c-4484-9f0c-838aef6559c0\",\"department\":\"临时部门\",\"user\":\"et-test\",\"username\":\"et-test\"}}";
        authLionRequest.parseUserInfo(authToken,a);
    }
    public AuthLionRequest(AuthConfig config, AuthStateCache authStateCache) {
        super(config, AuthExtendSource.LIONSSO, authStateCache);
    }

    protected AuthToken getAccessToken(AuthCallback authCallback) {
        String response = this.doPostAuthorizationCodeWhx(authCallback.getCode());
        return this.getAuthToken(response);
    }
     String doPostAuthorizationCodeWhx(String code) {
        String url= accessTokenUrl(code);
        log.debug("before accesstoken:[{}]",url);
         HttpUtils httpUtils= new HttpUtils(config.getHttpConfig());
         String result =httpUtils.post(url);
         log.debug("accessToken response:[{}]",result);
         return result;
    }
    protected AuthUser getUserInfo(AuthToken authToken) {
        String userInfo = this.doGetUserInfoWhx(authToken);
        return parseUserInfo( authToken ,userInfo);
    }
    AuthUser parseUserInfo(AuthToken authToken,String userInfo){
        JSONObject object = JSONObject.parseObject(userInfo);
        log.debug("userInfo:[{}]", JsonUtils.toJsonPrettyString(object));

        this.checkResponse(object);
         AuthUser a= AuthUser.builder()
                .rawUserInfo(object)
                .uuid( object.getString("userId") )
                .username(object.getString("username"))
                .nickname(object.getString("displayName"))
                .token(authToken)
                .avatar(object.getString("online_ticket"))
                .source(this.source.toString()).build();
        log.debug("getUserInfo:[{}]", JsonUtils.toJsonPrettyString(a));
        return a;
    }

     String doGetUserInfoWhx(AuthToken authToken) {
        String url= userInfoUrl(authToken);
        log.debug("before userInfoUrl:[{}]",url);
         HttpUtils httpUtils= new HttpUtils(config.getHttpConfig());
         String result =httpUtils.get(url);
         return result;
//        return new HttpUtils(config.getHttpConfig()).get();
    }

    public AuthResponse revoke(AuthToken authToken) {
        String response = this.doGetRevoke(authToken);
        JSONObject object = JSONObject.parseObject(response);
        this.checkResponse(object);
        AuthResponseStatus status = object.getIntValue("result") == 1 ? AuthResponseStatus.SUCCESS : AuthResponseStatus.FAILURE;
        return AuthResponse.builder().code(status.getCode()).msg(status.getMsg()).build();
    }

    public AuthResponse refresh(AuthToken authToken) {
        String refreshUrl = UrlBuilder.fromBaseUrl(this.source.refresh()).queryParam("grant_type", "refresh_token").queryParam("refresh_token", authToken.getRefreshToken()).queryParam("client_id", this.config.getClientId()).queryParam("client_secret", this.config.getClientSecret()).build();
        String response = (new HttpUtils(this.config.getHttpConfig())).get(refreshUrl);
        return AuthResponse.builder().code(AuthResponseStatus.SUCCESS.getCode()).data(this.getAuthToken(response)).build();
    }

    public Boolean validate(String onlieTicket) {
        String validateUrl = UrlBuilder.fromBaseUrl("http://micro.pro.lion/dev-api/lionkey/lionkey/onlineticket/validate")
                .queryParam("ticket",onlieTicket)
                .build();
        String response = (new HttpUtils(this.config.getHttpConfig())).get(validateUrl);
        if(response==null ||response.isEmpty()){
            return false;
        }
        return true;

    }

    private void checkResponse(JSONObject object) {
        if (object.containsKey("error") || object.containsKey("error_code")) {
            String msg = object.containsKey("error_description") ? object.getString("error_description") : object.getString("error_msg");
            throw new AuthException(msg);
        }
    }

    private AuthToken getAuthToken(String response) {
        JSONObject accessTokenObject = JSONObject.parseObject(response);
        this.checkResponse(accessTokenObject);
        AuthToken a = AuthToken.builder()
                .accessToken(accessTokenObject.getString("access_token"))
                .refreshToken(accessTokenObject.getString("refresh_token"))
                .tokenType(accessTokenObject.getString("token_type"))
                .scope(accessTokenObject.getString("scope"))
                .expireIn(accessTokenObject.getIntValue("expires_in")).build();
        log.debug("authToken:[{}]",JsonUtils.toJsonPrettyString( a ) );
        return a;
    }
}
