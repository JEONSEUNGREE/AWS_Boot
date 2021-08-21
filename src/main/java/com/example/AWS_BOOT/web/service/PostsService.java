package com.example.AWS_BOOT.web.service;


import com.example.AWS_BOOT.web.domain.posts.Posts;
import com.example.AWS_BOOT.web.domain.posts.PostsRepositoy;
import com.example.AWS_BOOT.web.dto.PostSaveRequestDto;
import com.example.AWS_BOOT.web.dto.PostsListResponseDto;
import com.example.AWS_BOOT.web.dto.PostsResponseDto;
import com.example.AWS_BOOT.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

//    아래와 같은 옵션을 주면 트랙잰션 범위는 유지하되 조회기능만 남겨두어 조회 속도가 개선된다.
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {

        return postsRepositoy.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
//        .map(PostsListResponseDto::new) 다음 코드는 실제로 밑에 코드와같다.
//        .map(posts -> new PostsListResponseDto(posts))
//        레포에서 넘어온 결과로 posts의 stream을 map을 통해 postListResponseDto 변환 -> List 반환하는 메서드
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepositoy.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        postsRepositoy.delete(posts);
    }

}
