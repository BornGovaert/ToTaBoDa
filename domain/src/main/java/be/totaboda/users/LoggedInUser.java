package be.totaboda.users;

public interface LoggedInUser {
    public void setUserId(int userId);
    public String getFirstName();
    public String getLastName();
    public String geteMail();
    public int getUserId();
    public Role getRole();
}
