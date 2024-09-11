package com.aidootk.gmenu.model;

import java.util.ArrayList;

public class Platform {
    private String name;
    private String fullName;
    private String description;
    private ArrayList<Emulator> emulators;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Emulator> getEmulators() {
        return emulators;
    }

    public void setEmulators(ArrayList<Emulator> emulators) {
        this.emulators = emulators;
    }
}
