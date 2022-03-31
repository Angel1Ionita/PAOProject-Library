package com.library.Services;

import com.library.Entities.Address;

import static com.library.Database.addresses;

public class AddressService implements IAddressService {

    @Override
    public String getAllAdresses() {
        return addresses.toString();
    }

    @Override
    public String getAddressById(int id) {
        for (Address a : addresses) {
            if (a.getId() == id)
                return a.toString();
        }
        return "No adddress found with the given id";
    }

    @Override
    public void addAddress(Address a) {
        addresses.add(a);
    }

    @Override
    public void updateAddress(Address a) {
        for (int i = 0; i < addresses.size(); i++)
            if (addresses.get(i).getId() == a.getId()) {
                addresses.set(i, a);
                break;
            }
    }

    @Override
    public void deleteAddress(int id) {
        for (Address a : addresses) {
            if (a.getId() == id) {
                addresses.remove(a);
                break;
            }
        }

    }
}
