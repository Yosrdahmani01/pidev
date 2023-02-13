package com.esprit.tn.pidev.repositories;

import com.esprit.tn.pidev.entities.Event;
import com.esprit.tn.pidev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 User findByEmail(String email);
}
