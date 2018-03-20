package totaboda.mapper;

import be.totaboda.users.LoggedInUser;
import be.totaboda.users.Member;
import be.totaboda.users.UserBuilder;
import totaboda.dtos.UserDto;

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
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .witheMail(member.geteMail())
                .withStreetNumber(member.getStreetNumber())
                .withStreetName(member.getStreetName())
                .withPostalCode(member.getPostalCode())
                .withCity(member.getCity())
                .withInss(member.getInss());
    }
}
