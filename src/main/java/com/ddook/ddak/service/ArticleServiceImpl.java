package com.ddook.ddak.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.repository.ArticlesRepository;

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
	public List<Articles> findArticles(){
		return articleRepository.findAll();
	}
	
	@Override
	public boolean saveArticle(Map<String, String> param){
		Articles article = new Articles();
		article.setContent(param.get("content"));
		article.setId(param.get("id"));
		article.setNickname(param.get("nickname"));
		article.setRegDate(new Date());
		article.setTitle(param.get("title"));
		
		boolean result = false;
		
		try{
			articleRepository.save(article);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public Articles getArticle(Long id){
		return articleRepository.findOne(id);
	}
	
	@Override
	public void deleteArticle(long articleId){
		articleRepository.delete(articleId);
	}
	
	@Override
	public Long updateArticle(Map<String, String> param){
		Articles article = new Articles();
		article.setArticleId(Long.valueOf(param.get("articleId")));
		article.setContent(param.get("content"));
		article.setId(param.get("id"));
		article.setNickname(param.get("nickname"));
		article.setTitle(param.get("title"));
		
		return articleRepository.save(article).getArticleId();
	}

}
