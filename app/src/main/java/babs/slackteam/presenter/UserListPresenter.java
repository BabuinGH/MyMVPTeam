package babs.slackteam.presenter;

import android.util.Log;

import java.util.List;

import babs.slackteam.model.UserListModel;
import babs.slackteam.services.RetrofitService;
import babs.slackteam.services.UserListContract.View;
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

    public UserListPresenter(View view){
        mView = view;
        initPresenter();
    }

    private void initPresenter() {
        mUserListModel = new UserListModel();
        mView.initViews();
    }

    public void performNetworkOperation() {
        RetrofitService retrofitService = RetrofitService.retrofit.create(RetrofitService.class);
        Call<UserListModel> call =  retrofitService.getUsers();
        call.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                List<UserListModel.Member> memberList = response.body().getMembers();
                mView.setMembersList(memberList);
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}
