package yeolmok.springcachewithcaffeine.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yeolmok.springcachewithcaffeine.user.dto.UserResponseDTO;
import yeolmok.springcachewithcaffeine.user.entity.User;
import yeolmok.springcachewithcaffeine.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return new UserResponseDTO(user.getUserId(), user.getUserName());
    }
}
