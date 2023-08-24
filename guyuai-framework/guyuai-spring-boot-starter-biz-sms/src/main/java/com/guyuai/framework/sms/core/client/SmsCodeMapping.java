package com.guyuai.framework.sms.core.client;

import com.guyuai.framework.common.exception.ErrorCode;
import com.guyuai.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.function.Function;

/**
 * 将 API 的错误码，转换为通用的错误码
 *
 * @see SmsCommonResult
 * @see SmsFrameworkErrorCodeConstants
 *
 * @author 谷雨源码
 */
public interface SmsCodeMapping extends Function<String, ErrorCode> {
}
