package com.library.services;

import com.library.io.Audit;
import com.library.io.Write;
import com.library.entities.Address;

import static com.library.Database.addresses;

public class AddressService implements IAddressService {
    private static AddressService instance = null;

    private AddressService() {
    }

    @Override
    public String getAllAdresses() {
        Audit.logFunctionCall("getAllAddresses");
        return addresses.toString();
    }

    @Override
    public String getAddressById(int id) {
        for (Address a : addresses) {
            if (a.getId() == id)
                return a.toString();
        }
        Audit.logFunctionCall("getAddressById");
        return "No adddress found with the given id";
    }

    @Override
    public void addAddress(Address a) {
        addresses.add(a);
        Write.toCSVFile(addresses,Address.class,Write.addressesWriter);
        Audit.logFunctionCall("addAddress");
    }

    @Override
    public void updateAddress(Address a) {
        for (int i = 0; i < addresses.size(); i++)
            if (addresses.get(i).getId() == a.getId()) {
                addresses.set(i, a);
                break;
            }
        Write.toCSVFile(addresses,Address.class,Write.addressesWriter);
        Audit.logFunctionCall("updateAddress");
    }

    @Override
    public void deleteAddress(int id) {
        for (Address a : addresses) {
            if (a.getId() == id) {
                addresses.remove(a);
                break;
            }
        }
        Write.toCSVFile(addresses,Address.class,Write.addressesWriter);
        Audit.logFunctionCall("deleteAddress");

    }

    public static AddressService getInstance() {
        {
            if (instance == null)
                instance = new AddressService();

            return instance;
        }
    }
}
