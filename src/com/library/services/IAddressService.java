package com.library.services;

import com.library.entities.Address;

public interface IAddressService {
    String getAllAdresses();

    String getAddressById(int id);

    void addAddress(Address a);

    void updateAddress(Address a);

    void deleteAddress(int id);

}
