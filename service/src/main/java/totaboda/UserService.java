package totaboda;

import be.totaboda.Repositories.UserRepository;
import be.totaboda.Users.Member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {
    private static UserRepository userRepository;
    
    @Inject
    public UserService (UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public Member getUser(int userID) {
        return null;
    }

    public void removeUser(int userID) {
    }

    public Member addUser(Member user) {
        return null;
    }

    public List<Member> getAllUsers() {
        return null;
    }

    public Member updateUser(int userID, Member user) {
        return null;
    }

}
