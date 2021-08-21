package com.example.AWS_BOOT.web;


import com.example.AWS_BOOT.web.dto.PostSaveRequestDto;
import com.example.AWS_BOOT.web.dto.PostsResponseDto;
import com.example.AWS_BOOT.web.dto.PostsUpdateRequestDto;
import com.example.AWS_BOOT.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto) {
        return postsService.update(id, postsUpdateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findByid(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
