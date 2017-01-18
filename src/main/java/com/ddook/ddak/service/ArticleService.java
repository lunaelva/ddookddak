package com.ddook.ddak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;

<<<<<<< HEAD
@Service 
=======
/**
 * Article Service Interface
 * @author Ryan
 *
 */
@Service
@Transactional 
>>>>>>> eb962bad47125a3e72912c23f52ae5b914acf4a8
public interface ArticleService {
	public List<Articles> findArticles();
	
	public void saveArticles(Articles article);
}