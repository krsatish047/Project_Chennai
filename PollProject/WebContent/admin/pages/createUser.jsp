<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
<s:form action="createUser">

            
           
            
            <s:select 
            	headerKey="-1" 
                headerValue="--- Please select User Type"
                list="{'Admin', 'PollMaster'}"
                name="userBean.utype" 
                label="Type" />



            <s:submit type="image" src="tick.png" tooltip="Submit" />
          
			
		</s:form>
</body>
</html>