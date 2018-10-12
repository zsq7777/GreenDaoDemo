package com.able.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.able.greendaodemo.db.DaoMaster;
import com.able.greendaodemo.db.DaoSession;

import org.greenrobot.greendao.database.Database;

public class MyApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initUserDB();
    }

    private void initUserDB() {
//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "user.db");
//        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
//        DaoMaster daoMaster=new DaoMaster(db);
//        daoSession = daoMaster.newSession();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "users-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
