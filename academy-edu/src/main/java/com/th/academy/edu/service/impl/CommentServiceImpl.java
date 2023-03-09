package com.th.academy.edu.service.impl;

import com.th.academy.edu.pojo.Comment;
import com.th.academy.edu.mapper.CommentMapper;
import com.th.academy.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Cary
 * @since 2023-03-08
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
