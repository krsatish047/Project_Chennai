<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome PollMaster</title>
</head>
<body>
<h2> A poll of Poll Id - <s:property value="activePollId"/> is active! </h2>
<s:form action="startPoll">
<s:submit value="Start the Poll"/>
</s:form>
</body>
</html>