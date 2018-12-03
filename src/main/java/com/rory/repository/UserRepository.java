package com.rory.repository;


import com.rory.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
@NoRepositoryBean
public interface UserRepository extends Repository<User, Integer> {

    //保存
    void save(User user);

    //删除
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from user where id=:id")
    void deleteById(@Param("id") int id);



    /* 在注解中使用原生的sql
     * nativeQuery是指能否支持原生态的查询，默认是false
     * value里面的user指的是表名
     */
    @Query(nativeQuery = true, value = "select count(1) from user")
    int count();


    //查找全部学生信息
    List<User> findAll();


    User findByName(String name);


    //查询id最大的用户的信息
    /*需要注意的是：
     * 1：方法名是自己随便取的
     * 2：在Query里面的查询语句里面的User表示的是类名而不是表名
     * 3：查询所有不能使用 select * ，* 是不能被识别的，要查询所有可以使用 select 别名
     */
    @Query("select u from User u where id=(select max(id) from User)")
    User findMaxIdUser();
}