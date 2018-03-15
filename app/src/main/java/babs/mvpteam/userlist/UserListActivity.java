package babs.mvpteam.userlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import babs.mvpteam.R;
import babs.mvpteam.MVPTeamApp;
import babs.mvpteam.helpers.RecyclerTouchListener;
import babs.mvpteam.helpers.RecyclerViewClickListener;
import babs.mvpteam.networking.ApiClient;
import babs.mvpteam.persistence.MemberModel;
import babs.mvpteam.userdetail.UserDetailActivity;

public class UserListActivity extends AppCompatActivity implements UserListContract.View {
    public static final String MEMBER_ID = "memberId";
    private RecyclerView mUsersRecyclerView;
    private UserListAdapter mUserListAdapter;
    private Toolbar mToolbar;
    UserListPresenter mUserListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        initViews();
        setupToolbar();
        mUserListPresenter = new UserListPresenter(this,
                MVPTeamApp.getInstance().getMembersDatabase(),
                ApiClient.getInstance().getApiService());
        mUserListPresenter.onViewCreated();

    }


    private void initViews() {
        mToolbar = findViewById(R.id.tbUserList);
        mUsersRecyclerView = findViewById(R.id.rvUsersList);
        mUserListAdapter = new UserListAdapter(this);
        mUsersRecyclerView.setAdapter(mUserListAdapter);
        mUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUsersRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mUsersRecyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                MemberModel member = mUserListAdapter.getItem(position);
                String memberId = member.id;
                transitionToMemberDetail(memberId);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }


    private void setupToolbar() {
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    private void transitionToMemberDetail(String memberId) {
        Intent intent = new Intent(UserListActivity.this, UserDetailActivity.class);
        intent.putExtra(MEMBER_ID, memberId);
        startActivity(intent);
    }

    @Override
    public void setMembersList(@Nullable List<MemberModel> memberList) {
        if (memberList != null) {
            mUserListAdapter.addMembers(memberList);
        }
    }
}
