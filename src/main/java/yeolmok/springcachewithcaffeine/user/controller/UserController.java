package yeolmok.springcachewithcaffeine.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeolmok.springcachewithcaffeine.user.dto.UserResponseDTO;
import yeolmok.springcachewithcaffeine.user.service.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }
}
