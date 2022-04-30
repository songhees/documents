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
<html>
<head>

    <style>
        .uploadResult {
            width:100%;
            background-color: gray;
        }

        .uploadResult ul {
            display:flex;
            flex-flow: row;
            justify-content: center;
            align-items: center;
        }

        .uploadResult ul li {
            list-style: none;
            padding:10px;
            align-content: center;
            text-align: center;
        }

        .uploadResult ul li img {
            width: 100px;
        }

        .uploadResult ul li span {
            color:white;
        }

        .bigPictureWrapper {
            position: absolute;
            display: none;
            justify-content: center;
            align-items: center;
            top: 0%;
            width: 100%;
            height: 100%;
            background-color: gray;
            z-index: 100;
            background: rgba(255,255,255,0.5);
        }

        .bigPicture {
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .bigPicture img {
            width: 600px;
        }
    </style>
</head>
<body>
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

<div class="row">
    <div class="col-lg-12">
        <%-- /.panel --%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-comments fa-fw"></i>Files
            </div>
            <%-- /.panel-heading --%>
            <div class="panel-body">
                <div class="form-group uploadDiv">
                    <input type="file" name="uploadFile" multiple>
                </div>
                <div class="uploadResult">
                    <ul>

                    </ul>
                </div>
                <%-- ./ end ul --%>
            </div>
            <%-- / .panel .chat-panel --%>
            <div class="panel-footer"></div>
        </div>
    </div>
    <%-- ./ end row --%>
</div>
<div class="bigPictureWrapper">
    <div class="bigPicture">

    </div>
</div>
<%-- /.row --%>
<%@include file="../includes/footer.jsp"%>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function() {

        (function() {
            var bno = '<c:out value="${board.bno}"/>';
            console.log("modify: " + bno);

            $.getJSON("/board/getAttachList", {bno:bno}, function(arr) {
                console.log(arr);

                var str = "";

                $(arr).each(function(i, attach) {

                    if (attach.fileType) {
                        var fileCallPath = encodeURIComponent(attach.uploadPath+ "/s_" + attach.uuid + "_" + attach.fileName);
                        console.log("path: " + fileCallPath);

                        str += "<li data-path='" + attach.uploadPath +"' data-uuid='" + attach.uuid +"' data-filename='" + attach.fileName + "' data-type='" + attach.fileType + "'><div>";
                        str += "<span>" + attach.fileName + "</span>";
                        str += "<button type='button' data-file=\'" + fileCallPath + "\' data-type='image' class='btn btn-warning btn-circle'>";
                        str += "<i class='fa fa-times'></i></button><br>"
                        str += "<img src='/display?fileName=" + fileCallPath + "' ></div></li>";
                    } else {
                        str += "<li data-path='" + attach.uploadPath +"' data-uuid='" + attach.uuid +"' data-filename='" + attach.fileName + "' data-type='" + attach.fileType + "'><div>";

                        str += "<span>" + attach.fileName + "</span><br/>";
                        str += "<button type='button' data-file=\'" + fileCallPath + "\' data-type='image' class='btn btn-warning btn-circle'>";
                        str += "<i class='fa fa-times'></i></button><br>"
                        str += "<img src='/resources/img/attach.png'></div></li>";
                    }

                    $(".uploadResult ul").html(str);
                })
            })
        })();

        // 첨부파일 삭제 버튼 클릭시
        // 화면에서만 삭제 db에서와 폴더에서는 삭제하지 않는다.
        $(".uploadResult").on("click", "button", function(e) {

            if (confirm("Remove this file? ")) {
                var targetLi = $(this).closest("li");
                targetLi.remove();
            }
        })


        // 새로운 파일 추가
        var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
        var maxSize = 5242880;

        function checkExtension(fileName, fileSize) {
            if (fileSize >= maxSize) {
                alert("파일 사이즈 초과");
                return false;
            }

            if (regex.test(fileName)) {
                alert("해당 종류의 파일은 업로드 하실 수 없습니다.")
                return false;
            }
            return true;
        }

        function showUploadResult(arr) {
            if (!arr || arr.length == 0) {
                return;
            }
            var str= "";

            $(arr).each(function(i, attach) {

                if (attach.image) {
                    var fileCallPath = encodeURIComponent(attach.uploadPath + "/s_" + attach.uuid + "_" + attach.fileName);
                    console.log("path: " + fileCallPath);
                    str += "<li data-path='" + attach.uploadPath + "' data-uuid='" + attach.uuid + "' data-filename='" + attach.fileName + "' data-type='" + attach.image + "'><div>";

                    str += "<span>" + attach.fileName + "</span>";
                    str += "<button type='button' data-file=\'" + fileCallPath + "\' data-type='image' class='btn btn-warning btn-circle'>";
                    str += "<i class='fa fa-times'></i></button><br>"
                    str += "<img src='/display?fileName=" + fileCallPath + "' ></div></li>";
                } else {
                    var fileCallPath = encodeURIComponent(attach.uploadPath + "/" + attach.uuid + "_" + attach.fileName);
                    str += "<li data-path='" + attach.uploadPath + "' data-uuid='" + attach.uuid + "' data-filename='" + attach.fileName + "' data-type='" + attach.image + "'><div>";

                    str += "<span>" + attach.fileName + "</span><br/>";
                    str += "<button type='button' data-file=\'" + fileCallPath + "\' data-type='image' class='btn btn-warning btn-circle'>";
                    str += "<i class='fa fa-times'></i></button><br>"
                    str += "<img src='/resources/img/attach.png'></div></li>";
                }

                $(".uploadResult ul").append(str);
            })
        }

        $("input[type='file']").change(function(e) {

            var formData = new FormData();

            var inputFiles = $(this)

            var files = inputFiles[0].files

            for (var i=0; i<files.length; i++) {
                if (!checkExtension(files[i].name, files[i].size)) {
                    return;
                }
                formData.append("uploadFile", files[i]);
            }

            $.ajax({
                url:"/uploadAjaxAction",
                type:"POST",
                contentType:false,
                processData:false,
                data:formData,
                dataType:'json',
                success:function(result) {
                    console.log(result);
                    showUploadResult(result);
                }
            })
        })

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
            } else if (operation === "modify") {

                var str = "";

                $(".uploadResult ul li").each(function(i, obj) {
                    console.log(obj);
                    var jobj = $(obj);
                    console.log(jobj)
                    str += "<input type='hidden' name='attachList[" + i + "].fileName' value='" + jobj.data("filename") + "'>";
                    str += "<input type='hidden' name='attachList[" + i + "].uuid' value='" + jobj.data("uuid") + "'>";
                    str += "<input type='hidden' name='attachList[" + i + "].uploadPath' value='" + jobj.data("path") + "'>";
                    str += "<input type='hidden' name='attachList[" + i + "].fileType' value='" + jobj.data("type") + "'>";
                })

                formObj.append(str);
            }
            formObj.submit();
        })
    })
</script>