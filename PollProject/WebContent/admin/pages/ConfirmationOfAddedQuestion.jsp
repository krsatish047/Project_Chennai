<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question added successfully</title>
</head>
<body>
<form action="addAnotherQuestionOrSubmit">
   <script>
  
  alert("Question added successfully");
   </script><s:submit name="add" value="nextQuestion" label="Add next Question"/>
   			 <s:submit name="add" value="complete" label="Complete poll" />
  </form>
</body>
</html>