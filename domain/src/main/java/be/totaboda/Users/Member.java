package be.totaboda.Users;

public class Member implements LoggedInUser{
    private String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
    private int userId;
    private Role role;

    public Member(UserBuilder userBuilder) {
        this.firstName = userBuilder.getFirstName();
        this.lastName = userBuilder.getLastName();
        this.Inss = userBuilder.getInss();
        this.eMail = userBuilder.geteMail();
        this.streetName = userBuilder.getStreetName();
        this.streetNumber = userBuilder.getStreetNumber();
        this.postalCode = userBuilder.getPostalCode();
        this.city = userBuilder.getCity();
        this.role = Role.ROLE_MEMBER;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInss() {
        return Inss;
    }

    public String geteMail() {
        return eMail;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public Role getRole() {
        return role;
    }
}
