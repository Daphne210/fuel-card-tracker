package com.mets.tracker.fuelcardtracker.Repository;

import com.mets.tracker.fuelcardtracker.Entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Cards, Long> {

}
