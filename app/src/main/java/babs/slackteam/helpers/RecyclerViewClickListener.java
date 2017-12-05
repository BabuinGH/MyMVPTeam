package babs.slackteam.helpers;

import android.view.View;

/**
 * Created by babusr on 12/3/17.
 */

public interface RecyclerViewClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
