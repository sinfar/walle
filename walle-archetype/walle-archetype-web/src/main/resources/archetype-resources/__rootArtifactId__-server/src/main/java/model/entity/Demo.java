#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import jxf.walle.mysql.BaseEntity;
import lombok.Data;
import java.io.Serializable;



/**
 * (Demo)表实体类
 *
 * @author makejava
 * @since 2024-09-16 14:33:47
 */
@Data
@TableName("demo")
public class Demo extends BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId
    private Integer id;

    /**
     * 名称
     */
    private String name;

}

