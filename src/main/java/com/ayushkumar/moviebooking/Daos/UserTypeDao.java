package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeDao extends JpaRepository<UserType,Integer> {
    public Optional<UserType> findUserTypeByUserTypeNameIgnoreCase(String userTypeName);
}
