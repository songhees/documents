package org.zerock.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String writer;
    private String content;
    private Date regdate;
    private Date updateDate;
}
