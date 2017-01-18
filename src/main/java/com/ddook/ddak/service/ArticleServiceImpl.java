package com.ddook.ddak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.repository.ArticlesRepository;

<<<<<<< HEAD
@Service("articleService")
@Transactional
=======
/**
 * Article Service
 * @author Ryan
 *
 */
@Service
>>>>>>> eb962bad47125a3e72912c23f52ae5b914acf4a8
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
