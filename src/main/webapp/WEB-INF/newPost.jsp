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

        <!-- Begin Form -->
        <div>
          <h3 align="center">New Post</h3>

          <div class="formpost-container">
            <form class="forms" action="/new" method="post" onSubmit="location.href = '/'">
              <fieldset>
                <ol>
                  <li class="form-row text-input-row">
                    <label>Author</label>
                    <input type="text" name="postAuthor" value="" class="posttext-input" title=""/>
                  </li>

                  <li class="form-row text-input-row">
                    <label>Title</label>
                    <input required type="text" name="postTitle" value="" class="posttext-input"
                           title=""/>
                  </li>

                  <li class="form-row text-area-row">
                    <label>Post</label>
                    <textarea required name="postText" class="posttext-area required"></textarea>
                  </li>

                  <li class="button-row">
                    <input type="submit" value="Submit" name="submit" class="btn-submit"/>
                  </li>
                </ol>


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