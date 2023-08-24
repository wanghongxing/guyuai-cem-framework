package com.guyuai.module.system.service.logger;

import com.guyuai.framework.common.pojo.PageResult;
import com.guyuai.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.guyuai.module.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import com.guyuai.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.guyuai.module.system.convert.logger.LoginLogConvert;
import com.guyuai.module.system.dal.dataobject.logger.LoginLogDO;
import com.guyuai.module.system.dal.mysql.logger.LoginLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志 Service 实现
 */
@Service
@Validated
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO reqVO) {
        return loginLogMapper.selectPage(reqVO);
    }

    @Override
    public List<LoginLogDO> getLoginLogList(LoginLogExportReqVO reqVO) {
        return loginLogMapper.selectList(reqVO);
    }

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        LoginLogDO loginLog = LoginLogConvert.INSTANCE.convert(reqDTO);
        loginLogMapper.insert(loginLog);
    }

}
