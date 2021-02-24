package com.mrx.facedemo.dao;


import com.mrx.facedemo.entity.FaceUserInfo;
import com.mrx.facedemo.entity.UserFaceInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface MybatisUserFaceInfoMapper {

    @Select("SELECT name,create_time from user_face_info")
    List<UserFaceInfo> findUserFaceInfoList();

    @Insert("INSERT INTO user_face_info (group_id,face_id,name,face_feature) VALUES (#{groupId},#{faceId},#{name},#{faceFeature})")
    void insertUserFaceInfo(UserFaceInfo userFaceInfo);

    @Select("select face_id,name,face_feature from user_face_info")
    List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);
}
