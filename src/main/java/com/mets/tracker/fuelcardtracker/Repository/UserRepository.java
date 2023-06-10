package com.mets.tracker.fuelcardtracker.Repository;

import com.mets.tracker.fuelcardtracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
