package be.totaboda.api.user;

import be.totaboda.domain.users.Employee;
import be.totaboda.domain.users.Member;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import be.totaboda.service.UserService;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    UserMapper userMapper;

    @Inject
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path= "/members", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createMember (@RequestBody UserDto member) {
        Member newMember = (Member) userService.addUser(userMapper.toMember(member));
        return userMapper.memberToDto(newMember);
    }

    @PostMapping(path= "/employees", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createEmployee(@RequestBody UserDto employee) {
        Employee newEmployee = (Employee) userService.addUser(userMapper.mapDtoToEmployee(employee));
        return userMapper.mapEmployeeToDto(newEmployee);
    }

    @GetMapping(path = "/members/{memberId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getMember(@PathVariable int memberId) {
        return userMapper.memberToDto((Member) userService.getUser(memberId));
    }

    @GetMapping(path= "/members", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getMembers(){
        List<Member> aList = userService.getAllMembers();
        return aList.stream().map(x->userMapper.memberWithoutSensitiveInformationToDto(x)).collect(Collectors.toList());
    }
}
