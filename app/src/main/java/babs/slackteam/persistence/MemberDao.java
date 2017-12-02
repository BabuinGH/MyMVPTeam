package babs.slackteam.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by babusr on 12/2/17.
 */


@Dao
public interface MemberDao {

    @Query("SELECT * from member")
    List<MemberModel> getMembers();


    /**r
        Insert members to database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMember(MemberModel member);

}
