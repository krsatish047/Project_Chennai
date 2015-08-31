<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Input Details</title>
        <style>
        	body {
        		font-family: Calibri, Tahoma, Arial;
        	}
        </style>
    </head>

    <body>
        <h2>Input employee details</h2>

		<s:form action="process">
			<s:textfield name="name" label="Name"/>
			<s:textfield name="salary" label="Salary"/>
			<s:submit/>
		</s:form>

    </body>
</html>

