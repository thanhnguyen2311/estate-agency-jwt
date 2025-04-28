package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.Notification;

import java.util.List;

public interface INotificationService extends IGeneralService<Notification> {
    List<Notification> getNotification(Long id);
}
