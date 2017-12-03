package babs.slackteam;

import android.app.Application;

import babs.slackteam.persistence.MembersDatabase;

/**
 * Created by babusr on 12/2/17.
 */

public class SlackApp extends Application {
    private static SlackApp sInstance;
    private MembersDatabase mMembersDatabase;

    public static SlackApp getInstance() {
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
