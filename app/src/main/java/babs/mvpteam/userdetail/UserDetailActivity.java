package babs.mvpteam.userdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import babs.mvpteam.R;
import babs.mvpteam.MVPTeamApp;
import babs.mvpteam.persistence.MemberModel;
import babs.mvpteam.userlist.UserListActivity;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by babusr on 12/3/17.
 */

public class UserDetailActivity extends AppCompatActivity implements UserDetailContract.UserDetailView {
    private ImageView mProfilePhoto;
    private ImageView mBackgroundImage;
    private TextView mMemberName;
    private TextView mMemberJobTitle;
    private TextView mMemberEmail;
    private TextView mMemberPhone;
    private Toolbar mToolbar;
    UserDetailPresenter mUserDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);
        initViews();
        setupToolbar();

        String memberId = getIntent().getStringExtra(UserListActivity.MEMBER_ID);
        mUserDetailPresenter = new UserDetailPresenter(this,
                MVPTeamApp.getInstance().getMembersDatabase());
        mUserDetailPresenter.getMember(memberId);
    }


    private void initViews() {
        mProfilePhoto = findViewById(R.id.ivProfilePicture);
        mBackgroundImage = findViewById(R.id.ivBackgroundImage);
        mMemberName = findViewById(R.id.tvProfileName);
        mMemberJobTitle = findViewById(R.id.tvProfileJobTitle);
        mMemberEmail = findViewById(R.id.tvProfileEmail);
        mMemberPhone = findViewById(R.id.tvProfilePhone);
        mToolbar = findViewById(R.id.tbUserDetail);
    }

    private void setupToolbar() {
        mToolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        mToolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void setMember(MemberModel member) {
        String memberPhotoUrl = member.profile.getImageOriginal();

        mMemberName.setText(member.getName());
        mMemberJobTitle.setText(member.profile.getTitle());
        mMemberEmail.setText(member.profile.getEmail());
        mMemberPhone.setText(member.profile.getPhone());

        if (memberPhotoUrl != null) {
            Glide.with(this).load(memberPhotoUrl)
                    .apply(RequestOptions.circleCropTransform()).into(mProfilePhoto);
            Glide.with(this).load(memberPhotoUrl)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25))).into(mBackgroundImage);
        } else {
            Glide.with(this).load(R.drawable.slack_bot1)
                    .apply(RequestOptions.circleCropTransform()).into(mProfilePhoto);
            Glide.with(this).load(R.drawable.slack_bot1)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25))).into(mBackgroundImage);
        }
    }
}
