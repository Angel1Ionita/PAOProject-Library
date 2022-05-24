package com.library.services;

import com.library.entities.Request;

import static com.library.Database.requests;

public class RequestService implements IRequestService {
    private static RequestService instance = null;

    private RequestService() {
    }

    @Override
    public String getAllRequests() {
        return requests.toString();
    }

    @Override
    public String getRequestById(int id) {
        for (Request r : requests)
            if (r.getId() == id)
                return r.toString();
        return ("No request found with the given id");
    }

    @Override
    public void addRequest(Request r) {
        requests.add(r);
    }

    @Override
    public void deleteRequest(int id) {
        for (Request r : requests)
            if (r.getId() == id)
                requests.remove(r);
    }

    public static RequestService getInstance() {
        {
            if (instance == null)
                instance = new RequestService();

            return instance;
        }
    }
}
