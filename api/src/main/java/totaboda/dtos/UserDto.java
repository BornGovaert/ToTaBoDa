package totaboda.dtos;

import be.totaboda.users.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    public String Inss, lastName, firstName, eMail, streetName, streetNumber, postalCode, city;
    public int userId;
    public Role role;

    public UserDto withInss(String inss) {
        Inss = inss;
        return this;
    }

    public UserDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDto witheMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public UserDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public UserDto withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public UserDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public UserDto withCity(String city) {
        this.city = city;
        return this;
    }

    public UserDto withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public UserDto withRole(Role role) {
        this.role = role;
        return this;
    }
}
