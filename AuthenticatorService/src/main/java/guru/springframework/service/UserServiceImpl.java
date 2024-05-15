package guru.springframework.service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import guru.springframework.exception.UserNotFoundException;
import guru.springframework.model.User;
import guru.springframework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;

    }
    @Override
    public void saveUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);    }

    @Override
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        User user = userRepository.findByUserName(name);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UserNotFoundException("Invalid username or password");
        }
        return user;
    }
}
