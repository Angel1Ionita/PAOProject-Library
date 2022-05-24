package com.library.services;

import com.library.io.Audit;
import com.library.io.Write;
import com.library.entities.Staff;

import static com.library.Database.staff;

public class StaffService implements IStaffService {
    private static StaffService instance = null;

    private StaffService() {
    }

    @Override
    public String getAllStaff() {
        Audit.logFunctionCall("getAllStaff");
        return staff.toString();
    }

    @Override
    public String getStaffById(int id) {
        for (Staff s : staff)
            if (s.getId() == id)
                return s.toString();
        Audit.logFunctionCall("getStaffById");
        return "No staff found with the given id";
    }

    @Override
    public void addStaff(Staff s) {
        staff.add(s);
        Write.toCSVFile(staff, Staff.class, Write.staffWriter);
        Audit.logFunctionCall("addStaff");
    }

    @Override
    public void updateStaff(Staff s) {
        for (int i = 0; i < staff.size(); i++)
            if (staff.get(i).getId() == s.getId())
                staff.set(i, s);
        Write.toCSVFile(staff, Staff.class, Write.staffWriter);
        Audit.logFunctionCall("updateStaff");
    }

    @Override
    public void deleteStaff(int id) {
        for (Staff s : staff)
            if (s.getId() == id) {
                staff.remove(s);
                break;
            }
        Write.toCSVFile(staff, Staff.class, Write.staffWriter);
        Audit.logFunctionCall("deleteStaff");
    }

    public static StaffService getInstance() {
        {
            if (instance == null)
                instance = new StaffService();

            return instance;
        }
    }
}
