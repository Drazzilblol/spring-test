package dao.impl;

import dao.PostDao;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drazz on 05.02.2015.
 */
@Repository
public class PostDAOImpl implements PostDao {

  private DataSource dataSource;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }


  @Override
  public List<Post> getPosts() {

    String query = "select id, author, title, text, post_date from posts";
    List<Post> empList = new ArrayList<Post>();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(query);
      rs = ps.executeQuery();
      while (rs.next()) {
        Post p = new Post();
        p.setId(rs.getInt("id"));
        p.setAuthor(rs.getString("author"));
        p.setTitle(rs.getString("title"));
        p.setText(rs.getString("text"));
        p.setDate(rs.getDate("post_date"));
        empList.add(0, p);
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
    return empList;
  }

  @Override
  public Post getById(int id) {
    String query = "select id, author, title, post_date, text from posts where id = ?";
    Connection conn = null;

    try {
      conn = dataSource.getConnection();
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setInt(1, id);
      Post p = null;
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {

        p = new Post();
        p.setId(rs.getInt("id"));
        p.setAuthor(rs.getString("author"));
        p.setTitle(rs.getString("title"));
        p.setText(rs.getString("text"));
        p.setDate(rs.getDate("post_date"));


      }
      rs.close();
      ps.close();
      return p;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }

  }

  @Override
  public void save(Post post) {
    String query = "insert into posts (id, author, text, post_date, title) values (?,?,?,?,?)";
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(query);
      ps.setInt(1, post.getId());
      ps.setString(2, post.getAuthor());
      ps.setString(3, post.getText());
      String[] a = {"2", "1"};
      ps.setDate(4, new Date(post.getDate().getTime()));
      ps.setString(5, post.getTitle());
      int out = ps.executeUpdate();
      if (out != 0) {
        System.out.println("Post saved with id=" + post.getId());
      } else System.out.println("Post save failed with id=" + post.getId());
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
  public void delete(Post post) {
    String query = "delete from posts where id=?";
    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(query);
      ps.setInt(1, post.getId());
      int out = ps.executeUpdate();
      if (out != 0) {
        System.out.println("Post deleted with id=" + post.getId());
      } else System.out.println("No post found with id=" + post.getId());
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
}
