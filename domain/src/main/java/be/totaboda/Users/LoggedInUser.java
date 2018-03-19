package be.totaboda.Users;

public class LoggedInUser {
    private String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
    private int userId;

    private LoggedInUser(UserBuilder userBuilder) {
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static class UserBuilder {
        private String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
        private int userId;        
        public LoggedInUser build() {
            return new LoggedInUser(this);
        }

        public UserBuilder withInss(String inss) {
            Inss = inss;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public UserBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public UserBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public UserBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public UserBuilder withCity(String city) {
            this.city = city;
            return this;
        }
    }
}