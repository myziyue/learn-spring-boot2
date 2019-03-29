package com.myziyue.learn.ch03.mvc.service;

import com.myziyue.learn.ch03.mvc.entity.User;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务类<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
public interface UserService {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> allUser();

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 更新用户状态
     *
     * @param id
     * @param type
     */
    void updateUser(Long id, Integer type);
}
