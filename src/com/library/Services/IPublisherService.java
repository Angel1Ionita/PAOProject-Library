package com.library.Services;

import com.library.Entities.Publisher;

public interface IPublisherService {
    String getAllPublishers();

    String getPublisherById(int id);

    void updatePublisher(Publisher p);
}
