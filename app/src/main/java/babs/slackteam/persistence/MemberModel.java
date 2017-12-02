package babs.slackteam.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by babusr on 12/2/17.
 */

@Entity(tableName = "member")
public class MemberModel {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    public String id;

    @ColumnInfo(name = "name")
    public String name;

    @Embedded
    public Profile profile;

    public static class Profile {
        @ColumnInfo(name = "first_name")
        private String firstName;

        @ColumnInfo(name = "last_name")
        private String lastName;

        @ColumnInfo(name = "image_url")
        private String imageOriginal;

        @ColumnInfo(name = "title")
        private String title;

        @ColumnInfo(name = "real_name")
        private String realName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getImageOriginal() {
            return imageOriginal;
        }

        public void setImageOriginal(String imageOriginal) {
            this.imageOriginal = imageOriginal;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }
    }
}
