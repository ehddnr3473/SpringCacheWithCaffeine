package yeolmok.springcachewithcaffeine.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yeolmok.springcachewithcaffeine.user.dto.UserDTO;
import yeolmok.springcachewithcaffeine.user.entity.User;
import yeolmok.springcachewithcaffeine.user.mapper.UserMapper;
import yeolmok.springcachewithcaffeine.user.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Cacheable(value = "users", key = "#userId")
    public UserDTO getUserById(Long userId) {
        log.info("DB 조회");

        User user = userRepository.findById(userId).orElse(null);
        return userMapper.userToUserDTO(user);
    }
}
