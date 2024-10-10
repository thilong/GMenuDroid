package com.aidootk.model;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

import java.util.List;

public class DBCommonDao<T, K> {

    private Dao<T, K> dao = null;

    public DBCommonDao(Context context, Class<T> clazz) {
        DBContext dbContext = DBContext.getShared(context);
        dao = DBContext.getShared(context).getDao(clazz);
    }

    public boolean add(T t) {
        try {
            return dao.createOrUpdate(t).getNumLinesChanged() > 0;
        } catch (Exception e) {
            raiseError(e);
        }
        return false;
    }

    public boolean create(List<T> items) {
        try {
            return dao.create(items) == items.size();
        } catch (Exception e) {
            raiseError(e);
        }
        return false;
    }

    public boolean update(T t) {
        try {
            return dao.update(t) > 0;
        } catch (Exception e) {
            raiseError(e);
        }
        return false;
    }

    public List<T> all() {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            raiseError(e);
        }
        return null;
    }

    public T insert(T t) {
        try {
            return dao.createIfNotExists(t);
        } catch (Exception e) {
            raiseError(e);
        }
        return t;
    }

    public boolean delete(K key) {
        try {
            return dao.deleteById(key) > 0;
        } catch (Exception e) {
            raiseError(e);
        }
        return false;
    }

    public boolean delete(List<T> items) {
        try {
            return dao.delete(items) == items.size();
        } catch (Exception e) {
            raiseError(e);
        }
        return false;
    }

    private void raiseError(Exception e) {
        e.printStackTrace();
    }

    public Where<T, K> query() {
        return dao.queryBuilder().where();
    }

    public Where<T, K> delete() {
        return dao.deleteBuilder().where();
    }

    public Where<T, K> update() {
        return dao.updateBuilder().where();
    }

}
