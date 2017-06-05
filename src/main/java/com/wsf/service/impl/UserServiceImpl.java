package com.wsf.service.impl;

import com.github.pagehelper.PageHelper;
import com.wsf.dao.test1.Test1UserMapper;
import com.wsf.pojo.dto.UserDTO;
import com.wsf.pojo.entity.User;
import com.wsf.service.api.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户service实现类
 */
@Service
@Transactional("test1TransactionManager")
public class UserServiceImpl implements IUserService {

    @Autowired
    private Test1UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        PageHelper.startPage(1,20);
        List<User> userList = this.userMapper.findAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = this.userMapper.findById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findByName(String name) {
        User user = this.userMapper.findByName(name);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public int save(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int count = this.userMapper.save(user);
        return count;
    }

    @Override
    public int updae(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int count = this.userMapper.update(user);
        return count;
    }

    @Override
    public int delete(Integer id) {
        int count = this.userMapper.delete(id);
        return count;
    }
}
