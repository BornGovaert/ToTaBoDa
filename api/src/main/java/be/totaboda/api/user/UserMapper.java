package be.totaboda.api.user;

import be.totaboda.domain.users.LoggedInUser;
import be.totaboda.domain.users.Member;
import be.totaboda.domain.users.Role;
import be.totaboda.domain.users.UserBuilder;

import javax.inject.Named;

@Named
public class UserMapper {

    public LoggedInUser toMember(UserDto userDto) {
        return UserBuilder.buildUser()
                .withFirstName(userDto.firstName)
                .withLastName(userDto.lastName)
                .withEMail(userDto.eMail)
                .withStreetNumber(userDto.streetNumber)
                .withStreetName(userDto.streetName)
                .withPostalCode(userDto.postalCode)
                .withCity(userDto.city)
                .withInss(userDto.Inss)
                .buildMember();
    }

    public UserDto memberToDto(Member member) {
        return new UserDto()
                .withUserId(member.getUserId())
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .witheMail(member.geteMail())
                .withStreetNumber(member.getStreetNumber())
                .withStreetName(member.getStreetName())
                .withPostalCode(member.getPostalCode())
                .withCity(member.getCity())
                .withInss(member.getInss())
                .withRole(member.getRole());
    }
    public UserDto memberWithoutSensitiveInformationToDto(Member member) {
        UserDto userDto = memberToDto(member);
        userDto.withInss(null);
        return userDto;
    }

    public LoggedInUser mapDtoToEmployee(UserDto userDto){
        return UserBuilder.buildUser()
                .withFirstName(userDto.firstName)
                .withLastName(  userDto.lastName)
                .withEMail(userDto.eMail)
                .withRole(Enum.valueOf(Role.class, userDto.role))
                .buildEmployee();
    }

    public UserDto mapEmployeeToDto(LoggedInUser user){
        return new UserDto()
                .withUserId(user.getUserId())
                .withFirstName(user.getFirstName())
                .withFirstName(user.getLastName())
                .witheMail(user.geteMail())
                .withRole(user.getRole());
    }
}
