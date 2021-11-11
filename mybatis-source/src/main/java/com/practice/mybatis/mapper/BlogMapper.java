package com.practice.mybatis.mapper;

import com.practice.mybatis.entity.Blog;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/5 9:39 下午
 */
public interface BlogMapper {

    Blog selectBlog(int id);
}
