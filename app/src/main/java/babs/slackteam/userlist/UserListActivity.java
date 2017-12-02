package babs.slackteam.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import babs.slackteam.R;
import babs.slackteam.SlackApp;
import babs.slackteam.persistence.MemberModel;

public class UserListActivity extends AppCompatActivity implements UserListContract.View {
    private static final String TAG = "UserListActivity";
    private RecyclerView mUsersRecyclerView;
    private UserListAdapter mUserListAdapter;
    UserListPresenter mUserListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        initViews();
        mUserListPresenter = new UserListPresenter(this);
        mUserListPresenter.fetchUserList();
    }

    private void initViews() {
        mUsersRecyclerView = findViewById(R.id.rvUsersList);
        mUserListAdapter = new UserListAdapter(this);
        mUsersRecyclerView.setAdapter(mUserListAdapter);
        mUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setMembersList(@Nullable List<MemberModel> memberList) {
        if (memberList != null) {
            mUserListAdapter.addMembers(memberList);
            List<MemberModel> members = SlackApp.getInstance().getDatabase().memberDao().getMembers();
            for(MemberModel member: members){
                Log.d("@@@@", member.name);
            }

        }
    }
}
