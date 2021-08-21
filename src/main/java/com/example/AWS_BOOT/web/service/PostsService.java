package com.example.AWS_BOOT.web.service;


import com.example.AWS_BOOT.web.domain.posts.Posts;
import com.example.AWS_BOOT.web.domain.posts.PostsRepositoy;
import com.example.AWS_BOOT.web.dto.PostSaveRequestDto;
import com.example.AWS_BOOT.web.dto.PostsResponseDto;
import com.example.AWS_BOOT.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepositoy postsRepositoy;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {

        return postsRepositoy.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = postsRepositoy.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        //찾아서 없으면 exception 반환

        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts enitity = postsRepositoy.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        //찾아서 없으면 exception 반환

        return new PostsResponseDto(enitity);
    }


}
