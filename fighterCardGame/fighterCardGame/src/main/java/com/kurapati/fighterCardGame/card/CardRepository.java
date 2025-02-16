package com.kurapati.fighterCardGame.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    @Query(value = "(SELECT * FROM cards WHERE tier = :tier ORDER BY RANDOM() LIMIT 1) " +
            "UNION ALL " +
            "(SELECT * FROM cards WHERE overall > :overall ORDER BY RANDOM() LIMIT 4)",
            nativeQuery = true)
    List<Card> findRandomCards(@Param("tier") String tier, @Param("overall") int overall);
}
