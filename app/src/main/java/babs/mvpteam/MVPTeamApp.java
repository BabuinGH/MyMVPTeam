package babs.mvpteam;

import android.app.Application;

import babs.mvpteam.persistence.MembersDatabase;

/**
 * Created by babusr on 12/2/17.
 */

public class MVPTeamApp extends Application {
    private static MVPTeamApp sInstance;
    private MembersDatabase mMembersDatabase;

    public static MVPTeamApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initDatabase();
    }

    private void initDatabase() {
        mMembersDatabase = new MembersDatabase(this);
    }

    public MembersDatabase getMembersDatabase() {
        return mMembersDatabase;
    }
}
