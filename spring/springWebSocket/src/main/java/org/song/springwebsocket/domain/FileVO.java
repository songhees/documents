package org.song.springwebsocket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long popupSeq;

    private String popupNm;         // 팝업 제목
    private Date useBeginDt;
    private Date useEndDt;          // 팝업이 열려있는 기간
    private Integer priorRankValue; // 팝업 우선 순위
    private String url;             // 팝업 클릭시 이동 경로
    private String storePath;       // 저장 경로
    private String streFileNm;      // 저장된 이름
    private String orginlFileNm;    // 이름
    private String fileExtsnNm;     // 확장자
    private String oprtrId;
    private String useAt;
    private Date registAt;
    private Date updtDt;
}
