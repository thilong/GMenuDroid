package com.aidootk.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArrayMap;

import com.aidootk.model.db.Platform;
import com.aidootk.model.db.Setting;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBContext extends OrmLiteSqliteOpenHelper {
    public static final int DB_VERSION = 1;  // Increment this number when you change the database schema

    public static final String DB_NAME = "GMenuDroid.dat";
    private static volatile DBContext instance;

    public static DBContext getShared(Context context) {
        if (instance == null) {
            synchronized (DBContext.class) {
                if (instance == null) {
                    instance = new DBContext(context);
                }
            }
        }
        return instance;
    }

    public DBContext(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Setting.class);
            TableUtils.createTableIfNotExists(connectionSource, Platform.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        if (newVersion == 2) {
            //database.execSQL("ALTER TABLE `platform` ADD COLUMN `url` TEXT");
        }
    }

    private ArrayMap<String, Dao> daoCache = new ArrayMap<>();

    public synchronized Dao getDao(Class clazz) {
        Dao dao = daoCache.get(clazz.getName());
        if (dao == null) {
            try {
                dao = super.getDao(clazz);
                daoCache.put(clazz.getName(), dao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }


}
