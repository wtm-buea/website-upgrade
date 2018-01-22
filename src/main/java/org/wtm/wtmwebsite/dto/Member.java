package org.wtm.wtmwebsite.dto;

import org.wtm.wtmwebsite.dao.Account;
import org.wtm.wtmwebsite.dao.Profile;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Member {

    private String uuid;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String email;
    private Date dob;
    private Account account;
    private Profile profile;
    @NotNull private List<Role> roles;
    private List<String> eventIds;

    public Member() {
    }

    public Member(String uuid, String firstName, String lastName, String email,
                  Date dob, Account account, Profile profile, List<Role> roles,
                  List<String> eventIds) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.account = account;
        this.profile = profile;
        this.roles = roles;
        this.eventIds = eventIds;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<String> eventIds) {
        this.eventIds = eventIds;
    }

}

