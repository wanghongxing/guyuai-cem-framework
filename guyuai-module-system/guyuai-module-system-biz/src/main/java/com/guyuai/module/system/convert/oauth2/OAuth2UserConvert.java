package com.guyuai.module.system.convert.oauth2;

import com.guyuai.module.system.controller.admin.oauth2.vo.user.OAuth2UserInfoRespVO;
import com.guyuai.module.system.controller.admin.oauth2.vo.user.OAuth2UserUpdateReqVO;
import com.guyuai.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import com.guyuai.module.system.dal.dataobject.dept.DeptDO;
import com.guyuai.module.system.dal.dataobject.dept.PostDO;
import com.guyuai.module.system.dal.dataobject.user.AdminUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OAuth2UserConvert {

    OAuth2UserConvert INSTANCE = Mappers.getMapper(OAuth2UserConvert.class);

    OAuth2UserInfoRespVO convert(AdminUserDO bean);
    OAuth2UserInfoRespVO.Dept convert(DeptDO dept);
    List<OAuth2UserInfoRespVO.Post> convertList(List<PostDO> list);

    UserProfileUpdateReqVO convert(OAuth2UserUpdateReqVO bean);

}
