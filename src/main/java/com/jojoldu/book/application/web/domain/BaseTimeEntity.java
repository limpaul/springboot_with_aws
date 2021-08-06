package com.jojoldu.book.application.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//jpa클래스들이 BaseTimeEntity를 상속할때 필드를 컬럼으로 인식하도록 한다
@EntityListeners(AuditingEntityListener.class) // BaseTimeENtity에서는 Auditing 기능을 포함 시킨다
public abstract class BaseTimeEntity {
    @CreatedDate //entity가 생성될때 자동 저장한다
    private LocalDateTime createDate;

    @LastModifiedDate // 조회한 entity 값을 변경할때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
