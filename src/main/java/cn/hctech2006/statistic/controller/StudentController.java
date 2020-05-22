package cn.hctech2006.statistic.controller;

import cn.hctech2006.statistic.bean.Student;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "学生信息接口")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired

    private StudentService studentService;

    /**
     * 学生登记信息接口
     * @param student
     * @return
     */
    @ApiOperation(value = "学生个人信息填写接口")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "stuId", value = "学号", required = true),
            @ApiImplicitParam(type = "query", name = "name", value = "姓名", required = true),
            @ApiImplicitParam(type = "query", name = "sex", value = "性别", required = true),
            @ApiImplicitParam(type = "query", name = "classId", value = "班级编号/班级", required = true),
            @ApiImplicitParam(type = "query", name = "phone", value = "手机", required = true),
            @ApiImplicitParam(type = "query", name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(type = "query", name = "empId", value = "是否就业编号", required = true),
            @ApiImplicitParam(type = "query", name = "company", value = "就业单位", required = true),
            @ApiImplicitParam(type = "query", name = "address", value = "单位地址", required = true),
            @ApiImplicitParam(type = "query", name = "cateId", value = "单位性质编号", required = true),
            @ApiImplicitParam(type = "query", name = "induId", value = "工作行业编号", required = true)

    })
    @RequestMapping(value = "/insert_student.do",method = RequestMethod.POST)
    public ServerResponse insertStudent(Student student){
        return studentService.insertStudent(student);
    }

    //获取学生个人详细信息
    @ApiOperation(value = "返回封装给前端的测评结果信息")
    @ApiImplicitParam(type = "query", name = "stuId", value = "学生学号", defaultValue = "201811621209", required = true)
    @RequestMapping(value = "/get_student.do",method = RequestMethod.GET)
    public ServerResponse getDetail(String stuId){
        return studentService.getDetail(stuId);
    }

    @ApiOperation(value = "分类获取学生列表，暂时不分页",notes = "注意这是组合查询")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "classId", value = "班级编号",required = false),
            @ApiImplicitParam(type = "query", name = "empId", value = "就业编号",required = false),
            @ApiImplicitParam(type = "query", name = "cateId", value = "单位性质编号",required = false),
            @ApiImplicitParam(type = "query", name = "induId", value = "就业行业编号",required = false),
    })
    @RequestMapping(value = "/get_all_student.do",method = RequestMethod.GET)
    public ServerResponse selectStudent(String classId, String empId, String cateId, String induId){
        return studentService.selectStudent(classId, empId, cateId, induId);
    }
    @ApiOperation(value = "获取每班有效统计人数")
    @RequestMapping(value = "/get_class_count.do",method = RequestMethod.GET)
    public ServerResponse checkCountByClassId(){
        return studentService.getAllCount();
    }

}
