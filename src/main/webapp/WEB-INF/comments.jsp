<%@ page import="model.Post" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="UTF-8">
  <title>Test Blog</title>
  <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
  <link rel="stylesheet" type="text/css" href="resources/style.css" media="all"/>

</head>
<body>
<div id="wrapper">
  <div id="header"></div>
  <div class="clear"></div>
  <!-- Begin Menu -->
  <div id="menu" class="menu opacity">
    <ul>
      <li><a href="/">Home</a></li>
      <li><a href="/new">New Post</a></li>
      <li><a href="contact.html">Contact</a></li>
    </ul>
    <br style="clear: left"/>
  </div>
  <!-- End Menu -->

  <!-- Begin Container -->
  <div id="container" class="opacity">

    <!-- Begin Blog -->
    <div class="blog">

      <!-- Begin Posts -->
      <div class="content">


        <!-- Begin Post -->
        <div class="post">

          <!-- Begin Post Info -->
          <div class="post-info">
            <!-- Begin Date -->
            <div class="post-date"><span class="day">${post.date.getDate()}</span> <span
                class="month">${post.date.getMonth()+1}</span> <span
                class="year">${post.date.getYear()+1900}</span></div>
            <!-- End Date -->
            <!-- Begin Title -->
            <div class="post-title" align="center">
              <h1><a href="/post/${post.id}">${post.title}</a></h1>

              <div class="post-meta"><span class="comments"><a>${post.author}</a></span>
              </div>
            </div>
            <!-- End Title -->
          </div>
          <!-- End Post Info -->

          <div class="post-text">
            <p>${post.text}</p>
          </div>
          <!-- End Text -->
        </div>

        <h3>${commentsList.size()} Responses to "${post.title}"</h3>

        <!-- Begin Comments -->
        <div id="comments">
          <ol id="singlecomments" class="commentlist">
            <c:forEach var="com" items="${commentsList}">
              <li class="clearfix">

                <div class="message">
                  <div class="info">
                    <h3><a>${com.author}</a></h3>
                    <span class="date">${com.date.getDate()}.${com.date.getMonth()+1}.${com.date.getYear()+1900}</span>
                  </div>
                  <p>${com.text}</p>
                </div>
                <div class="clear"></div>
              </li>
            </c:forEach>
          </ol>
        </div>
        <!-- End Comments -->

        <!-- Begin Form -->
        <div class="comment-form">
          <h3>Leave a Reply</h3>

          <div class="form-container">
            <form class="forms" action="/newcomment" method="post" onSubmit="location.href = '/'">
              <fieldset>
                <ol>
                  <li class="form-row text-input-row">
                    <label>Name</label>
                    <input type="text" name="commentAuthor" value="" class="text-input required"
                           title=""/>
                  </li>

                  <li class="form-row text-area-row">
                    <label>Message</label>
                    <textarea required name="commentText" class="text-area required"></textarea>
                  </li>

                  <li class="button-row">
                    <input type="submit" value="Submit" name="submit" class="btn-submit"/>
                  </li>
                </ol>
                <input type="hidden" name="postId" value="${post.id}"/>

              </fieldset>
            </form>
            <div class="response"></div>
          </div>
        </div>

      </div>
      <!-- End Posts -->
    </div>
    <!-- End Blog -->
  </div>
  <!-- End Container -->

</div>
</body>
</html>