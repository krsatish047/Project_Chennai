<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Confirmed Details</title>
        <style>
        	body {
        		font-family: Calibri, Tahoma, Arial;
        	}
        </style>
    </head>

    <body>
        <h2>Salary prediction for <s:property value="name" /></h2>

		Predicted salary after 10 years: <s:property value="salary" />

    </body>
</html>

