package com.ddook.ddak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.repository.ArticlesRepository;


@Service("articleService")
@Transactional
/**
 * Article Service
 * @author Ryan
 *
 */
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticlesRepository articleRepository;
	
	@Override
	public List<Articles> findArticles(){
		List<Articles> result = articleRepository.findAll();
		return result;
	}
	
	@Override
	public void saveArticles(Articles article){
		articleRepository.save(article);
	}

}
