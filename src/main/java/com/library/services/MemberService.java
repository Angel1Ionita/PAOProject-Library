package com.library.services;

import com.library.entities.Member;

import static com.library.Database.members;

public class MemberService implements IMemberService {
    private static MemberService instance = null;

    private MemberService() {
    }

    @Override
    public String getAllMembers() {
        return members.toString();
    }

    @Override
    public String getMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id)
                return m.toString();
        }
        return "No member found with the given id";
    }

    @Override
    public void addMember(Member m) {
        members.add(m);
    }

    @Override
    public void updateMember(Member m) {
        for (int i = 0; i <= members.size() - 1; i++) {
            if (members.get(i).getId() == m.getId()) {
                members.set(i, m);
                break;
            }
        }
    }

    @Override
    public void deleteMember(int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                members.remove(m);
                break;
            }
        }
    }

    public static MemberService getInstance() {
        {
            if (instance == null)
                instance = new MemberService();

            return instance;
        }
    }
}
