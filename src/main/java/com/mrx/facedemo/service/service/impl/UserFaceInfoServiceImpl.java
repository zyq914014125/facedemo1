package com.mrx.facedemo.service.service.impl;


import com.mrx.facedemo.dao.MybatisUserFaceInfoMapper;
import com.mrx.facedemo.entity.UserFaceInfo;
import com.mrx.facedemo.service.service.UserFaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {


    @Autowired
    private MybatisUserFaceInfoMapper userFaceInfoMapper;

    @Override
    public void insertSelective(UserFaceInfo userFaceInfo) {
        userFaceInfoMapper.insertUserFaceInfo(userFaceInfo);
    }
}
