package com.rory.entity;

import org.hibernate.metamodel.relational.Schema;

import javax.naming.Name;
import javax.persistence.*;

/*
 * 这个Entity的注解会告诉配置文件这是一个实体类
 * 配置文件会根据EntityManagerFactory来判断是否有这个表
 * 如果没有回字段生成
 */
@Entity
@Table(name = "userinfo")
public class User {
    /*最好使用封装之后的类型
     * 因为在后面的类使用的时候需要用到泛型Repository<User, Integer>，这里的Integer就是主键Id
     */
    private Integer id;
    private String name;
    private Integer age;

    @GeneratedValue//这个注解是告诉配置文件这个id是自增的
    @Id//这个注解是告诉配置文件这是一个id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*这个注解是设置表user里面的name字段的长度为20，默认不为空
     * 如果不设置的话默认是255
     */
    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}