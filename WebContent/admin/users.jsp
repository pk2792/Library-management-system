<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.lms.model.RegisterBO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<link href="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.css" rel="stylesheet"  type="text/css" />
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
	setTimeout(function() {
	    $('#msg').fadeOut('fast');
	}, 5000); // <-- time in milliseconds
});

</script>
<script>
$(document).ready(function(){
	$("#users").DataTable();
});
</script>

<script>
function approve(id){
	document.save.action = "<%=request.getContextPath()%>/Approve?id="+id;
	document.save.submit();
}
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
<!--           <h2 class="star"><span>Admin</span> Functionalities</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
          <h2 align="center">Registered Users</h2>
          <%if(null != request.getAttribute("msg")){ %>
          	<div id="msg" align="center" style="color: green; font-weight: bold;font-size: 17px;"><%=request.getAttribute("msg") %></div>
          <%} %>
         <br/><br/>
          <%if(null != request.getAttribute("users")){
        		List<RegisterBO> users = (List<RegisterBO>) request.getAttribute("users");  
        	%>
        	 <form name="save" method="post">
          <table width="100%" class="display" id="users">
			<thead>
				<tr>
					<th>Registration Id</th>
					<th>Name</th>
					<th>Email Id</th>
					<th>Contact #</th>
					<th>Approve</th>
				</tr>
			</thead>  
			<tbody>
			<%for(RegisterBO b : users){ %>
			<tr>
				<td><%=b.getReader_id() %></td>
				<td><%=b.getFname() %>&nbsp;<%=b.getLname() %>
				<input type="hidden" value="<%=b.getFname()%>" name="<%=b.getReader_id()%>f"></input>
				<input type="hidden" value="<%=b.getLname()%>" name="<%=b.getReader_id()%>l"></input>
				<input type="hidden" value="<%=b.getPass()%>" name="<%=b.getReader_id()%>p"></input>
				<input type="hidden" value="<%=b.getEmail()%>" name="<%=b.getReader_id()%>e"></input>
				</td>
				<td><%=b.getEmail() %></td>
				<td><%=b.getContact() %></td>
				<td><input type="button" value="Approve" onclick="approve('<%=b.getReader_id()%>')"/></td>
			</tr>
			<%} %>
			</tbody>        
          </table>
          </form>
          <%}else{ %>
          <br/>
          <h2 align="center" style="color: red;font-weight: bold;">No New Regsistrations found.</h2>
          <%} %>
          <br/><br/>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
