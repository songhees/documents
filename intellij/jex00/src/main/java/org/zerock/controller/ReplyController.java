package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
    private ReplyService service;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.info("ReplyVO: " + vo);

        int insertCount = service.register(vo);

        log.info("Reply INSERT COUNT: " + insertCount);

        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno")Long bno, @PathVariable("page")int page) {
        Criteria cri = new Criteria(page, 10);

        log.info("get Reply List bno: " + bno);
        log.info("cri:" + cri);

        return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
    }

    @GetMapping(value = "{rno}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReplyVO> get(@PathVariable("rno")Long rno) {
        log.info("get: " + rno);
        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    @PreAuthorize("principal.username == #vo.replyer")
    @DeleteMapping(value = "{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@RequestBody ReplyVO vo, @PathVariable("rno")Long rno) {
        log.info("remove: " + rno);
        log.info("replyer: " + vo.getReplyer());

        int removeCount = service.remove(rno);
        return removeCount == 1? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PreAuthorize("principal.username == #vo.replyer")
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "{rno}", produces = {MediaType.TEXT_PLAIN_VALUE}, consumes = "application/json")
    public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno")Long rno) {
        vo.setRno(rno);

        log.info("rno: " + rno);

        log.info("modify...." + vo);
        return service.modify(vo) == 1? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
