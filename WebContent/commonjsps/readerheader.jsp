<div class="header">
  
    <div class="header_resize">
      <div style="padding: 30px 0 0 20px;color: white;font-size: 23px;!important">
        <!-- <ul>
          <li class="active"><a href="index.jsp">Home</a></li>
          <li><a href="login.jsp">Login</a></li>
          <li><a href="about.html">About Us</a></li>
          <li><a href="blog.html">Blog</a></li>
          <li><a href="contact.html">Contact Us</a></li>
        </ul> -->
        <table style="width: 100%;">
        <tr>
        	<td> Welcome <%=session.getAttribute("name") %> </td>
        	<td align="right"><a href="<%=request.getContextPath() %>/Logout"><img height="30px" alt="Logout" src="<%=request.getContextPath() %>/buttons/exit.png"></a>  </td>
        </tr>
        </table>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="hbg">
    <div class="logo">
      <h1><a href="<%=request.getContextPath() %>/index.jsp"><span>Library Management</span> System<small>Library at home.</small></a></h1>
    </div>
    </div>
