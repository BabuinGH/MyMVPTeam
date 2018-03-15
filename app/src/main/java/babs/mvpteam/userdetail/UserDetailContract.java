package babs.mvpteam.userdetail;

import babs.mvpteam.persistence.MemberModel;

/**
 * Created by babusr on 12/3/17.
 */

public interface UserDetailContract {
    interface UserDetailView {
        void setMember(MemberModel member);
    }
}
