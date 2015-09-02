<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the poll</title>
</head>
<body>
	<s:form action="questionSelected">
			<s:iterator value="%{#session.quesList}">
			<s:radio name="qno" list="{qno}" />
			<s:property value="qno" /> )
			<s:property value="question" /> <br>
			<s:property value="options" /> <br>
		</s:iterator>
	<s:submit label="Publish selected question" name="add"
			value="Publish" />
	<s:submit label="return to home page" name="add"
			value="return" />
			
	</s:form>

</body>
</html>