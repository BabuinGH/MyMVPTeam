package babs.slackteam.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import babs.slackteam.persistence.room.MemberRoomDatabase;

/**
 * Created by babusr on 12/2/17.
 */

public class MembersDatabase {
    private MemberRoomDatabase mDatabase;
    // TODO: use weak reference
    UpdateMembersListener mMembersListener;

    public MembersDatabase(Context context) {
        initDatabase(context.getApplicationContext());
    }

    public void setListener(UpdateMembersListener membersListener) {
        mMembersListener = membersListener;
    }


    public List<MemberModel> getMembers() {
        return mDatabase.memberDao().getMembers();
    }


    public void insertMembers(List<MemberModel> members) {
        for (MemberModel member : members) {
            mDatabase.memberDao().insertMember(member);
        }

        if (mMembersListener != null) {
            mMembersListener.onMembersUpdated();
        }

    }


    private void initDatabase(Context applicationContext) {
        mDatabase = Room.databaseBuilder(applicationContext,
                MemberRoomDatabase.class, "Member.db")
                .allowMainThreadQueries()
                .build();
    }

    public interface UpdateMembersListener {
        void onMembersUpdated();
    }
}
