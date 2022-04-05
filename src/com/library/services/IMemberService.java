package com.library.services;

import com.library.entities.Member;

public interface IMemberService {
    String getAllMembers();

    String getMemberById(int id);

    void addMember(Member r);

    void updateMember(Member r);

    void deleteMember(int id);


}
