package com.wsf.service.api;


import com.wsf.pojo.dto.UserDTO;

import java.util.List;

/**
 * 用户service接口
 */
public interface IUserService {

    /**
     * 查询全部用户
     * @return
     */
    List<UserDTO> findAll();

    /**
     * 按id查询用户
     * @param id
     * @return
     */
    UserDTO findById(Integer id);

    /**
     * 按姓名查询用户
     * @param name
     * @return
     */
    UserDTO findByName(String name);

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    int updae(UserDTO userDTO);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Integer id);
}
