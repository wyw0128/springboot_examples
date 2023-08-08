package com.example.database_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repo;

    public List<Registration> allRegistrations() {
        return repo.findAll();
    }

    public Registration getRegistration(int id) {
        Optional<Registration> registration = repo.findById(id);
        if (registration.isPresent()) {
            return registration.get();
        } else {
            return null;
        }
    }

    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return repo.save(registration);
    }

    public void deleteRegistration(int id) {
        repo.deleteById(id);
    }
}