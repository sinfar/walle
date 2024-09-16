#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.service.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package}.model.entity.Demo;
import ${package}.model.vo.DemoVO;
import ${package}.model.dto.DemoDTO;

import java.util.List;
import org.mapstruct.Mapper;

/**
 * (Demo)表服务接口
 *
 * @author makejava
 * @since 2024-09-16 14:38:07
 */
@Mapper(componentModel = "spring")
public interface DemoConvert {

    DemoVO toVo(Demo demo);

    List<DemoVO> toVo(List<Demo> demo);

    Page<DemoVO> toVo(Page<Demo> demo);

    Demo toDo(DemoDTO demoDTO);
}

