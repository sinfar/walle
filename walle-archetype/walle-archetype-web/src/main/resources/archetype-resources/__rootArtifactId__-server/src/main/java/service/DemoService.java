#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jxf.walle.common.model.PageDTO;
import ${package}.mapper.DemoMapper;
import ${package}.model.entity.Demo;
import ${package}.model.vo.DemoVO;
import ${package}.model.dto.DemoDTO;
import ${package}.service.convert.DemoConvert;
import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * (Demo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-16 14:33:51
 */
@Service("demoService")
public class DemoService extends ServiceImpl<DemoMapper, Demo> {

    @Resource
    private DemoConvert demoConvert;

    public IPage<DemoVO> page(PageDTO pageDTO, DemoDTO demoDTO) {
        return demoConvert.toVo(this.page(pageDTO.page(), new QueryWrapper<Demo>().setEntity(demoConvert.toDo(demoDTO))));
    }

    public DemoVO getOne(Serializable id) {
        return demoConvert.toVo(this.getById(id));
    }

    public Boolean save(DemoDTO demoDTO) {
        return this.save(demoConvert.toDo(demoDTO));
    }

    public Boolean update(DemoDTO demoDTO) {
        return this.updateById(demoConvert.toDo(demoDTO));
    }

    public Boolean delete(List<Long> idList) {
        return this.removeByIds(idList);
    }
}

