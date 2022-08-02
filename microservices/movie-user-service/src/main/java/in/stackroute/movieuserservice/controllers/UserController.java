package in.stackroute.movieuserservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.movieuserservice.domain.User;
import in.stackroute.movieuserservice.dto.LoginDto;
import in.stackroute.movieuserservice.dto.LoginResponseDto;
import in.stackroute.movieuserservice.dto.UserDto;
import in.stackroute.movieuserservice.dto.ValidationResponseDto;
import in.stackroute.movieuserservice.service.SecurityService;
import in.stackroute.movieuserservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private SecurityService securityService;

    private ModelMapper modelMapper;

    public UserController(UserService userService, SecurityService securityService,
            ModelMapper modelMapper) {
        this.userService = userService;
        this.securityService = securityService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        var user = userService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(user, UserDto.class));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto) {
        var user = userService.getUserByUserNameAndPassword(loginDto.getUserName(),
                loginDto.getPassword());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        if (user.isPresent()) {
            loginResponseDto.setUserName(user.get().getUserName());
            loginResponseDto.setValid(true);
            loginResponseDto.setToken(securityService.generateToken(user.get()));
            return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
        }
        loginResponseDto.setValid(false);
        loginResponseDto.setUserName(loginDto.getUserName());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginResponseDto);

    }

    @PostMapping("/validate")
    public ResponseEntity<ValidationResponseDto> validateToken(@RequestHeader("Authorization") String token) {
        ValidationResponseDto loginResponse = securityService.validateToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);

    }
}
