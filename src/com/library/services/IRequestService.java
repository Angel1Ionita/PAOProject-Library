package com.library.services;

import com.library.entities.Request;

public interface IRequestService {
    String getAllRequests();

    String getRequestById(int id);

    void addRequest(Request b);

    void deleteRequest(int id);
}
