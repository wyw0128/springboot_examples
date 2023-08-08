package com.example.database_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> allPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(int id){
        return repo.findById(id).get();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        //check if player contains nested profile
//        if(player.getPlayerProfile()!=null) {
//            player.getPlayerProfile().setPlayer(player);
//        }
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

//    public Player assignProfile(int id, PlayerProfile profile) {
//        Player player = repo.findById(id).get();
//        player.setPlayerProfile(profile);
//        //bidirectional
//        player.getPlayerProfile().setPlayer(player);
//        return repo.save(player);
//    }

    public Player assignRegistration(int id, Registration registration) {
        // TODO: check if registration is already assigned to a player
        //
        Player player = repo.findById(id).get();
        player.registerPlayer(registration);
        return repo.save(player);
    }

    public Player removeRegistration(int id, Registration registration) {
        Player player = repo.findById(id).get();
        player.removeRegistration(registration);
        return repo.save(player);
    }
}