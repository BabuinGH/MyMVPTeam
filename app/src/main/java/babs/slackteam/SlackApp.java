package babs.slackteam;

import android.app.Application;
import android.arch.persistence.room.Room;

import babs.slackteam.persistence.MemberDatabase;

/**
 * Created by babusr on 12/2/17.
 */

public class SlackApp extends Application {
    private static SlackApp sInstance;
    private MemberDatabase database;

    public MemberDatabase getDatabase() {
        return database;
    }

    public static SlackApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        setupDatabase();
    }

    private void setupDatabase() {
        database = Room.databaseBuilder(this,
                MemberDatabase.class, "Member.db")
                .allowMainThreadQueries()
                .build();
    }


}
