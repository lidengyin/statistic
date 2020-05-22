package cn.hctech2006.statistic.service.impl;

import cn.hctech2006.statistic.bean.Category;
import cn.hctech2006.statistic.bean.Class;
import cn.hctech2006.statistic.bean.Employ;
import cn.hctech2006.statistic.bean.Industry;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.CategoryMapper;
import cn.hctech2006.statistic.mapper.ClassMapper;
import cn.hctech2006.statistic.mapper.EmployMapper;
import cn.hctech2006.statistic.mapper.IndustryMapper;
import cn.hctech2006.statistic.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private EmployMapper employMapper;
    @Autowired
    private ClassMapper classMapper;
    @Override
    public ServerResponse insertClass(Class cla) {
        cla.setClassId(UUID.randomUUID().toString());

        int count =  classMapper.insert(cla);
        if (count > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
    }

    @Override
    public ServerResponse insertCategory(Category category) {
        category.setCateId(UUID.randomUUID().toString());
        int count =  categoryMapper.insert(category);
        if (count > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
    }


    @Override
    public ServerResponse insertIndustry(Industry industry) {
        industry.setIndustryId(UUID.randomUUID().toString());
        int count =  industryMapper.insert(industry);
        if (count > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");

    }

    @Override
    public ServerResponse insertEmploy(Employ employ) {
        employ.setEmpId(UUID.randomUUID().toString());
        int count =  employMapper.insert(employ);
        if (count > 0){
        return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByError("添加失败");
        }

    @Override
    public ServerResponse getAllClass() {
        List<Class> classList = classMapper.selectAll();
        return ServerResponse.createBySuccess(classList);
    }

    @Override
    public ServerResponse getAllCategory() {
        return ServerResponse.createBySuccess(categoryMapper.selectAll());
    }

    @Override
    public ServerResponse getAllIndustry() {
        return ServerResponse.createBySuccess(industryMapper.selectAll());
    }

    @Override
    public ServerResponse getAllEmploy() {
        return ServerResponse.createBySuccess(employMapper.selectAll());
    }

}
