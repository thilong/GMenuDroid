package com.aidootk.gmenu;

import com.aidootk.gmenu.model.Folder;
import com.aidootk.gmenu.model.Rom;

import java.util.ArrayList;

public class RomParser {
    private final String path;
    private final ArrayList<Folder> folders;
    private final ArrayList<Rom> roms;

    public RomParser(String path) {
        this.path = path;
        this.folders = new ArrayList<>();
        this.roms = new ArrayList<>();
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public ArrayList<Rom> getRoms() {
        return roms;
    }

}
