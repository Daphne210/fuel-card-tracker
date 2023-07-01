package com.mets.tracker.fuelcardtracker.Repository;

import com.mets.tracker.fuelcardtracker.Entity.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Integer> {
    Attempts findByUserName(String userName);
}
