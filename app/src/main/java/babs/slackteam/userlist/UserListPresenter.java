package babs.slackteam.userlist;

import android.util.Log;

import java.util.List;

import babs.slackteam.networking.ApiService;
import babs.slackteam.persistence.MemberModel;
import babs.slackteam.persistence.MembersDatabase;
import babs.slackteam.userlist.UserListContract.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by babusr on 11/26/17.
 */

public class UserListPresenter implements MembersDatabase.UpdateMembersListener {
    private static final String TAG = "UserListPresenter";
    private View mView;
    MembersDatabase mMembersDatabase;
    ApiService mApiService;

    public UserListPresenter(View mView, MembersDatabase mMembersDatabase, ApiService mApiService) {
        this.mView = mView;
        this.mMembersDatabase = mMembersDatabase;
        this.mApiService = mApiService;
        mMembersDatabase.setListener(this);
    }

    public void onViewCreated() {
        mView.setMembersList(mMembersDatabase.getMembers());
        fetchDataFromServer();
    }

    private void fetchDataFromServer() {
        mApiService.getUsers().enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                List<MemberModel> memberList = response.body().getMembers();
                mMembersDatabase.insertMembers(memberList);
            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    @Override
    public void onMembersUpdated() {
        mView.setMembersList(mMembersDatabase.getMembers());
    }

}
