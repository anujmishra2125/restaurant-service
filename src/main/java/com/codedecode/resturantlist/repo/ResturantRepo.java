package com.codedecode.resturantlist.repo;

import com.codedecode.resturantlist.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepo extends JpaRepository<Resturant,Integer> {
}
