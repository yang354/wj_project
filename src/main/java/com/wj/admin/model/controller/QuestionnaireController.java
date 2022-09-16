package com.wj.admin.model.controller;


import com.wj.admin.model.entity.Questionnaire;
import com.wj.admin.vo.QuestionnaireAddVO;
import com.wj.admin.model.service.QuestionnaireService;
import com.wj.admin.util.Result;
import com.wj.admin.vo.QuestionnaireEditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
@Api(value = "后台问卷管理",tags = "后台问卷管理",description = "后台问卷管理")
@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;


    /**
     * 新建问卷
     * @return
     */
    @ApiOperation("新建问卷")
    @ApiImplicitParam(value = "问卷对象",name = "questionnaireAddVO",dataType = "QuestionnaireAddVO")
    @PostMapping("/add")
    public Result add(@RequestBody QuestionnaireAddVO questionnaireAddVO) {

        questionnaireService.add(questionnaireAddVO);
        return Result.ok().msg("新建问卷成功");

    }

    /**
     * 修改问卷
     * @return
     */
    @ApiOperation("修改问卷")
    @ApiImplicitParam(value = "问卷对象",name = "questionnaireEditVO",dataType = "QuestionnaireEditVO")
    @PostMapping("/edit")
    public Result edit(@RequestBody QuestionnaireEditVO questionnaireEditVO) {

        questionnaireService.edit(questionnaireEditVO);
        return Result.ok().msg("编辑问卷成功");

    }

    /**
     * 删除问卷
     * @return
     */
    @ApiOperation("删除问卷")
    @ApiImplicitParam(value = "问卷Id",name = "questionnaireId",dataType = "Integer")
    @PostMapping("/del")
    public Result del(Integer questionnaireId) {

        questionnaireService.del(questionnaireId);
        return Result.ok().msg("删除问卷成功");

    }


    /**
     * 查看一篇问卷
     * @return
     */
    @ApiOperation("查看一篇问卷")
    @ApiImplicitParam(value = "问卷Id",name = "questionnaireId",dataType = "Integer")
    @PostMapping("/search")
    public Result search(Integer questionnaireId) {

        Questionnaire questionnaire = questionnaireService.search(questionnaireId);
        return Result.ok(questionnaire).msg("查看一篇问卷成功");

    }

    /**
     * 查看所有问卷
     * @return
     */
    @ApiOperation("查看所有问卷")
    @PostMapping("/searchAll")
    public Result searchAll() {
        List<Questionnaire> list = questionnaireService.searchAll();
        return Result.ok(list).msg("查看所有问卷成功");

    }
}

