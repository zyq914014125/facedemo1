package com.mrx.facedemo.controller;
import com.mrx.facedemo.dao.MybatisUserFaceInfoMapper;
import com.mrx.facedemo.entity.UserFaceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserListController {

    @Autowired
    MybatisUserFaceInfoMapper userFaceInfoMapper;

    @GetMapping("/userInfo")
    public List<UserFaceInfo> getUserInfo()
    {
        List<UserFaceInfo>  list = userFaceInfoMapper.findUserFaceInfoList();
        return list;
    }
}
