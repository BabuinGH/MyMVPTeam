package babs.slackteam.userlist;

import java.util.List;

import babs.slackteam.persistence.MemberModel;

/**
 * Created by babusr on 11/27/17.
 */

public interface UserListContract {

    interface View {
        void setMembersList(List<MemberModel> memberList);
    }

}
