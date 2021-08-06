package com.jojoldu.book.application.web;

import com.jojoldu.book.application.web.dto.PostsResponseDto;
import com.jojoldu.book.application.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.application.web.dto.PostsUpdateRequestDto;
import com.jojoldu.book.application.web.dto.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController // bean을 주입받는 방식 autowired , setter, constructor
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
