package com.practice.spring.service;

import com.practice.spring.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/3 2:27 下午
 */
public interface StudentService {

    StudentEntity getStudentById(int id);

    StudentEntity getStudentById2(int id);

    int addStudent(StudentEntity student);

    int updateStudentName(@Param("name") String name, @Param("id") int id);

    StudentEntity getStudentByIdWithClassInfo(int id);
}
