package io.datajek.springdatajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;

    // NOTE: The logic of insertPlayer and updatePlayer methods will be the same. The difference lies in the arguments being passed to the merge method.
    // The merge method will insert a new record if the id is not present in the database, else it will update the record.
    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    public void deletePlayerById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }
}
