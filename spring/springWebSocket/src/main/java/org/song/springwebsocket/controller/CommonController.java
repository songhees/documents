package org.song.springwebsocket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.song.springwebsocket.domain.FileVO;
import org.song.springwebsocket.service.CommonService;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommonController {
    private final SimpMessagingTemplate template;
    private final CommonService commonService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void popUp() {
        List<FileVO> payload = commonService.getFileVOList();
        template.convertAndSend("/subscribe/popup", payload);
    }

    @EventListener(SessionSubscribeEvent.class)
    public void handlerEvent() {
        List<FileVO> payload = commonService.getFileVOList();
        template.convertAndSend("/subscribe/popup", payload);
    }

//    @GetMapping("/fileView/{popupSeq}")
//    public @ResponseBody ResponseEntity getFile(@PathVariable Long popupSeq) {
//        FileVO fileVO = commonService.getFileInfo(popupSeq);
//
//        String path = (fileVO.getStorePath() == null) ? "/" : fileVO.getStorePath();
//        if (!"/".equals(path.substring(0, 1))) {
//            path = "/" + path;
//        }
//        path = path.replaceAll("'", "");
//        String fileName = fileVO.getStreFileNm()+ "." + fileVO.getFileExtsnNm();
//        log.info(path + fileName);
//        try {
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.noContent().build();
//    }
}
