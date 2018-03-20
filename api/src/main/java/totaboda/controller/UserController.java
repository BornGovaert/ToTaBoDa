package totaboda.controller;

import totaboda.users.Member;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import totaboda.UserService;
import totaboda.dtos.UserDto;
import totaboda.mapper.UserMapper;

import javax.inject.Inject;

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

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createMember (@RequestBody UserDto member) {
        Member newMember = (Member) userService.addUser(userMapper.toMember(member));
        return userMapper.memberToDto(newMember);
    }
    @GetMapping(path = "/members/{memberId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getMember(@PathVariable int memberId) {
        return userMapper.memberToDto((Member) userService.getUser(memberId));
    }
}
