package com.aidootk.model.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "rom_folder")
public class RomFolder {

    @DatabaseField(generatedId = true, canBeNull = false, id = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RomFolder(String uri) {
        this.path = uri;
    }

    public String getIds(List<RomFolder> folders) {
        StringBuilder sb = new StringBuilder();
        for (RomFolder folder : folders) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(folder.getId());
        }
        return sb.toString();
    }

}
