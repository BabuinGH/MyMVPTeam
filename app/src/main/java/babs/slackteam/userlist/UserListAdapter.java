package babs.slackteam.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import babs.slackteam.R;
import babs.slackteam.persistence.MemberModel;

/**
 * Created by babusr on 11/27/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {
    private Context mContext;
    private List<MemberModel> mUsersList = new ArrayList<>();

    public UserListAdapter(Context context){
        mContext = context;
    }

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View UserListView = inflater.inflate(R.layout.user_list_item, parent, false);
        return new UserListViewHolder(UserListView);
    }

    @Override
    public void onBindViewHolder(UserListViewHolder holder, int position) {
        holder.bindView(mContext, mUsersList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    public void addMembers(List<MemberModel> memberList) {
        mUsersList.addAll(memberList);
        notifyDataSetChanged();
    }
}
