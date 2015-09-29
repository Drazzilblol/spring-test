package controllers;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

/**
 * Created by andrei.pretskailo on 06.02.2015.
 */

@Controller
public class PostsController {

  private PostService postService;

  @Autowired
  public void setPostService(PostService postService) {
    this.postService = postService;
  }


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView postsList() {

    ModelAndView model = new ModelAndView("postsList");
    model.addObject("posts", postService.getPosts());

    return model;

  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView newPost() {

    ModelAndView model = new ModelAndView("newPost");

    return model;

  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ModelAndView savePost(HttpServletRequest request) {
    System.out.println(request.getParameter("postAuthor"));
    Post p = new Post();

    p.setAuthor(request.getParameter("postAuthor"));
    p.setText(request.getParameter("postText"));
    p.setTitle(request.getParameter("postTitle"));
    Random rand = new Random(new Date().getTime());
    p.setId(rand.nextInt(99999999));
    p.setDate(new Date());
    postService.save(p);

    return new ModelAndView("redirect:/");

  }
}
