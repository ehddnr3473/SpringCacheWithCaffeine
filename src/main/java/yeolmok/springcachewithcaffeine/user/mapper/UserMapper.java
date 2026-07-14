package yeolmok.springcachewithcaffeine.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import yeolmok.springcachewithcaffeine.user.dto.UserDTO;
import yeolmok.springcachewithcaffeine.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userName", target = "name")
    UserDTO userToUserDTO(User user);
}
