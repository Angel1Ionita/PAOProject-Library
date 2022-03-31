package com.library.Services;

import com.library.Entities.Staff;

public interface IStaffService {
    String getAllStaff();

    String getStaffById(int id);

    void addStaff(Staff s);

    void updateStaff(Staff s);

    void deleteStaff(int id);

}
