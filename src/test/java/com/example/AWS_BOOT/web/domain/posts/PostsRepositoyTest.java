package com.example.AWS_BOOT.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoyTest {

    @Autowired
    PostsRepositoy postsRepositoy;

    @After
    public void cleanup() {
        postsRepositoy.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트본문";

        postsRepositoy.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepositoy.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }





}
