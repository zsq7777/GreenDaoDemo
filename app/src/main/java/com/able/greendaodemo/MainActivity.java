package com.able.greendaodemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.able.greendaodemo.db.DaoSession;
import com.able.greendaodemo.db.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEtName;
    private EditText mEtAge;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtName = findViewById(R.id.et_name);
        mEtAge = findViewById(R.id.et_age);

    }

    public void saveUser(View view) {
        DaoSession daoSession = ((MyApp) getApplication()).getDaoSession();
        userDao = daoSession.getUserDao();
        User user = new User(null,"测试",22);
        try {
            userDao.insert(user);
        }catch (Exception e){
            Log.i("异常", e.toString());
        }


    }

    public void getUser(View view) {
        if (userDao == null) {
            return;
        }
        List<User> users = userDao.loadAll();
        new AlertDialog.Builder(this).setMessage("姓名" + users.get(0).getAge() + "年龄" + users.get(0).getName()).show();
    }
}
