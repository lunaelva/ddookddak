package com.ddook.ddak.board.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.model.Article;

@Service 
/**
 * Article Service Interface
 * @author lunamaan
 */
public interface ArticleService {
	public Page<Article> findArticles(Pageable pageable);	
	public void saveArticle(Map<String, String> param);
	public Article getArticle(Long id);
	public void deleteArticle(long articleId);
	public Long updateArticle(Map<String, String> param);
}