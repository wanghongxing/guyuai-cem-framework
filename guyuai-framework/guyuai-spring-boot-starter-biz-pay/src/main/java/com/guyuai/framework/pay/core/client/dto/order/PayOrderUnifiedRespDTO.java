package com.guyuai.framework.pay.core.client.dto.order;

import lombok.Data;

/**
 * 统一下单 Response DTO
 *
 * @author 谷雨源码
 */
@Data
public class PayOrderUnifiedRespDTO {

    /**
     * 展示模式
     */
    private String displayMode;
    /**
     * 展示内容
     */
    private String displayContent;

}
