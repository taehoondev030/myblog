package com.taehoondev.myblog.service;

import com.taehoondev.myblog.domain.Article;
import com.taehoondev.myblog.dto.AddArticleRequest;
import com.taehoondev.myblog.dto.UpdateArticleRequest;
import com.taehoondev.myblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    
    // 특정 게시물 가져오기
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + id));
    }

    // 게시물 삭제하기
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 게시물 수정하기
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
