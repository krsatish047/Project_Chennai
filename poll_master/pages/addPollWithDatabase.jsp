<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add questions</title>
</head>
<body>
<s:form action="addPoll1">
			<s:textarea  name="Question" label="Question" cols="20" rows="4" wrap="hard"/>
			<s:textfield name="OptionA" label="Option A"/>
			<s:textfield name="OptionB" label="Option B"/>
			<s:textfield name="OptionC" label="Option C"/>
			<s:textfield name="OptionD" label="Option D"/>
			
			
			<s:submit name="add" value="addQuestion" />
			
			<s:submit name="add" value="completed" />
            
            <s:reset value="Reset form"/>
</s:form>            


			
		
</body>
</html>