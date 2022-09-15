package com.wj.admin.model.controller;


import com.wj.admin.vo.QuestionnaireAddVO;
import com.wj.admin.model.service.QuestionnaireService;
import com.wj.admin.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

