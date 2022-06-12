package com.library.services;

import com.library.entities.Publisher;

public interface IPublisherService {
    String getAllPublishers();

    String getPublisherById(int id);

    void updatePublisher(Publisher p);
}
