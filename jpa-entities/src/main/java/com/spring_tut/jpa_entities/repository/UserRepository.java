package com.spring_tut.jpa_entities.repository;

import com.spring_tut.jpa_entities.modals.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserDetails,Integer> {

    Page<UserDetails> findByName(String userName, Pageable page);
}
