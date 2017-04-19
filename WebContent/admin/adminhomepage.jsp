<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>

</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/adminafterloginheader.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
    <div class="sidebar">
        <div class="gadget">
<!--           <h2 class="star"><span>Admin</span> Functionalities</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article" align="center">
         <h2>Welcome <%=session.getAttribute("name") %></h2>
          <br/>
          <div align="center" style="width: 75%;font-size: 17px;">
          <h3>Here You can Access Follwing modules :</h3>
          <ol style="list-style-type: upper-roman;!important" >
          <li style="display: list-item; !important">Manage Master Data Like Add branch, author, publisher, books.</li>
          <li style="display: list-item; !important">Add books to branch.</li>
          <li style="display: list-item; !important">Search Books.</li>
          <li style="display: list-item; !important">Add New Reader.</li>
          <li style="display: list-item; !important">View Reports like branch info, top 10 borrowers, top 10 books borrowed, average fine.</li>
          </ol>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
