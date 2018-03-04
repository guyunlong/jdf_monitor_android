package jdf.jdfmonitorandroid.Application;

import android.app.Application;

import jdf.jdfmonitorandroid.Manager.MyContext;

/**
 * Created by gyl1 on 3/3/18.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (!MyContext.isInitialized()) {
            MyContext.init(getApplicationContext());
        }

    }
    public static synchronized MyApplication getInstance() {

        return mInstance;
    }
}
