package com.th.academy.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.th.academy.edu.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.th.academy.edu.query.TeacherQuery;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Cary
 * @since 2023-03-08
 */
public interface TeacherService extends IService<Teacher> {


    /**
     * 页面查询
     *
     * @param pageParam    页面参数
     * @param teacherQuery 老师查询
     * @return {@link Page}<{@link Teacher}>
     */
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);
}
