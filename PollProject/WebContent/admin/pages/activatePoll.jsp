<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate Poll</title>
</head>
<body>
<s:form action="activatePoll">
<h2>
	<s:select label="Select a poll to activate" 
		headerKey="-1" headerValue="Select a Poll"
		list="activePolls"
		name="selectedPoll" 
		value="Select a Poll"
		/>
</h2> 
<s:submit label="Activate Poll" />
</s:form>
</body>
</html>