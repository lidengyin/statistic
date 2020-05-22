package cn.hctech2006.statistic.controller;


import cn.hctech2006.statistic.bean.Evaluate;
import cn.hctech2006.statistic.bean.Evaresult;
import cn.hctech2006.statistic.bean.Evasmall;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.service.EvaluateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "毕业要求评估管理接口")
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;
    @ApiOperation(value = "添加毕业要求大项,前端暂时不要动")

    @RequestMapping(value = "/insert_evaluate",method = RequestMethod.POST)
    public ServerResponse insertEvaluate(Evaluate evaluate){
        return evaluateService.insertEValuate(evaluate);
    }
    @ApiOperation(value = "添加毕业要求小项，,前端暂时不要动")
    @RequestMapping(value = "/insert_evasmall",method = RequestMethod.POST)
    public ServerResponse insertEvasmall(Evasmall evasmall){
        return evaluateService.insertEVasmall(evasmall);
    }
    @ApiOperation(value = "测试毕业要求分类列表存储",notes = "加上逗号，列表传素" +
            "[\n" +
            "  {\n" +
            "    \"esId\": \"string\",毕业要求小项编号，必填\n" +
            "    \"evaId\": \"string\",毕业要求大项编号，必填\n" +
            "    \"grade\": \"string\",毕业要求达标情况,\n" +
            "    \"id\": 0,这个不需要管，自动生成\n" +
            "    \"stuId\": \"string，学生学号，必填\"\n" +
            "  }\n" +
            "]")

    @RequestMapping(value = "/insert_evaresult",method = RequestMethod.POST)
    public ServerResponse insertEvasmall(@RequestBody Evaresult evaresult){
        return evaluateService.insertEvaresult(evaresult);
    }
    @ApiOperation(value = "返回给前端毕业要求项列表")
    @RequestMapping(value = "/get_all_evaluate",method = RequestMethod.GET)
    public ServerResponse getAllEvaluateVo(){
        return evaluateService.getAllEvaluateVo();
    }
}
