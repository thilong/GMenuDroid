package com.aidootk.model.db;

import com.aidootk.model.ModelContext;
import com.google.gson.Gson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "platform")
public class Platform {

    @DatabaseField(id = true, canBeNull = false, unique = true)
    private String name;

    @DatabaseField
    private String fullName;

    @DatabaseField(canBeNull = false)
    private String paths;           //json format, like "[1,2,3]", reference to the id of the path

    public String json() {
        return ModelContext.toString(this);
    }

    public Platform(String id, String fullName) {
        this.name = id;
        this.fullName = fullName;
        this.paths = "[]";
    }

}
