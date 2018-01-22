package org.wtm.wtmwebsite.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "member")
public class MemberDocument {

    @Id
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private Profile profile;
    private Account account;
    private List<RoleDocument> roles;
    private List<String> eventIds;
    private Boolean isActive;

    public MemberDocument() {
    }

    public MemberDocument(String uuid, String firstName, String lastName, String email,
                          Date dob, Profile profile, Account account, List<RoleDocument> roles,
                          List<String> eventIds, Boolean isActive) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.profile = profile;
        this.account = account;
        this.roles = roles;
        this.eventIds = eventIds;
        this.isActive = isActive;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<RoleDocument> getRole() {
        return roles;
    }

    public void setRole(List<RoleDocument> roles) {
        this.roles = roles;
    }

    public List<String> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<String> eventIds) {
        this.eventIds = eventIds;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
