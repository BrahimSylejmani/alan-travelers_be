package org.alan.flightbooking.service;
import org.alan.flightbooking.model.User;
import java.util.List;

public interface UserService {


    User save(User user);

    List<User> findAll();

    User findById(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
