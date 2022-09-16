package com.wj.admin.model.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wj.admin.model.entity.User;
import com.wj.admin.vo.RegisterVO;
import com.wj.admin.vo.UserEditVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
public interface UserService extends IService<User> {


    void register(RegisterVO registerVO);

    User findUserByUserName(String username);

    void edit(UserEditVO userEditVO);

    void del(Integer userId);
}
