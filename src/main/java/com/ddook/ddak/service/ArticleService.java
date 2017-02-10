package com.ddook.ddak.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;

@Service 
/**
 * Article Service Interface
 * @author lunamaan
 *
 */
public interface ArticleService {
	public List<Articles> findArticles();	
	public boolean saveArticle(Map<String, String> param);
	public Articles getArticle(Long id);
	public void deleteArticle(long articleId);
	public Long updateArticle(Map<String, String> param);
}