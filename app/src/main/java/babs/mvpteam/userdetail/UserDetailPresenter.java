package babs.mvpteam.userdetail;

import babs.mvpteam.persistence.MemberModel;
import babs.mvpteam.persistence.MembersDatabase;

import static babs.mvpteam.userdetail.UserDetailContract.UserDetailView;

/**
 * Created by babusr on 12/3/17.
 */

public class UserDetailPresenter {
    private UserDetailView mView;
    MembersDatabase mMembersDatabase;

    public UserDetailPresenter(UserDetailView mView, MembersDatabase mMembersDatabase) {
        this.mView = mView;
        this.mMembersDatabase = mMembersDatabase;
    }

    public void getMember(String memberId) {
        MemberModel member = mMembersDatabase.getMember(memberId);
        mView.setMember(member);
    }
}
