package c1;

/**
 * @author Rod
 * @date 2020/7/3
 */

public class UserPojo {

    private int userId;

    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "[userId="+this.userId+",userName="+this.userName+"]";
    }


}
