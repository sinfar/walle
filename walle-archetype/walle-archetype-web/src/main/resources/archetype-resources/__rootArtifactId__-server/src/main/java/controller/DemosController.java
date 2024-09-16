#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import jxf.walle.common.model.PageDTO;
import ${package}.model.vo.DemoVO;
import ${package}.model.dto.DemoDTO;
import ${package}.service.DemoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Demo)表控制层
 *
 * @author makejava
 * @since 2024-09-16 14:33:41
 */
@RestController
@Api(tags = "Demo Management")
@RequestMapping("demo")
public class DemosController {
    /**
     * 服务对象
     */
    @Resource
    private DemoService demoService;

    @GetMapping
    public IPage<DemoVO> page(PageDTO pageDTO, DemoDTO demoDTO) {
        return demoService.page(pageDTO, demoDTO);
    }

    @GetMapping("{id}")
    public DemoVO getOne(@PathVariable Serializable id) {
        return this.demoService.getOne(id);
    }

    @PostMapping
    public Boolean save(@RequestBody DemoDTO demoDTO) {
        return this.demoService.save(demoDTO);
    }

    @PutMapping
    public Boolean update(@RequestBody DemoDTO demoDTO) {
        return this.demoService.update(demoDTO);
    }

    @DeleteMapping
    public Boolean delete(@RequestParam("idList") List<Long> idList) {
        return this.demoService.delete(idList);
    }
}

