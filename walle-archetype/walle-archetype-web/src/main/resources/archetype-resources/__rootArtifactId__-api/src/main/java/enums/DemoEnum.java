#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.enums;

import java.io.Serializable;
import jxf.walle.common.model.IDict;

/**
 * @author: Simon
 * @Data:2024/9/16
 */
public enum DemoEnum implements IDict<Integer> {
    SYSTEM_SESSION(1, "枚举项1");

    private Integer code;
    private String text;

    DemoEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
}
