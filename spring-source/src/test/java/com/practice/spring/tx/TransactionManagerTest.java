package com.practice.spring.tx;

import com.practice.spring.entity.Class;
import com.practice.spring.entity.StudentEntity;
import com.practice.spring.service.ClassService;
import com.practice.spring.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * https://mybatis.org/mybatis-3/zh
 * http://mybatis.org/spring/zh/
 * 事务拦截器 TransactionInterceptor（TransactionAspectSupport）
 * #BeanFactoryTransactionAttributeSourceAdvisor
 * TransactionAttributeSourcePointcut
 * #org.springframework.transaction.annotation.AnnotationTransactionAttributeSource(getTransactionAttribute方法解析方法注解，一般在bean初始化的时候就解析了，后面拦截都直接从缓存中获取)
 * @Transactional 注解解析类SpringTransactionAnnotationParser
 *  TransactionAspectSupport.bindToThread()
 * TransactionSynchronizationManager
 *
 * 事务是和数据源绑定在一起的
 *
 * 利用ThreadLocal来存放当前线程的connection 还会有很多的ThreadLocal变量来存储事务的resource（数据源对应的connection），具体在TransactionSynchronizationManager中
 * "事务状态DefaultTransactionStatus"中存了"事务对象DataSourceTransactionObject"对象和其他几个状态属性，"事务对象"中存放了连接以及其他几个属性
 * TransactionInfo对象存放了"事务状态"、"事务管理器"、"旧TransactionInfo"、"事务属性"、"切入点（com.practice.spring.service.impl.StudentServiceImpl.getStudentById）"，并且绑定到ThreadLocal
 *
 * spring如何控制事务中的连接和执行sql的连接是同一个?
 * 事务中获取的连接都存放在了TransactionSynchronizationManager中ThreadLocal对象中,
 * 在查询数据库的时候Spring的DataSourceUtils获取连接->最终调到TransactionSynchronizationManager
 *（如：mybatis）会通过mybatis的SpringManagedTransaction(SpringManagedTransactionFactory)->DataSourceUtils
 *
 *
 * （注解解析过程依赖jdk相关类：反射，AnnotationInvocationHandler）
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/3 1:46 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TransactionManagerTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @Test
    public void test1() {
        StudentEntity student = studentService.getStudentById(1);
        System.out.println(student);
    }


    @Test
    public void test2() {
        Class classInfo = classService.getClassByStudentId(1);
        System.out.println(classInfo);
    }
}
