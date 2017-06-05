package com.wsf.dao.test2;


import com.wsf.pojo.entity.User;

import java.util.List;

/**
 * 用户dao
 */
public interface Test2UserMapper {

//    @Select("select * from tb_user")
    List<User> findAll();

//    @Select("select * from tb_user where id = #{id}")
    User findById(Integer id);

//    @Select("select * from tb_user where name = #{name}")
    User findByName(String name);

//    @Insert("insert into tb_user (age, name, sex) values (#{age}, #{name}, #{sex})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);

//    @Update("update tb_user set age = #{age}, name = #{name}, sex = #{sex} where id = #{id}")
    int update(User user);

//    @Delete("delete from tb_user where id = #{id}")
    int delete(Integer id);
}
