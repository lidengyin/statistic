package cn.hctech2006.statistic.controller;

import cn.hctech2006.statistic.bean.Category;
import cn.hctech2006.statistic.bean.Class;
import cn.hctech2006.statistic.bean.Employ;
import cn.hctech2006.statistic.bean.Industry;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.service.ToolService;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "字典工具管理接口")
@RequestMapping("/tool")
@RestController
public class ToolController {
    @Autowired
    private ToolService toolService;
    @RequestMapping(value = "/insert_category.do",method = RequestMethod.POST)
    @ApiOperation(value = "添加单位性质情况，前端暂时不要动")
    @ApiImplicitParam(type = "query", name = "name", value = "单位性质",required = true)
    public ServerResponse insertCategory(Category category){
        return toolService.insertCategory(category);
    }
    @ApiOperation(value = "添加毕业班班级情况，前端暂时不要动")
    @ApiImplicitParam(type = "query", name = "className", value = "班级名，比如计科1162",required = true)
    @RequestMapping(value = "/insert_class.do",method = RequestMethod.POST)
    public ServerResponse insertClass(Class cla){
        return toolService.insertClass(cla);
    }
    @ApiOperation(value = "添加所在行业情况，前端暂时不要动")
    @ApiImplicitParam(type = "query", name = "name", value = "行业名称",required = true)
    @RequestMapping(value = "/insert_industry.do",method = RequestMethod.POST)
    public ServerResponse insertIndustry(Industry industry){
        return toolService.insertIndustry(industry);
    }
    @ApiOperation(value = "添加就业情况，前端暂时不要动")
    @ApiImplicitParam(type = "query", name = "name", value = "是否就业",required = true)
    @RequestMapping(value = "/insert_employ.do",method = RequestMethod.POST)
    public ServerResponse insertEmploy(Employ employ){
        return toolService.insertEmploy(employ);
    }
    @ApiOperation(value = "获取全部是否就业选项")
    @RequestMapping(value = "/select_all_employ.do", method = RequestMethod.GET)
    public ServerResponse getAllEmploy(){
        return toolService.getAllEmploy();
    }
    @ApiOperation(value = "获取全部就业行业选项")
    @RequestMapping(value = "/select_all_industry.do", method = RequestMethod.GET)
    public ServerResponse getAllIndustry(){
        return toolService.getAllIndustry();
    }
    @ApiOperation(value = "获取全部毕业班选项")
    @RequestMapping(value = "/select_all_class.do", method = RequestMethod.GET)
    public ServerResponse getAllClass(){
        return toolService.getAllClass();
    }
    @ApiOperation(value = "获取全部单位性质选项")
    @RequestMapping(value = "/select_all_category.do", method = RequestMethod.GET)
    public ServerResponse getAllCategory(){
        return toolService.getAllCategory();
    }
}
