package com.guyuai.module.infra.dal.mysql.db;

import com.guyuai.framework.mybatis.core.mapper.BaseMapperX;
import com.guyuai.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author 谷雨源码
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
