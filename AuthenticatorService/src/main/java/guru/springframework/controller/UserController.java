package guru.springframework.controller;

import guru.springframework.config.JwtGeneratorInterface;
import guru.springframework.exception.UserNotFoundException;
import guru.springframework.model.User;
import guru.springframework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;
    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    public UserController(UserService userService, JwtGeneratorInterface jwtGenerator){
        this.userService=userService;
        this.jwtGenerator=jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getUserName() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Username or password is empty");
            }
            User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
            Map<String, String> tokenMap = jwtGenerator.generateToken(userData);
            return new ResponseEntity<>(tokenMap, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
