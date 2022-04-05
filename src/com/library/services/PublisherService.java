package com.library.services;

import com.library.entities.Publisher;

import static com.library.Database.publishers;

public class PublisherService implements IPublisherService {

    @Override
    public String getAllPublishers() {
        return publishers.toString();
    }

    @Override
    public String getPublisherById(int id) {
        for (Publisher p : publishers)
            if (p.getId() == id)
                return p.toString();
        return "No publisher found with this id";
    }

    @Override
    public void updatePublisher(Publisher p) {
        for (int i = 0; i < publishers.size(); i++)
            if (publishers.get(i).getId() == p.getId()) {
                publishers.set(i, p);
                break;
            }

    }
}
