package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status,Integer> {
    public Status findByStatusNameIgnoreCase(String statusName);
}
