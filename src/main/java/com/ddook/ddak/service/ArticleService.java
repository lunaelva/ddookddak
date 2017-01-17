package com.ddook.ddak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ddook.ddak.model.Articles;

@Service
@Transactional 
public interface ArticleService {
	public List<Articles> findArticles();
	public void saveArticles(Articles article);
}