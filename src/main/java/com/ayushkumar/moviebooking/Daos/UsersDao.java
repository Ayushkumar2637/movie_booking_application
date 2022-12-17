package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users,Integer> {
    public Optional<Users> findUsersByFirstNameIgnoreCase(String firstName);
}
