package babs.mvpteam.networking;

import babs.mvpteam.userlist.UserListModel;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by babusr on 11/26/17.
 */

public interface ApiService {

    /**
     * Fetch List of users
     */
    @POST("users.list")
    Call<UserListModel> getUsers();

}
