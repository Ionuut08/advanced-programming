package com.example.ionut.restapplication.repo;

import com.example.ionut.restapplication.domain.Division;
import com.example.ionut.restapplication.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface PlayerRepository extends CrudRepository<Player, Integer> {
    List<Player> findByGameId(int id);

    Optional<Player> findByLastName(String lastName);

    List<Player> findByFirstName(String division);

    Collection<Player> findByDivision(Division division);

}
