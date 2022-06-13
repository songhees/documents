package org.zerock.guestbook.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 객체의 등록 시간과 최종 수정 시간을 담당하는 클래스
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    private LocalDateTime modDate;
}
