package com.ddook.ddak.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.board.model.Article;

public interface ArticlesRepository  extends JpaRepository<Article, Integer> {
}
