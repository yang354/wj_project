package com.wj.admin.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wj.admin.model.entity.User;
import org.apache.ibatis.annotations.Select;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from wj_user where username=#{username} or phone=#{phone} limit 1")
    User selectUser(String phone, String username);
}
