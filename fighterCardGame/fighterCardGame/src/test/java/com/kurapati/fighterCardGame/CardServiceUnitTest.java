package com.kurapati.fighterCardGame;

import com.kurapati.fighterCardGame.fighter.Fighter;
import com.kurapati.fighterCardGame.card.CardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceUnitTest {
    @Autowired
    private CardService cardService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Fighter> books = cardService.list();

        Assert.assertEquals(books.size(), 3);
    }
}
