import { Client } from '@stomp/stompjs';

let _contextRoot = window.location.origin;
$(document).ready(function() {
    initSocket();
})

function getPopupFilter() {
    try {
        return JSON.parse(localStorage.getItem('popup')) || {};
    } catch (e) {
        localStorage.removeItem('popup');
        return {};
    }
}

function initSocket() {
    let client = new Client({
        webSocketFactory: () => new window.SockJS('/connection'),
        reconnectDelay: 3000,   // 자동 재연결(ms)
    });
    client.onConnect = function(frame) {
        console.log(frame);
        client.subscribe("/subscribe/popup", function(response) {
            let content = JSON.parse(response.body)
            console.log(content);
            $('.wrapper .bbs_popup').remove();

            // 오늘 날짜가 지난 만료 날짜는 삭제
            let filter = getPopupFilter();
            let filterDate = dateAddFormatter(0);

            Object.keys(filter).forEach(k => { if (filter[k] < filterDate) delete filter[k]; });
            localStorage.setItem("popup", JSON.stringify(filter));

            // 아직 날짜가 만료되지 않은 popup은 건너뛰기
            if (content) {
                for(let i=0; i<content.length; i++) {
                    if (filter && filter[content[i].popupSeq]) {
                        continue;
                    }
                    setPopup(content[i]);
                }
            }
        })
    };

    client.activate();

    $(window).on('beforeunload', function(){
        client.deactivate();
    });

    $('.wrapper')
        .on('click', '.bbs_popup .close', function() { $(this).closest('.bbs_popup').remove(); })
        .on('change', '.bbs_popup .validTarget', function(e) {
            const id = e.currentTarget.value;
            const map = getPopupFilter();
            map[id] = dateAddFormatter(7);
            localStorage.setItem('popup', JSON.stringify(map));
            $(this).closest('.bbs_popup').find('.close').trigger('click');
    });
}

// contentHtml += '<a style="width: 100%; height: 100%;" href="'+_popRes.url+'"><img src="'+_contextRoot+'/common/rest/fileView/'+_popRes.popupSeq + '" style="width: 100%;height: 100%" alt="팝업이미지"></a>';
function setPopup(_popRes) {
    let topPercent = 0;
    _popRes.url = _popRes.url ? _popRes.url : '#'
    let contentHtml =
            `<div class="bbs_popup new_open" style="display: inline-flex;top: ${topPercent}%;">
            <section class="box_wrap" style="border: 2px dotted black;">
            <div class="title_box">
            <h1 class="title" style="font-size: 15px;">${_popRes.popupNm}</h1>
            </div>
            <div class="contents_box" style="padding-top: 10px; padding-bottom: 10px;">
            <a style="width: 100%; height: 100%;" href="${_popRes.url}">팝업 content</a>
            </div>
            <div class="more_box">
            <input type="checkbox" id="chk_openyn${_popRes.popupSeq}" class="validTarget" value="${_popRes.popupSeq}"/>
            <label for="chk_openyn${_popRes.popupSeq}">일주일 동안 열지 않기</label>
            </div>
            <button type="button" class="close">팝업 닫기</button>
            </section>
            </div>`
    $('.wrapper').append(contentHtml);

    $(contentHtml).draggable();
}

function dateAddFormatter(addDay) {
    let now = new Date();
    now.setDate(now.getDate() + addDay)
    let year = now.getFullYear();
    let month = String(now.getMonth() + 1).padStart(2, '0');
    let day = String(now.getDate()).padStart(2, '0');
    return year + month + day;
}