package org.wtm.wtmwebsite.dao;

public class Profile {

    private String telephone;
    private String address;
    private String profile;

    public Profile() {
    }

    public Profile(String telephone, String address, String profile) {
        this.telephone = telephone;
        this.address = address;
        this.profile = profile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
