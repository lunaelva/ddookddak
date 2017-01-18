package com.ddook.ddak.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;

@Service 
/**
 * Article Service Interface
 * @author Ryan
 *
 */
public interface ArticleService {
	public List<Articles> findArticles();
	
	public boolean saveArticles(Map<String, String> param);
}