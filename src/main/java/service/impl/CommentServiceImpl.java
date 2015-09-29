package service.impl;

import dao.CommentDao;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;

import java.util.List;

/**
 * Created by Drazz on 07.02.2015.
 */
@Service
public class CommentServiceImpl implements CommentService {
  private CommentDao commentDao;

  @Autowired
  public void setCommentDao(CommentDao commentDao) {
    this.commentDao = commentDao;
  }

  @Override
  public List<Comment> getCommentsByPost(int post_id) {
    return commentDao.getCommentsByPost(post_id);
  }

  @Override
  public Comment getById(int id) {
    return commentDao.getById(id);
  }

  @Override
  public void save(Comment comment) {
    commentDao.save(comment);

  }

  @Override
  public void delete(Comment comment) {
    commentDao.delete(comment);

  }
}
