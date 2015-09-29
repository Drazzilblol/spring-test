package dao;

import model.Comment;
import model.Post;

import java.util.List;

/**
 * Created by Drazz on 05.02.2015.
 */
public interface CommentDao {

  List<Comment> getCommentsByPost(int post_id);

  Comment getById(int id);

  void save(Comment comment);

  void delete(Comment comment);

}
