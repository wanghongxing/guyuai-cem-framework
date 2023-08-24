package com.guyuai.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 社交绑定登录 Request VO，使用 code 授权码 + 账号密码")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSocialLoginReqVO {

    @Schema(description = "社交平台的类型,参见 UserSocialTypeEnum 枚举值")
    private Integer type;

    @Schema(description = "授权码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "授权码不能为空")
    private String code;

//    @Schema(description = "state", requiredMode = Schema.RequiredMode.REQUIRED, example = "9b2ffbc1-7425-4155-9894-9d5c08541d62")
//    @NotEmpty(message = "state 不能为空")
@Schema(description = "state")
private String state;

}
