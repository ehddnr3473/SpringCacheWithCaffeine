package yeolmok.springcachewithcaffeine.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {

    private final Long userId;
    private final String userName;
}
