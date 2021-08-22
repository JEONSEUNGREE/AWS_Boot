package com.example.AWS_BOOT.web;


import com.example.AWS_BOOT.web.config.auth.LoginUser;
import com.example.AWS_BOOT.web.config.auth.dto.SessionUser;
import com.example.AWS_BOOT.web.dto.PostsResponseDto;
import com.example.AWS_BOOT.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());
//        model 서버 템플릿 엔진에서 사용하는 객체
//        postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.

//        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user"); @LoginUser 어노테이션 대체

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
//        현재 머스테치 스타터를 통해 컨트롤러에서 문자열을 반환시 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
//        src/main/resource/templates/index.mustache로 View Resolver가 처리하게됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
//        위와 마찬가지 posts-save머스테치 파일 리턴
    }

//    restController에서 사용시 controller와 혼동주의 
//    mapping 오류 발생함 restcontroller에서는 return 값이 responsebody 형태로 정해져있기때문에 url 맵핑을 하지않음
    @GetMapping("/posts/update/{id}")
    public String findByUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);

        model.addAttribute("post", dto);

        log.info("id()"+ id);
        return "posts-update";
    }



}
