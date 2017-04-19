<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.lms.model.BranchBO"%>
<%@page import="java.util.List" %>
<%@page import="com.lms.model.AuthorBO" %>
<%@page import="com.lms.model.publisherBO" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<script>
$(document).ready(function(){
	setTimeout(function() {
	    $('#msg').fadeOut('fast');
	}, 5000); // <-- time in milliseconds
});

</script>
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
<!--           <h2 class="star"><span>Sidebar</span> Menu</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
        <h2 align="center">Add Book</h2>
<form method="post" action="<%=request.getContextPath() %>/AddBook">
<table align="center">

<tr>
	<td style="font-weight: bold;"> Enter ISBN Code : </td>
	<td> <input type="text" name="isbn" id="isbn"required /></td>
</tr>
<tr>
	<td style="font-weight: bold;"> Book Title : </td>
	<td> <input type="text" name="title" id="title" required /></td>
</tr>
<tr>
	<td style="font-weight: bold;"> Author Name : </td>
	<td> <select name="Author" id="authors"  style="width: 147px;">
	<option value="select">--Select--</option>
		<% if(null != request.getAttribute("list")){
			List<AuthorBO> list=(List<AuthorBO>) request.getAttribute("list");
			
			for(AuthorBO b : list){
			%>
			<option value="<%= b.getAuthor_id()%>"><%= b.getAuthorfname()%>&nbsp;<%=b.getAuthorlname() %></option>
		<%}} %>
		</select>
		</td>
		
	
</tr>
<tr>
	<td style="font-weight: bold;"> Publisher : </td>
	<td> <select name="publisher" id="pubs" style="width: 147px;">
	<option value="select">--Select--</option>
		<% if(null != request.getAttribute("list1")){
			List<publisherBO> list=(List<publisherBO>) request.getAttribute("list1");
			
			for(publisherBO b : list){
			%>
			<option value="<%= b.getPublisher_id()%>"><%= b.getPublisher_name()%> (<%=b.getPublisher_location() %>)</option>
		<%}} %>
		</select>
		</td>
		
</tr>
<!-- <tr>
	<td> Publisher Address : </td>
	<td> <input required type="text" name="publisheradd" id="publisheradd"/></td>
</tr> -->
<tr>
	<td style="font-weight: bold;"> Publication Date : </td>
	<td> <input type="date" name="pubdate" id="pubdate" required/></td>
</tr>
<tr align="center">
	<td colspan="2" style="padding-top: 20px; "> <input class="button button-3d button-primary button-rounded" type="submit" value="Add Book" /></td>
</tr>
</table>

</form>
<br/><br/>
<%if(null != request.getAttribute("msg")){ %>
<div align="center" id="msg" style="font-size: 17px;font-weight: bold;"><%= request.getAttribute("msg") %></div>
<%} %>
   
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
 
 </div>
 </body>
</html>
