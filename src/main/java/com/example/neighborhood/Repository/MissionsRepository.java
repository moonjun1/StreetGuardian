package com.example.neighborhood.Repository;

import com.example.neighborhood.Entity.MissionsEntity;
import com.example.neighborhood.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionsRepository extends JpaRepository<MissionsEntity, Long> {
}

