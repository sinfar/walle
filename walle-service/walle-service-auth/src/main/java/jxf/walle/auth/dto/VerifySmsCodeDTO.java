package jxf.walle.auth.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 手机验证码验证的请求参数
 *
 * @author Axe
 * @since 2020-11-18
 */
@Data
public class VerifySmsCodeDTO  {

    @NotBlank(message = "手机号码不能为空")
    @ApiModelProperty("手机号码")
    private String mobile;


    @ApiModelProperty("区号")
    private String mobilePrefix;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String code;

    @NotBlank(message = "发送类型不能为空")
    @ApiModelProperty("验证码类型")
    private String type;
}
