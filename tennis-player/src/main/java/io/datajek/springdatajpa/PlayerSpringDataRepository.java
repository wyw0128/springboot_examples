package io.datajek.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
    // NOTE:
    List<Player> findByNationality(String nationality);
}
