package babs.mvpteam.persistence.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import babs.mvpteam.persistence.MemberModel;

/**
 * Created by babusr on 12/2/17.
 */


@Dao
public interface MemberDao {

    @Query("SELECT * from member")
    List<MemberModel> getMembers();


    /**
     * Insert members to database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMember(MemberModel member);

    /**
     * Get member based on id from database.
     */
    @Query("SELECT * from member WHERE id IN (:id) ")
    List<MemberModel> getMember(String id);

}
