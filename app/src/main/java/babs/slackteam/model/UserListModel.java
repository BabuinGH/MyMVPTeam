package babs.slackteam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by babusr on 11/26/17.
 */

public class UserListModel {
    public List<Member> members;

    public List<Member> getMembers() {
        return members;
    }

    public static class Member {
        public String id;
        public String name;
        public Profile profile;
    }

    public static class Profile {
        @SerializedName("first_name")
        @Expose
        private String firstName;

        @SerializedName("last_name")
        @Expose
        private String lastName;

        @SerializedName("image_original")
        @Expose
        private String imageOriginal;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("real_name")
        @Expose
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
