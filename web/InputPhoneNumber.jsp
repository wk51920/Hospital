<%--
  Created by IntelliJ IDEA.
  User: wk_51920
  Date: 2014/11/16
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机输入页面</title>
    <link href="InputPhoneNumber.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="center">
    <header>请输入您的手机号：</header>
    <div id="form">
        <form  action="SubmitPhoneNumber.do" method="POST">
            <p id="inputPhone">
                <input type="text" name="InputPhoneNumber"/>
                <input type="hidden" name="DateAndDepartment" value="${DateAndDepartment}">
                <input type="hidden" name="OrderOrCancel" value="${OOC}">
                <input type="submit" value="提交手机号"/>
            </p>
        </form>
    </div>
    <p id="backToIndex">
        <a href="index.jsp">点此返回首页</a>
    </p>
</div>
</body>
</html>