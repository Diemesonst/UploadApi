package com.Diemeson.game_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Diemeson.game_api.model.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
}
