package service.impl;

import dao.PostDao;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PostService;

import java.util.List;

/**
 * Created by Drazz on 05.02.2015.
 */
@Service
public class PostServiceImpl implements PostService {

  private PostDao postDao;

  @Autowired
  public void setPostDao(PostDao postDao) {
    this.postDao = postDao;
  }

  @Override
  public List<Post> getPosts() {
    return postDao.getPosts();
  }

  @Override
  public Post getById(int id) {
    return postDao.getById(id);
  }

  @Override
  public void save(Post post) {
    postDao.save(post);
  }

  @Override
  public void delete(Post post) {
    postDao.delete(post);
  }
}
