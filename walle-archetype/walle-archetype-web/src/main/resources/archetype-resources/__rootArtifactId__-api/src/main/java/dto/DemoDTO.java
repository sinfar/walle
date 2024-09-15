#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.dto;

import com.isay.starter.base.BaseReq;
import javax.validation.constraints.NotBlank;
import lombok.Data;
/**
 * 相关的请求参数
 *
 * @author Axe
 * @since 2020-06-08
 */
@Data
public class DemoDTO extends BaseReq {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;


}
