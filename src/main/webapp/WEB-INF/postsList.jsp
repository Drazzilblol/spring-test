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

        <c:forEach var="p" items="${posts}">
          <!-- Begin Post -->
          <div class="post">

            <!-- Begin Post Info -->
            <div class="post-info">
              <!-- Begin Date -->
              <div class="post-date"><span class="day">${p.date.getDate()}</span> <span
                  class="month">${p.date.getMonth()+1}</span> <span
                  class="year">${p.date.getYear()+1900}</span></div>
              <!-- End Date -->
              <!-- Begin Title -->
              <div class="post-title" align="center">
                <h1><a href="/${p.id}">${p.title}</a></h1>

                <div class="post-meta"><span class="comments"><a>${p.author}</a></span>
                </div>
              </div>
              <!-- End Title -->
            </div>
            <!-- End Post Info -->

            <div class="post-text">
              <p>${p.text}</p>
            </div>
            <!-- End Text -->

          </div>
          <!-- End Post -->
        </c:forEach>
        <!-- End Post -->

      </div>
      <!-- End Posts -->
    </div>
    <!-- End Blog -->
  </div>
  <!-- End Container -->

</div>
</body>
</html>