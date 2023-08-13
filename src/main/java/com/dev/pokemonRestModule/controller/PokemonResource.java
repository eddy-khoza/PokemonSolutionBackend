package com.dev.pokemonRestModule.controller;

import com.dev.pokemonRestModule.model.Pokemon;
import com.dev.pokemonRestModule.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonResource {
    private final PokemonService pokemonService;

    public PokemonResource(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = pokemonService.getPokemons();

        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") Long id){
        Pokemon pokemon = pokemonService.getPokemon(id);

        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }
}
