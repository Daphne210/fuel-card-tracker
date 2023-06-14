package com.mets.tracker.fuelcardtracker.Service;

import com.mets.tracker.fuelcardtracker.Entity.User;
import com.mets.tracker.fuelcardtracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveDetails(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Record already exists");
        } else {
            userRepository.save(user);
            return user;
        }
    }

    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    public User getUserDetails(Long userID) {

        return userRepository.findById(userID).orElse(null);
    }

    public String deleteDetails(Long userID) {
        if (userRepository.existsById(userID)) {
            userRepository.deleteById(userID);
            return "Deleted User with ID: " + userID;
        } else {
            return "No such user in the database";
        }
    }

}
