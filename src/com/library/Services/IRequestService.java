package com.library.Services;

import com.library.Entities.Request;

public interface IRequestService {
    String getAllRequests();

    String getRequestById(int id);

    void addRequest(Request b);

    void deleteRequest(int id);
}
