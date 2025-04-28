package com.example.estateagencyrent.repository;

import com.example.estateagencyrent.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationTypeRepository extends JpaRepository<NotificationType, Long> {
}
