package com.dev.pokemonRestModule.service;

import com.dev.pokemonRestModule.model.Pokemon;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonService {
    String pokeUrl = "https://pokeapi.co/api/v2/";
    public List<Pokemon> getPokemons(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
       return (List<Pokemon>) restTemplate.exchange(pokeUrl+"pokemon", HttpMethod.GET, entity, Pokemon.class).getBody();
        //List<Pokemon> pokemons = (List<Pokemon>) restTemplate.getForObject(pokeUrl+"pokemon",Pokemon.class);
        //return pokemons;
    }

    public Pokemon getPokemon(Long pokemonId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
       return restTemplate.exchange(pokeUrl + pokemonId, HttpMethod.GET, entity, Pokemon.class).getBody();
        //Pokemon pokemon = restTemplate.getForObject(pokeUrl + pokemonId,Pokemon.class);
        //return pokemon;
    }
}
