package be.totaboda.Users;

public class Employee implements LoggedInUser{
    private String lastName, firstName, eMail;
    private int userId;
    private Role role;

    public Employee(UserBuilder userBuilder) {
        this.firstName = userBuilder.getFirstName();
        this.lastName = userBuilder.getLastName();

        this.eMail = userBuilder.geteMail();

        this.role = userBuilder.getRole();
    }

    @Override
    public void setUserId(int userId) {
        this.userId=userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public int getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }
}
