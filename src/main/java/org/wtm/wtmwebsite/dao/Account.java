package org.wtm.wtmwebsite.dao;

public class Account {

    private String uuid;
    private String password;

    public Account() {
    }

    public Account(String uuid, String password) {
        this.uuid = uuid;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
