package io.mybatis.example.springboot.model;

import io.mybatis.example.springboot.BaseEntity;
import io.mybatis.provider.Entity;

/**
 * User
 *
 * @author WangChen
 * Created on 2023/5/6
 * @since 1.0
 */
@Entity.Table("user")
public class User extends BaseEntity {
//    @Entity.Column(id = true)
//    private Long   id;
    @Entity.Column("name")
    private String username;
    @Entity.Column
    private String sex;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //省略set和get方法
}
