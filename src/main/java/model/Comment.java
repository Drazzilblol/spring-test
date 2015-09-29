package model;

import java.util.Date;

/**
 * Created by Drazz on 07.02.2015.
 */
public class Comment {
  private int id;
  private String text;
  private String author;
  private Date date;
  private int post_id;

  public Comment() {
  }

  public Comment(int id, String text, String author, Date date, int post_id) {
    this.id = id;
    this.text = text;
    this.author = author;
    this.date = date;
    this.post_id = post_id;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getPostId() {
    return post_id;
  }

  public void setPostId(int post_id) {
    this.post_id = post_id;
  }
}
