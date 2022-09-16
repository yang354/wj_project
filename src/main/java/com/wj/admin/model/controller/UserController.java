package com.wj.admin.model.controller;



import com.wj.admin.model.service.UserService;
import com.wj.admin.util.Result;
import com.wj.admin.vo.RegisterVO;
import com.wj.admin.vo.UserEditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
@Api(value = "后台用户管理",tags = "后台用户管理",description = "后台用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 注册
     *
     * @return
     */
    @ApiOperation("注册")
    @ApiImplicitParam(value = "registerVO",name = "registerVO",dataType = "RegisterVO")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterVO registerVO) {
        //先写一个功能短信发送

        userService.register(registerVO);
        return Result.ok().msg("注册成功");
    }

    /**
     * 修改用户
     *
     * @return
     */
    @ApiOperation("修改用户")
    @ApiImplicitParam(value = "用户对象",name = "userEditVO",dataType = "UserEditVO")
    @PostMapping("/edit")
    public Result edit(@RequestBody UserEditVO userEditVO) {


        userService.edit(userEditVO);
        return Result.ok().msg("修改用户成功");
    }

    /**
     * 删除用户
     *
     * @return
     */
    @ApiOperation("删除用户")
    @ApiImplicitParam(value = "用户Id",name = "userId",dataType = "Integer")
    @PostMapping("/del")
    public Result del(Integer userId) {
        userService.del(userId);
        return Result.ok().msg("删除用户成功");
    }
}

