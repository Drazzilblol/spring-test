package controllers;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import service.CommentService;
import service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

/**
 * Created by Drazz on 07.02.2015.
 */
@Controller
public class CommentsController {
  private CommentService commentService;
  private PostService postService;

  @Autowired
  public void setCommentService(CommentService commentService) {
    this.commentService = commentService;
  }

  @Autowired
  public void setPostService(PostService postService) {
    this.postService = postService;
  }

  @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
  public final class ResourceNotFoundException extends RuntimeException {
  }

  @RequestMapping(value = "/{post_id}", method = RequestMethod.GET)
  public ModelAndView comments(@PathVariable("post_id") int post_id) {

    if (postService.getById(post_id) == null) {
      throw new ResourceNotFoundException();
    }
    ModelAndView model = new ModelAndView("comments");
    model.addObject("post", postService.getById(post_id));
    model.addObject("commentsList", commentService.getCommentsByPost(post_id));
    return model;

  }

  @RequestMapping(value = "/newcomment", method = RequestMethod.POST)
  public ModelAndView savePost(HttpServletRequest request) {
    Comment c = new Comment();

    c.setAuthor(request.getParameter("commentAuthor"));
    c.setText(request.getParameter("commentText"));
    Random rand = new Random(new Date().getTime());
    c.setId(rand.nextInt(99999999));
    c.setDate(new Date());
    c.setPostId(Integer.parseInt(request.getParameter("postId")));
    commentService.save(c);

    return new ModelAndView("redirect:/" + c.getPostId());

  }

}
