<%--
  Created by IntelliJ IDEA.
  User: songhee
  Date: 2022/04/14
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
    <%-- /.col-lg-12 --%>
</div>
<%-- /.row --%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" action="/board/modify" method="post" >
                    <input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
                    <input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
                    <input type="hidden" name="type" value="<c:out value='${cri.type}'/>">
                    <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>">
                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly>
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
                    </div>
                    <div class="form-group">
                        <label>Text area</label>
                        <input class="form-control" value='<c:out value="${board.content}"/>' name="content">
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly>
                    </div>

                    <div class="form-group">
                        <label>RegDate</label>
                        <input class="form-control" name="regDate" value='<fmt:formatDate value="${board.regdate}" pattern="yyyy/MM/dd" />' readonly>
                    </div>
                    <div class="form-group">
                        <label>Update Date</label>
                        <input class="form-control" name="updateDate" value='<fmt:formatDate value="${board.updateDate}" pattern="yyyy/MM/dd" />' readonly>
                    </div>
                    <button data-oper="modify" class="btn btn-default" type="submit">Modify</button>
                    <button data-oper="remove" class="btn btn-danger" type="submit">Remove</button>
                    <button data-oper="list" class="btn btn-info" type="submit">List</button>
                </form>
            </div>
            <%-- end panel-body --%>
        </div>
        <%-- end panel-body --%>
    </div>
    <%-- end panel --%>
</div>
<%-- /.row --%>
<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {

        var formObj = $("form");

        $("button").on("click", function(e) {
            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if (operation === "remove") {
                formObj.attr("action", "/board/remove");
            } else if (operation === "list") {
                formObj.attr("action", "/board/list").attr("method", "get");
                var pageNumTag = $("input[name='pageNum']").clone();
                var amountTag = $("input[name='amount']").clone();
                var typeTag = $("input[name='type']").clone();
                var keywordTag = $("input[name='keyword']").clone();


                formObj.empty();
                formObj.append(pageNumTag);
                formObj.append(amountTag);
                formObj.append(typeTag);
                formObj.append(keywordTag);
            }
            formObj.submit();
        })
    })
</script>