package com.guyuai.framework.common.util.object;

import com.guyuai.framework.common.pojo.PageParam;

/**
 * {@link com.guyuai.framework.common.pojo.PageParam} 工具类
 *
 * @author 谷雨源码
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
