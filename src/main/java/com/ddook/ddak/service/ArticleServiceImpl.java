package com.ddook.ddak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.repository.ArticlesRepository;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticlesRepository articleRepository;
	
	@Override
	public List<Articles> findArticles(){
		return articleRepository.findAll();
	}
	
	@Override
	public void saveArticles(Articles article){
		articleRepository.save(article);
	}

}
