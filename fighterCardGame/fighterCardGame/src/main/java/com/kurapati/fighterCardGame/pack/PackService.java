package com.kurapati.fighterCardGame.pack;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.users.Users;
import com.kurapati.fighterCardGame.card.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {

    private final CardRepository cardRepo;
    private final PackRepository packRepo;

    public PackService(CardRepository cardRepository, PackRepository packRepository) {
        this.cardRepo = cardRepository;
        this.packRepo = packRepository;
    }


    public List<Card> generatePack(String packName,Users currentUser){

        List<Card> pack = cardRepo.findRandomCards("bronze",50);
        currentUser.setUserCards(pack);
        System.out.println(currentUser);
        return pack;
    }

}
