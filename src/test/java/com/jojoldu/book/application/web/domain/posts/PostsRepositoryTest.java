package com.jojoldu.book.application.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){ // 단위 테스트가 끝날떄마다 수행할 메소드를 지정
        postsRepository.deleteAll();
    }
    @Test
    public void 계시글저장_불러오기(){
        //given
        String title= "테스트 게시글";
        String content ="테스트 본문";
        postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("jojodu@gmail.com")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getId()).isEqualTo(1L);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo("jojodu@gmail.com");
    }
    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());
        //when
        List<Posts> postsList = postsRepository.findAll();
        //then
        Posts posts = postsList.get(0);
        System.out.println(">> createDate >>"+posts.getCreateDate());
        System.out.println(">> modifiedDate >> "+ posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}