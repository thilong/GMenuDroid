package com.aidootk.gmenu;

import com.aidootk.gmenu.model.Folder;
import com.aidootk.gmenu.model.Rom;

import java.util.ArrayList;

public class RomParser {
    private String path;
    private ArrayList<Folder> folders;
    private ArrayList<Rom> roms;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public ArrayList<Rom> getRoms() {
        return roms;
    }

    public void setRoms(ArrayList<Rom> roms) {
        this.roms = roms;
    }
}
