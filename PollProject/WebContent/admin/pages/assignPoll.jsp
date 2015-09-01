<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Polls</title>
</head>
<body>
<s:form action="processPollManagement">
<h2>
	<s:select label="Select a poll" 
		headerKey="-1" headerValue="Select a Poll"
		list="pollId" 
		name="pollId" 
		value="Select a Poll"
		/>
</h2> 

<h2>
	<s:select label="Select a poll master" 
		headerKey="-1" headerValue="Select a Poll master"
		list="pollMaster" 
		name="pollMaster" 
		value="Select a Poll master"
		 />
</h2> 
	
	<s:submit/>
</s:form>
</body>
</html>