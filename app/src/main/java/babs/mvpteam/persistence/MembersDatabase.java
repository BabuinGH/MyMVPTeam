package babs.mvpteam.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import babs.mvpteam.persistence.room.MemberRoomDatabase;

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

    public MemberModel getMember(String id){
        List<MemberModel> memberModel = mDatabase.memberDao().getMember(id);
        return memberModel.get(0);
    }


    private void initDatabase(Context applicationContext) {
        mDatabase = Room.databaseBuilder(applicationContext,
                MemberRoomDatabase.class, "Member.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public interface UpdateMembersListener {
        void onMembersUpdated();
    }
}
