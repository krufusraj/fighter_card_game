package com.kurapati.fighterCardGame.card;

import com.kurapati.fighterCardGame.fighter.Fighter;
import com.kurapati.fighterCardGame.fighter.FighterListScrapper;
import com.kurapati.fighterCardGame.fighter.FighterRepository;
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
    private void seedRepositories() throws Exception {
        fighterListScrapper.seedDatabase();
    }

    public List<Fighter> list(){
        return fighterRepository.findAll();
    }
}
