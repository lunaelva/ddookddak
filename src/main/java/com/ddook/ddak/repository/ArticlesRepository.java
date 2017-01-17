package com.ddook.ddak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.model.Articles;

public interface ArticlesRepository  extends JpaRepository<Articles, Long> {
}
