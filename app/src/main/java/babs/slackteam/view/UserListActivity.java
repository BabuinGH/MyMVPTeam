package babs.slackteam.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import babs.slackteam.R;
import babs.slackteam.adapters.UserListAdapter;
import babs.slackteam.model.UserListModel;
import babs.slackteam.presenter.UserListPresenter;
import babs.slackteam.services.UserListContract;

public class UserListActivity extends AppCompatActivity implements UserListContract.View{
    private static final String TAG = "UserListActivity";
    private RecyclerView mUsersRecyclerView;
    private UserListAdapter mUserListAdapter;
    UserListPresenter mUserListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        mUserListPresenter = new UserListPresenter(this);
        mUserListPresenter.performNetworkOperation();
    }

    @Override
    public void initViews() {
        mUsersRecyclerView = findViewById(R.id.rvUsersList);
        mUserListAdapter = new UserListAdapter(this);
        mUsersRecyclerView.setAdapter(mUserListAdapter);
        mUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setMembersList(List<UserListModel.Member> memberList) {
        if(memberList != null){
            mUserListAdapter.addMembers(memberList);
        }
    }
}
