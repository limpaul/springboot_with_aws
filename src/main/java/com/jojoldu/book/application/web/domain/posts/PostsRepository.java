package com.jojoldu.book.application.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
/*
Repository Layer : Database같이 데이터 저장소에 접근하는 영역이다
Dtos : Data Transfer Object 계층 간에 데이터 교환을 위한 객체
Domain Model
Web service, repository dto domain 이 5가지 레이어를 비니지스 처리하는곳이 domain이다
 */