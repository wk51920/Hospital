<%--
  Created by IntelliJ IDEA.
  User: wk_51920
  Date: 2014/11/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hospital Order</title>
    <link href="index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="date.js"></script>
</head>

<body>
<div id="center">
    <header>门诊预约</header>
    <form action="OrderServlet.do" method="POST">
        <p>
            请用户选择就诊日期和部门
        </p>

        <p>
            就诊日期:
            <select id="yearSelect" name="year"  size="1" onchange="rebuildDay()">
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
            </select>年
            <select id="monthSelect" name="month" size="1" onchange="rebuildDay()">
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>月
            <select id="daySelect" name="day" size="1"></select>日
        </p>
        <p>
            选择就诊部门：
            <select name="department" size="1">
                <option value="InternalMedicine">内科</option>
                <option value="Surgery">外科</option>
            </select>
        </p>
        <input type="hidden" name="OrderOrCancel" value="Order"/>
        <input id="submitButton" type="submit" value="预约"/>
        <input type="button" value="取消预约" onClick="window.location.href='CancelOrder.jsp'"/>
    </form>
</div>
</body>
</html>
