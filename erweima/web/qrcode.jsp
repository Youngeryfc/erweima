<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\7\26 0026
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jqueryqrCode生成二维码</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.qrcode.min.js"></script>
</head>
<body>
生成的二维码如下：<br/>
<div id="qrcode"></div>


<script>
    jQuery('#qrcode').qrcode("http://www.imooc.com");
</script>
</body>
</html>
