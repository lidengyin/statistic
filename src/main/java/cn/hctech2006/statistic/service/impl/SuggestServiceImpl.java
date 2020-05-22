package cn.hctech2006.statistic.service.impl;

import cn.hctech2006.statistic.bean.Suggest;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.StudentMapper;
import cn.hctech2006.statistic.mapper.SuggestMapper;
import cn.hctech2006.statistic.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    private SuggestMapper suggestMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public ServerResponse insertSuggest(Suggest suggest) {
        int hasalready = suggestMapper.checkByStuId(suggest.getStuId());
        int count = 0;
        if (hasalready > 0){
            count = suggestMapper.updateDetailByStuId(suggest.getStuId(),suggest.getDetail());
        }else{
            count =  suggestMapper.insert(suggest);
        }

        if (count > 0){
            int result = studentMapper.updateStatus(suggest.getStuId());
            return ServerResponse.createBySuccess("注册/修改成功");
        }
        return ServerResponse.createByError("注册失败");
    }

    @Override
    public Suggest selectSuggestByStuId(String stuId) {
        return suggestMapper.selectByStuId(stuId);
    }
}
