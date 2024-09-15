#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户数据，用于个人页面
 *
 * @author Axe
 * @since 2020-06-08
 */
@Data
public class DemoVO implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}
