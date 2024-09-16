#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.model.entity.Demo;

/**
 * (Demo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-16 14:33:41
 */
public interface DemoMapper extends BaseMapper<Demo> {

}

