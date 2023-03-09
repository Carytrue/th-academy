package com.th.academy.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.th.academy.common.utils.ResponseResult;
import com.th.academy.edu.pojo.Teacher;
import com.th.academy.edu.query.TeacherQuery;
import com.th.academy.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 老师控制器
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Cary
 * @date 2023/03/09
 * @since 2023-03-08
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 所有讲师列表
     *
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public ResponseResult list() {
        List<Teacher> list = teacherService.list(null);
        return ResponseResult.ok().data("items", list);
    }

    /**
     * 根据ID删除讲师
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/{id}")
    public ResponseResult removeById(@ApiParam(name = "id", value = "讲师ID", required = true)
                                     @PathVariable String id) {
        teacherService.removeById(id);
        return ResponseResult.ok();
    }

    /**
     * 分页讲师列表
     *
     * @param page  页面
     * @param limit 限制
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("/{page}/{limit}")
    public ResponseResult pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    /**
     * 分页讲师查询列表
     *
     * @param page         页面
     * @param limit        限制
     * @param teacherQuery 老师查询
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "分页讲师查询列表")
    @PostMapping("/{page}/{limit}")
    public ResponseResult pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody TeacherQuery teacherQuery) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return ResponseResult.ok().data("total", total).data("rows", records);
    }

    /**
     * 新增讲师
     *
     * @param teacher 老师
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public ResponseResult save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return ResponseResult.ok();

    }

    /**
     * 根据ID查询讲师
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public ResponseResult getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseResult.ok().data("item", teacher);
    }

    /**
     * 根据ID修改讲师
     *
     * @param id      id
     * @param teacher 老师
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public ResponseResult updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return ResponseResult.ok();
    }
}