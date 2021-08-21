package com.example.AWS_BOOT.web;


import com.example.AWS_BOOT.web.dto.PostSaveRequestDto;
import com.example.AWS_BOOT.web.dto.PostsResponseDto;
import com.example.AWS_BOOT.web.dto.PostsUpdateRequestDto;
import com.example.AWS_BOOT.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
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
        log.info("id ()" + id);
        return postsService.update(id, postsUpdateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findByid(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }
}
