package babs.slackteam.userlist;

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
        private String firstName;
        private String lastName;
        private String imageOriginal;
        private String title;
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
