<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Created</title>
</head>
<body>
User Created! 
<s:property value="userBean.utype"/> has been created with UserId = <s:property value ="userBean.uid"/> and Password = <s:property value ="userBean.pwd"/>
<a href="../../PollProject/admin/pages/manageUser.jsp"><br>Click to go back</a><br>
</body>
</html>