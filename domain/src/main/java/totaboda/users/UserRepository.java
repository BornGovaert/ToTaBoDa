package totaboda.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class UserRepository {
    Map<Integer, LoggedInUser> users;
    private int idCounter = 1;

    @Inject
    public UserRepository(UserData userData) {
        users = new HashMap<>();
        userData.getDefaultUsers()
                .forEach(user -> addUser(user));
    }

    public LoggedInUser getUserById(int userId) {
        if (!assertThatUserExist(userId)) {
            throw new IllegalArgumentException("No such user found.");
        }
        return users.get(userId);
    }

    public List<LoggedInUser> getAllUsers() {
        return Collections.unmodifiableList(new ArrayList<LoggedInUser>(users.values()));
    }

    public LoggedInUser addUser(LoggedInUser user) {
        user.setUserId(idCounter);
        users.put(idCounter, user);
        idCounter++;
        return user;
    }

    public void removeUser(int userId) {
        if (!assertThatUserExist(userId)) {
            throw new IllegalArgumentException("No such user found.");
        } else {
            users.remove(userId);
        }
    }

    public LoggedInUser updateUser(int userID, LoggedInUser user) {
        if (assertThatUserExist(userID)) {
            user.setUserId(userID);
            users.put(userID, user);
        } else {
            throw new IllegalArgumentException("No such user found.");
        }
        return user;
    }

    public boolean assertThatUserExist(int userId){
        return users.keySet().contains(userId);
    }

    public List<Member> getAllMembers() {
        return users
                .values()
                .stream()
                .filter(x -> x.getRole().equals(Role.ROLE_MEMBER))
                .map(x -> (Member) x)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return users
                .values()
                .stream()
                .filter(x -> !x.getRole().equals(Role.ROLE_MEMBER))
                .map(x -> (Employee) x)
                .collect(Collectors.toList());
    }
}
