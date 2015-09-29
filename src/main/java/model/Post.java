package model;

import java.lang.reflect.Array;
import java.util.Date;

public class Post {
  private int id;
  private String text;
  private String author;
  private String title;
  private Date date;


  public Post() {
  }

  public Post(int id, String text, String author, String title, Date date) {
    this.id = id;
    this.text = text;
    this.author = author;
    this.date = date;
    this.title = title;

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
