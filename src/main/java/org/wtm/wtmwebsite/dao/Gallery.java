package org.wtm.wtmwebsite.dao;

public class Gallery {

    private String uuid;
    private String name;
    private String directory;

    public Gallery() {
    }

    public Gallery(String uuid, String name, String directory) {
        this.uuid = uuid;
        this.name = name;
        this.directory = directory;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
