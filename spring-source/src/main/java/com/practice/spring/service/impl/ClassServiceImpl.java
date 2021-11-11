package com.practice.spring.service.impl;

import com.practice.spring.entity.Class;
import com.practice.spring.mapper.ClassMapper;
import com.practice.spring.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/3 2:28 下午
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Class getClassByStudentId(int studentId) {
        return classMapper.getClassByStudentId(studentId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Class getClassByStudentId2(int studentId) {
        return classMapper.getClassByStudentId(studentId);
    }
}
