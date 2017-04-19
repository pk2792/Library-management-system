<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<link href="<%=request.getContextPath() %>/buttons/buttons.css" rel="stylesheet"  type="text/css" />
<script>

/* function display(a){
	if(a == "select"){
		document.getElementById("hide").style.display = "none";
	}else{
		document.getElementById("hide").style.display = "block";
	}
} */

function search(){
	$.ajax({
		url: "<%=request.getContextPath()%>/HomeSearch?bid="+$("#bid").val()+"&aid="+$("#aid").val()+"&pid="+$("#pid").val()+"", 
		success: function(result){
        	$("#search").html(result);
			$("#searchtable").DataTable();
		}
	});
}
</script>

</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/header.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
     <div class="sidebar" style="font: normal 20px Arial, Helvetica, sans-serif; !important">
        <div class="gadget" style="margin: 35px;!important">
          <h2 class="star"><span>Library</span>Functions</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li style="border-bottom: 1px solid gray;"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
            <li style="border-bottom: 1px solid gray;background: rgba(128, 128, 128, 0.51);"><a href="<%=request.getContextPath()%>/homepage_Search.jsp">Search Book</a></li>
            <li style="border-bottom: 1px solid gray;"><a href="<%=request.getContextPath() %>/Registration.jsp">Register</a></li>
            <li style="border-bottom: 1px solid gray;"><a href="<%=request.getContextPath() %>/login.jsp">Login</a></li>
          </ul>
        </div>
        
      </div>
      
      <div class="mainbar">
        
        <div class="article" align="center">
       <form name="checkout" method="post">
        <h2 align="center">Search Book(s)</h2>
        <% if(null != request.getAttribute("msg")){ %>
        	<h3 align="center" style="color: green;"><%=request.getAttribute("msg") %></h3>
        <%} %>
        <% if(null != request.getAttribute("count")){ %>
        <input type="hidden" id="booked" value="<%=request.getAttribute("count")%>"/>
        <div align="center" style="color: blue;font-size: 15px;">Books Borrowed Or Reserved By You : <b style="color: red;"><%= request.getAttribute("count") %></b></div>
        <%} %>
         <%--  <table>
          <tr>
          	<td>Select Branch : </td>
          	<td>
          		<select id="br" onchange="display(this.value);">
          		<option value="select">--Select--</option>
          		<c:forEach items="${list }" var="branch">
          			<option value="${branch.branch_id }">${branch.branch_name }</option>
          		</c:forEach>
          		</select>
          	</td>
          </tr>
          </table> --%>
          <br/>
          <table align="center" width="100%">
          <tr >
          	<th> Search By Book Id </th>
          	<th> Search By Author Name </th>
          	<th> Search By Publisher Name </th>
          </tr>
          
          <tr>
          	<td> <input type="text" id="bid" /></td>
          	<td> <input type="text" id="aid" /></td>
          	<td> <input type="text" id="pid" /></td>
          </tr>
          
          <tr align="center">
          	<td style="padding-top: 10px;" colspan="3"><input class="button button-3d button-primary button-rounded" type="button" value="Search" onclick="search();"/></td>
          </tr>
          </table>
          <br></br>
          <div id="search" align="center"></div>
          
          </form>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
