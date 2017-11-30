package babs.slackteam.services;

import java.util.List;

import babs.slackteam.model.UserListModel;

/**
 * Created by babusr on 11/27/17.
 */

public interface UserListContract {
    interface View {
        void initViews();
        void setMembersList(List<UserListModel.Member> memberList);
    }

    interface Presenter {

    }
}
