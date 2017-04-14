package com.ddook.ddak.board.service;

import java.util.Date;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.entity.Article;
import com.ddook.ddak.board.repository.ArticlesRepository;

@Service("articleService")
@Transactional
/**
 * Article Service
 * @author lunamaan
 *
 */
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticlesRepository articleRepository;
	
	@Override
	public Page<Article> findArticles(Pageable pageable){
		return articleRepository.findAll(pageable);
	}
	
	@Override
	public void saveArticle(Map<String, String> param){
		Article article = new Article();
		article.setArticleId(Long.valueOf(param.get("articleId")));
		article.setArticleNumber(Integer.);
		article.setContent(param.get("content"));
		article.setId(param.get("id"));
		article.setNickname(param.get("nickname"));
		article.setTitle(param.get("title"));
		
		articleRepository.save(article);
	}
	
	@Override
	public Article getArticle(int id){
		return articleRepository.findOne(id);
	}
	
	@Override
	public void deleteArticle(int articleId){
		articleRepository.delete(articleId);
	}
	
	@Override
	public int updateArticle(Map<String, String> param){
		Article article = new Article();
		article.setArticleId(Integer.valueOf(param.get("articleId")));
		article.setContent(param.get("content"));
		article.setId(param.get("id"));
		article.setNickname(param.get("nickname"));
		article.setTitle(param.get("title"));
		
		return articleRepository.save(article).getArticleId();
	}	
}
