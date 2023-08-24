package com.guyuai.framework.sms.core.client.impl.debug;

import com.guyuai.framework.common.exception.ErrorCode;
import com.guyuai.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.guyuai.framework.sms.core.client.SmsCodeMapping;
import com.guyuai.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author 谷雨源码
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
