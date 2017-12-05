package babs.slackteam.userdetail;

import babs.slackteam.persistence.MemberModel;

/**
 * Created by babusr on 12/3/17.
 */

public interface UserDetailContract {
    interface UserDetailView {
        void setMember(MemberModel member);
    }
}
