package io.mybatis.example.springboot.controller;

import io.mybatis.example.springboot.mapper.UserMapper;
import io.mybatis.example.springboot.model.User;
import io.mybatis.mapper.example.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * t
 *
 * @author WangChen
 * Created on 2023/5/6
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/save")
    public String save() {
        User user = new User();
        user.setUsername("wc");
        user.setSex("M");
        user.setBid("123123123");
        userMapper.insert(user);
        return "s";
    }

    @GetMapping("/getUser/{bid}")
    public User getUser(@PathVariable("bid") String bid) {
        Example<User> example = new Example<>();
        example.createCriteria().andEqualTo(User::getBid, bid);
//        return userMapper.selectOneByExample(example).orElse(null);
        userMapper.getByBids(Collections.singletonList(bid));
        return userMapper.getByBid(bid);
    }
}
