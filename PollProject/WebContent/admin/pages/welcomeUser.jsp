<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Poll Page</title>
<style>
body {
	font-family: Calibri, Tahoma, Arial;
}

td {
	vertical-align: top;
	padding-bottom: 10px;
}
</style>

<s:head />

</head>

<body>
	<h2>Select your option and vote</h2>

	<s:form action="countVote">
		<s:textfield name="quesBean.question" label="Question" maxlength="300" />
		<s:radio name="SelectedOption" label="Options"
                    list="quesBean.hmapOptions" />
		<s:submit type="image" src="tick.png" tooltip="Submit" />
	</s:form>


</body>
</html>

