package cn.hctech2006.statistic.controller;

import cn.hctech2006.statistic.bean.Suggest;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.service.SuggestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "建议收集管理接口")
@RestController
@RequestMapping("/suggest")
public class SuggestController {
    @Autowired
    private SuggestService suggestService;
    @ApiOperation(value = "添加学生建议",notes = "除了必填的其他不要管")
    @RequestMapping(value = "/insert_suggest.do",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "stuId", value = "学号",required = true),
            @ApiImplicitParam(type = "query", name = "detail", value = "意见细节",required = true)
    })
    public ServerResponse insertSuggest(Suggest suggest){
        return suggestService.insertSuggest(suggest);
    }

}
