package be.totaboda.Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggedInUser {
    private String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
    private int userId;

    private LoggedInUser(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.Inss = userBuilder.Inss;
        this.eMail=userBuilder.eMail;
        this.streetName=userBuilder.streetName;
        this.streetNumber= userBuilder.streetNumber;
        this.postalCode = userBuilder.postalCode;
        this.city = userBuilder.city;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInss() {
        return Inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
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

    public static class UserBuilder {
        private String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
        private int userId;

        public static final Pattern VALID_EMAIL =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


        public static UserBuilder BuildAPerson() {
            return new UserBuilder();
        }

        public LoggedInUser build() {
            if (allFieldsSet()) {
                return new LoggedInUser(this);
            }
            throw new IllegalArgumentException("Please provide all the necessary arguments.");
        }

        private boolean allFieldsSet() {
            return Inss!=null
                && lastName!=null && firstName!=null
                    && firstName!=null && eMail!=null
                    && streetName!=null && streetNumber!=null
                    && postalCode!=null && city!=null;
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
            validateEmailAddress(eMail);
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

        private void validateEmailAddress(String emailAddress) {
            if (isValidEmailAddress(emailAddress)) {
                this.eMail = emailAddress;
            }
            else {
                throw new IllegalArgumentException("Please provide a valid e-mail address.\nCorrect Format: \"xx@xx.xx\"");
            }
        }
        private static boolean isValidEmailAddress(String email) {
            Matcher matcher = VALID_EMAIL.matcher(email);
            return matcher.find();
        }
    }
}
