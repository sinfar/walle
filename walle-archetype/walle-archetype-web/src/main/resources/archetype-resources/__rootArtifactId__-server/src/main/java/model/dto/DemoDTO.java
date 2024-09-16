#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;


/**
 * (Demo)表实体类
 *
 * @author makejava
 * @since 2024-09-16 14:33:55
 */
@Data
public class DemoDTO implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

}

