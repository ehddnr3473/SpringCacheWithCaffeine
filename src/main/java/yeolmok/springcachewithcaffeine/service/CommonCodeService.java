package yeolmok.springcachewithcaffeine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yeolmok.springcachewithcaffeine.dto.CommonCodeResponseDTO;
import yeolmok.springcachewithcaffeine.entity.CommonCode;
import yeolmok.springcachewithcaffeine.repository.CommonCodeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;

    public List<CommonCodeResponseDTO> getCodes(String groupCode) {
        return commonCodeRepository.findByGroupCodeOrderBySortOrder(groupCode)
                .stream()
                .map(code -> new CommonCodeResponseDTO(
                        code.getCode(),
                        code.getCodeName()))
                .toList();
    }
}
