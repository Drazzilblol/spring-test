package dao.impl;

import dao.CommentDao;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drazz on 07.02.2015.
 */
@Repository
public class CommentDAOImpl implements CommentDao {
  private DataSource dataSource;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<Comment> getCommentsByPost(int post_id) {
    String query = "select id, author, text, comment_date, post_id from comments where post_id = ?";
    List<Comment> comList = new ArrayList<Comment>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(query);
      ps.setInt(1, post_id);
      rs = ps.executeQuery();
      while (rs.next()) {
        Comment c = new Comment();
        c.setId(rs.getInt("id"));

        if (rs.getString("author").isEmpty()) {
          c.setAuthor("Anonymous");
        } else {
          c.setAuthor(rs.getString("author"));
        }

        c.setText(rs.getString("text"));
        c.setPostId(rs.getInt("post_id"));
        c.setDate(rs.getDate("comment_date"));
        comList.add(c);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        ps.close();
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return comList;


  }

  @Override
  public Comment getById(int id) {
    return null;
  }

  @Override
  public void save(Comment comment) {
    String query = "insert into comments (id, author, text, comment_date, post_id) values (?,?,?,?,?)";
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(query);
      ps.setInt(1, comment.getId());
      ps.setString(2, comment.getAuthor());
      ps.setString(3, comment.getText());
      ps.setDate(4, new Date(comment.getDate().getTime()));
      ps.setInt(5, comment.getPostId());
      int out = ps.executeUpdate();
      if (out != 0) {
        System.out.println("Comment saved with id=" + comment.getId());
      } else System.out.println("Comment save failed with id=" + comment.getId());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        ps.close();
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

  @Override
  public void delete(Comment comment) {

  }
}
