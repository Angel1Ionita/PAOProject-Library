package com.library.services;

import com.library.entities.Staff;

public interface IStaffService {
    String getAllStaff();

    String getStaffById(int id);

    void addStaff(Staff s);

    void updateStaff(Staff s);

    void deleteStaff(int id);

}
