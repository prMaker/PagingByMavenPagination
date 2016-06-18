<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/17
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homelist</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <div class="bs-example" data-example-id="hoverable-table">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>电影名</th>
                <th>评分</th>
                <th>放映时间</th>
                <th>发行时间</th>
                <th>导演</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.page.items}" var="movie">
                <tr>
                    <td>${movie.id}</td>
                    <td width="400px">${movie.title}</td>
                    <td>${movie.rate}</td>
                    <td>${movie.releaseyear}</td>
                    <td>${movie.sendtime}</td>
                    <td>${movie.daoyan}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>


        <div class="panel-footer text-right">

            <ul class="pagination" id="page"></ul>

            <%--<nav>--%>
                <%--<ul class="pagination">--%>
                    <%--<c:choose>--%>
                        <%--<c:when test="${page.pageNo == 1}">--%>

                            <%--<li class="disabled"><a href="javascripte:;">首页</a></li>--%>
                            <%--<li class="disabled"><a href="javascripte:;">上一页</a></li>--%>

                        <%--</c:when>--%>

                        <%--<c:when test="${page.pageNo != 1}">--%>

                            <%--<li><a href="/home?p=1">首页</a></li>--%>
                            <%--<li><a href="/home?p=${page.pageNo-1}">上一页</a></li>--%>

                        <%--</c:when>--%>
                    <%--</c:choose>--%>

                    <%--<c:choose>--%>
                        <%--<c:when test="${requestScope.page.pageNo == requestScope.page.totalPageNo}">--%>

                            <%--<li class="disabled"><a href="javascripte:;">下一页</a></li>--%>
                            <%--<li class="disabled"><a href="javascripte:;">末页</a></li>--%>

                        <%--</c:when>--%>

                        <%--<c:when test="${requestScope.page.pageNo != requestScope.page.totalPageNo}">--%>

                            <%--<li><a href="/home?p=${page.pageNo+1}">下一页</a></li>--%>
                            <%--<li><a href="/home?p=${page.totalPageNo}">末页</a></li>--%>

                        <%--</c:when>--%>
                    <%--</c:choose>--%>
                <%--</ul>--%>
            <%--</nav>--%>
        </div>



    </div>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>

    $(function(){


        $("#page").twbsPagination({
            totalPages:${page.totalPageNo},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}'
        });

    });

</script>

</body>
</html>
