package cn.hctech2006.statistic.controller;

import cn.hctech2006.statistic.bean.Subject;
import cn.hctech2006.statistic.bean.Subresult;
import cn.hctech2006.statistic.bean.Subsmall;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.SubjectMapper;
import cn.hctech2006.statistic.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequestExtensionsKt;

import java.util.List;

@Api(tags = "学科标准信息")
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @ApiOperation(value = "添加科目大项，前端暂时不要动")
    @RequestMapping(value = "/insert_subject",method = RequestMethod.POST)
    public ServerResponse insertSubject(Subject subject){
        return subjectService.insertSubject(subject);
    }
    @ApiOperation(value = "添加科目小项，前端暂时不要动")
    @RequestMapping(value = "/insert_subsmall",method = RequestMethod.POST)
    public ServerResponse insertSubsmall(Subsmall subsmall){
        return subjectService.insertSubsmall(subsmall);
    }
    @ApiOperation(value = "生成学科测评结果", notes = "" +
            "[\n" +
            "  {\n" +
            "    \"grade\": \"string\",测评结果\n" +
            "    \"id\": 0,不用管\n" +
            "    \"smId\": \"string\",科目小项编号\n" +
            "    \"stuId\": \"string\",学号\n" +
            "    \"subId\": \"string\",科目大项编号\n" +
            "  }\n" +
            "]")
    @RequestMapping(value = "/insert_subresult",method = RequestMethod.POST)
    public ServerResponse insertSubresult(@RequestBody Subresult subresult){
        return subjectService.insertSubresult(subresult);
    }
    @ApiOperation(value = "返回前端封装科目题目信息")
    @RequestMapping(value = "/get_all_subject",method = RequestMethod.GET)
    public ServerResponse getAllSubJectVo(){
        return subjectService.getAllSubJectVo();
    }


}
