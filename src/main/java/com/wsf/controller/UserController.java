package com.wsf.controller;

import com.wsf.pojo.dto.UserDTO;
import com.wsf.service.api.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户controller
 */
@Controller
@RequestMapping("/user")
@Api(description = "用户相关API")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询全部用户")
    public List<UserDTO> findAll() {
        return this.userService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path")
    })
    public UserDTO findAll(@PathVariable Integer id) {
        return this.userService.findById(id);
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按name查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "string", paramType = "path")
    })
    public UserDTO findAll(@PathVariable String name) {
        return this.userService.findByName(name);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加用户")
    public List<UserDTO> save(UserDTO userDTO) {
        this.userService.save(userDTO);
        logger.debug("新增数据主键：" + userDTO.getId());
        return this.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改用户")
    public List<UserDTO> update(UserDTO userDTO) {
        this.userService.updae(userDTO);
        return this.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按id删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path")
    })
    public List<UserDTO> delete(@PathVariable Integer id) {
        this.userService.delete(id);
        return this.findAll();
    }
}
