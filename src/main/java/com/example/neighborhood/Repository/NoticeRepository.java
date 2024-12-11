package com.example.neighborhood.Repository;

import com.example.neighborhood.Entity.MissionsEntity;
import com.example.neighborhood.Entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

}
