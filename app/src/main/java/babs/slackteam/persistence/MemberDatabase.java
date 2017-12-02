package babs.slackteam.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by babusr on 12/2/17.
 */

@Database(entities = {MemberModel.class}, version = 1)
public abstract class MemberDatabase extends RoomDatabase{
    public abstract MemberDao memberDao();
}
