package com.library.Services;

import com.library.Entities.Request;

import static com.library.Database.requests;

public class RequestService implements IRequestService {

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
}
