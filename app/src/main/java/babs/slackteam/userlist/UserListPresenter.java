package babs.slackteam.userlist;

import android.util.Log;

import java.util.List;

import babs.slackteam.SlackApp;
import babs.slackteam.network.ApiClient;
import babs.slackteam.persistence.MemberModel;
import babs.slackteam.userlist.UserListContract.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by babusr on 11/26/17.
 */

public class UserListPresenter {
    private static final String TAG = "UserListPresenter";
    private View mView;
    UserListModel mUserListModel;

    public UserListPresenter(View view) {
        mView = view;
        initPresenter();
    }

    private void initPresenter() {
        mUserListModel = new UserListModel();
    }

    public void fetchUserList() {
        ApiClient.getInstance().getApiService().getUsers().enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                List<MemberModel> memberList = response.body().getMembers();
                for (MemberModel member: memberList){
                    SlackApp.getInstance().getDatabase().memberDao().insertMember(member);
                }
                mView.setMembersList(memberList);
            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

}
