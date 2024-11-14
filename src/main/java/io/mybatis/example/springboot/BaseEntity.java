package io.mybatis.example.springboot;

import io.mybatis.provider.Entity;

/**
 * base DO
 *
 * @author WangChen
 * Created on 2023/5/6
 * @since 1.0
 */
//@Entity.Table
public class BaseEntity {
//    @Entity.Column(id = true)
    private Long   id;

    private String bid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
