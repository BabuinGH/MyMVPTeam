package babs.mvpteam.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import babs.mvpteam.R;
import babs.mvpteam.persistence.MemberModel;

/**
 * Created by babusr on 11/27/17.
 */

public class UserListViewHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView jobTitle;
    private ImageView profilePhoto;

    public UserListViewHolder(View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.tvFirstName);
        jobTitle = itemView.findViewById(R.id.tvJobTitle);
        profilePhoto = itemView.findViewById(R.id.ivProfilePhoto);

    }

    public void bindView(Context mContext, MemberModel userListModel) {
        firstName.setText(userListModel.name);
        jobTitle.setText(userListModel.profile.getTitle());
        if (userListModel.profile.getImageOriginal() != null) {
            Glide.with(mContext).load(userListModel.profile.getImageOriginal())
                    .apply(RequestOptions.circleCropTransform()).into(profilePhoto);
        } else {
            Glide.with(mContext).load(R.drawable.slack_bot1)
                    .apply(RequestOptions.circleCropTransform()).into(profilePhoto);
        }

    }
}
