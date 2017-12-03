package babs.slackteam.persistence.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import babs.slackteam.persistence.MemberModel;

/**
 * Created by babusr on 12/2/17.
 */

@Database(entities = {MemberModel.class}, version = 1)
public abstract class MemberRoomDatabase extends RoomDatabase {
    public abstract MemberDao memberDao();
}
