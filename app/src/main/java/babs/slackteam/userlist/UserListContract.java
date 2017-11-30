package babs.slackteam.userlist;

import java.util.List;

/**
 * Created by babusr on 11/27/17.
 */

public interface UserListContract {
    interface View {
        void setMembersList(List<UserListModel.Member> memberList);
    }

    interface Presenter {

    }
}
