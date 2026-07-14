package yeolmok.springcachewithcaffeine.commoncode.mapper;

import org.mapstruct.Mapper;
import yeolmok.springcachewithcaffeine.commoncode.dto.CommonCodeDTO;
import yeolmok.springcachewithcaffeine.commoncode.entity.CommonCode;

@Mapper(componentModel = "spring")
public interface CommonCodeMapper {

    CommonCodeDTO commonCodeToCommonCodeDTO(CommonCode commonCode);
}
