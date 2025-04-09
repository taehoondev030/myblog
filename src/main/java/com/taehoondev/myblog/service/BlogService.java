package com.taehoondev.myblog.service;

import com.taehoondev.myblog.domain.Article;
import com.taehoondev.myblog.dto.AddArticleRequest;
import com.taehoondev.myblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 혹은 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 서블릿 컨테이너에 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // AddArticleRequest 클래스에 저장된 값들을 데이터베이스에 저장
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에서 전체 게시물 가져오기
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
    
}
