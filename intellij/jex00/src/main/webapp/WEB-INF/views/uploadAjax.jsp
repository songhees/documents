<%--
  Created by IntelliJ IDEA.
  User: songhee
  Date: 2022/04/26
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Title</title>
</head>
<body>
<h1>Upload with Ajax</h1>

<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple/>
</div>
<div class="uploadResult">
    <ul>

    </ul>
</div>
<button id="uploadBtn">Upload</button>
<div class="bigPictureWrapper">
    <div class="bigPicture">

    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous">
</script>
<script>
    //원본 이미지 보여주기
    function showImage(fileCallPath) {
        $(".bigPictureWrapper").css("display", "flex").show();

        $(".bigPicture").html("<img src='/display?fileName=" + encodeURI(fileCallPath)+"'>").animate({width:'100%', height:'100%'}, 1000);
    }

    $(document).ready(function() {
        $(".bigPictureWrapper").on("click", function(e) {
            $(".bigPicture").animate({width:'0%', height:'0%'}, 1000);
            setTimeout(() => {
                $(this).hide();
            }, 1000);
        })

        var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
        var maxSize = 5242880; // 5MB

        // 파일 제한
        function checkExtension(fileName, fileSize) {

            if (fileSize >= maxSize) {
                alert("파일 사이즈 초과");
                return false;
            }

            if (regex.test(fileName)) {
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
            }

            return true;
        }

        var cloneObj = $(".uploadDiv").clone();

        var uploadResult = $(".uploadResult ul");

        // 업로드된 파일 이름
        function showUploadFile(uploadResultArr) {
            var str ="";
            $(uploadResultArr).each(function(i, obj) {
                if (!obj.image) {
                    var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
                    var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
                    str += "<li><div><a href='/download?fileName=" + fileCallPath + "'><img src='/resources/img/attach.png'>" + obj.fileName + "</a><span data-file=\'" + fileCallPath +
                        "\' data-type='file'> x </span></div></li>";
                } else {
                    //str += "<li>" + obj.fileName + "</li>";

                    var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
                    var originPath = obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName;
                    originPath = originPath.replace(new RegExp(/\\/g), "/");

                    str += "<li><a href=\"javascript:showImage(\'" + originPath +"\')\"><img src='/display?fileName=" + fileCallPath + "'></a>" +
                        "<span data-file=\'" + fileCallPath +
                    "\' data-type='image'> x </span></li>";
                }
            });

            uploadResult.append(str);
        }

        $(".uploadResult").on("click", "span", function(e) {

            var targetFile = $(this).data("file");
            var type = $(this).data("type");
            console.log(targetFile);

            $.ajax({
                url:"/deleteFile",
                type:"POST",
                data: {fileName:targetFile, type:type},
                dataType: "text",
                success: function(result) {
                    alert(result);
                }
            });
        });


        $("#uploadBtn").on("click", function(e) {
            var formData = new FormData();
            var inputFile = $("input[name='uploadFile']");
            console.log(inputFile);
            var files = inputFile[0].files;
            console.log(files);

            for (var i = 0; i<files.length; i++) {

                if (!checkExtension(files[i].name, files[i].size)) {
                    return false;
                }
                console.log(files[i])
                formData.append("uploadFile", files[i]);
            }

            var csrfHeaderName = "${_csrf.headerName}";
            var csrfToken = "${_csrf.token}";

            $.ajax({
                url:"/uploadAjaxAction",
                contentType: false,
                processData: false,
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeaderName, csrfToken);
                },
                data: formData,
                type: 'post',
                dataType: 'json',
                success:function(result) {
                    //console.log(result);

                    showUploadFile(result);
                    $(".uploadDiv").html(cloneObj.html());
                }
            })
        })
    })

</script>
</body>
</html>
