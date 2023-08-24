package com.guyuai.module.system.convert.social;

import com.guyuai.module.system.api.social.dto.SocialUserBindReqDTO;
import com.guyuai.module.system.api.social.dto.SocialUserUnbindReqDTO;
import com.guyuai.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import com.guyuai.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO);

}
