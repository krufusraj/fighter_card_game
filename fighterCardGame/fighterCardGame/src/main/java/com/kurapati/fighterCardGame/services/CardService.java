package com.kurapati.fighterCardGame.services;

import com.kurapati.fighterCardGame.models.Fighter;
import com.kurapati.fighterCardGame.repositories.CardRepository;
import com.kurapati.fighterCardGame.repositories.FighterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {


    private final FighterRepository fighterRepository;
    private final FighterListScrapper fighterListScrapper;

    public CardService(CardRepository cardRepository, FighterListScrapper fighterListScrapper, FighterRepository fighterRepository) {
        this.fighterListScrapper = fighterListScrapper;
        this.fighterRepository = fighterRepository;
    }

    @PostConstruct
    private void seedRepositories(){
        fighterListScrapper.seedDatabase();
    }

    public List<Fighter> list(){
        return fighterRepository.findAll();
    }
}
