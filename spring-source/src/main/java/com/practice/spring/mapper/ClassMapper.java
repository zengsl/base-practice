package com.practice.spring.mapper;

import com.practice.spring.entity.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {

    public int updateClassName(@Param("name") String className, @Param("id") int id);

    Class getClassByStudentId(@Param("studentId")int studentId);
}
