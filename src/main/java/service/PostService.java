package service;

import model.Post;

import java.util.List;

/**
 * Created by Drazz on 05.02.2015.
 */
public interface PostService {

  List<Post> getPosts();

  Post getById(int id);

  void save(Post post);

  void delete(Post post);


}
