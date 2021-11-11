package com.practice.spring.service;

import com.practice.spring.entity.Class;
import org.apache.ibatis.annotations.Param;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/3 2:27 下午
 */
public interface ClassService {

    Class getClassByStudentId(int studentId);

    Class getClassByStudentId2(int studentId);
}
