package com.practice.mybatis;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.practice.mybatis.entity.Blog;
import com.practice.mybatis.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/5 9:34 下午
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Test
    public void select() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(8);
        System.out.println(blog);
    }

    private DataSource getDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("password");
        return mysqlDataSource;
    }
}
