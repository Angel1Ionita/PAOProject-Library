package com.library.Services;

import com.library.Entities.Staff;

import static com.library.Database.staff;

public class StaffService implements IStaffService {

    @Override
    public String getAllStaff() {
        return staff.toString();
    }

    @Override
    public String getStaffById(int id) {
        for (Staff s : staff)
            if (s.getId() == id)
                return s.toString();
        return "No staff found with the given id";
    }

    @Override
    public void addStaff(Staff s) {
        staff.add(s);
    }

    @Override
    public void updateStaff(Staff s) {
        for (int i = 0; i < staff.size(); i++)
            if (staff.get(i).getId() == s.getId())
                staff.set(i, s);
    }

    @Override
    public void deleteStaff(int id) {
        for (Staff s : staff)
            if (s.getId() == id)
                staff.remove(s);

    }
}
