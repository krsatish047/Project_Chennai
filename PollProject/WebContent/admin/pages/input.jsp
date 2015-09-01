<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
    <head>
        
    </head>
	 
    <body>
        <h2>Input details</h2>
        
		<!--<s:actionerror theme="bootstrap"/>
     <s:actionmessage theme="bootstrap"/>
     <s:fielderror theme="bootstrap"/>-->
		<s:form action="validate"><!--   enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" -->
                   <!-- label="A sample horizontal Form">-->
			<s:textfield name="userBean.uid" label="User ID"/>
			
			<s:password name="userBean.pwd" label="Password"/>
			<s:submit/>
		</s:form>

    </body>
</html>

