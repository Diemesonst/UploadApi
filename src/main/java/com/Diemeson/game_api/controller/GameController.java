package com.Diemeson.game_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Diemeson.game_api.model.Game;
import com.Diemeson.game_api.repository.GameRepository;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    // GET - listar todos
    @GetMapping
    public List<Game> getAll() {
        return repository.findAll();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - adicionar novo
    @PostMapping
    public ResponseEntity<Game> create(@Valid @RequestBody Game game) {
        return ResponseEntity.status(201).body(repository.save(game));
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @Valid @RequestBody Game game) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(game.getName());
                    existing.setGenre(game.getGenre());
                    existing.setYear(game.getYear());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
