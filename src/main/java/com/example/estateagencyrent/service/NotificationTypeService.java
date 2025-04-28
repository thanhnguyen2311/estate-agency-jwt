package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.NotificationType;
import com.example.estateagencyrent.repository.INotificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationTypeService implements INotificationTypeService {
    @Autowired
    private INotificationTypeRepository notificationTypeRepository;

    @Override
    public Iterable<NotificationType> findAll() {
        return notificationTypeRepository.findAll();
    }

    @Override
    public Optional<NotificationType> findById(Long id) {
        return notificationTypeRepository.findById(id);
    }

    @Override
    public House save(NotificationType notificationType) {
        notificationTypeRepository.save(notificationType);
        return null;
    }

    @Override
    public void remove(Long id) {
   notificationTypeRepository.deleteById(id);
    }
}
