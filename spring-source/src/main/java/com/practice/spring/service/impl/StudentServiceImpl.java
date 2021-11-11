package com.practice.spring.service.impl;

import com.practice.spring.entity.StudentEntity;
import com.practice.spring.mapper.StudentMapper;
import com.practice.spring.service.ClassService;
import com.practice.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/3 2:28 下午
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {


    @Autowired
    private ClassService classService;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentEntity getStudentById(int id) {
        classService.getClassByStudentId(id);
        return studentMapper.getStudentById(id);
    }


    @Override
    public StudentEntity getStudentById2(int id) {
        classService.getClassByStudentId2(id);
        return studentMapper.getStudentById(id);
    }

    @Override
    public int addStudent(StudentEntity student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudentName(String name, int id) {
        return studentMapper.updateStudentName(name,id);
    }

    @Override
    public StudentEntity getStudentByIdWithClassInfo(int id) {
        return studentMapper.getStudentByIdWithClassInfo(id);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        StudentService studentService = context.getBean(StudentService.class);
        StudentEntity studentById = studentService.getStudentById2(1);
//        StudentEntity studentById = studentService.getStudentById(1);
        System.out.println(studentById);
    }
}
