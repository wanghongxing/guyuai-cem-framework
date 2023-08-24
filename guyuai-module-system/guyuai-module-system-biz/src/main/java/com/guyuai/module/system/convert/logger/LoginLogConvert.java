package com.guyuai.module.system.convert.logger;

import com.guyuai.framework.common.pojo.PageResult;
import com.guyuai.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.guyuai.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import com.guyuai.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import com.guyuai.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
