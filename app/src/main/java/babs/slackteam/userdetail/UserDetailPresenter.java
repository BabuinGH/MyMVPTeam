package babs.slackteam.userdetail;

import babs.slackteam.persistence.MemberModel;
import babs.slackteam.persistence.MembersDatabase;

import static babs.slackteam.userdetail.UserDetailContract.UserDetailView;

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
