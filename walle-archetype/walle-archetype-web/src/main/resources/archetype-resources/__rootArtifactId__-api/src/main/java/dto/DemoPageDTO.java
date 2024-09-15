#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )

package ${package}.dto;

import com.isay.starter.base.BasePageReq;
import lombok.Data;
/**
 * 分页查询信息
 *
 * @author Axe
 * @since 2020-06-08
 */
@Data
public class DemoPageDTO extends BasePageReq {

     /**
      * 关键字搜索
      */
     private String keyword;
}
