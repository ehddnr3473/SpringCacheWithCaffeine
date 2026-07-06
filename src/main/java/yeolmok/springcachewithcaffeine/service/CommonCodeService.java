package yeolmok.springcachewithcaffeine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yeolmok.springcachewithcaffeine.dto.CommonCodeResponseDTO;
import yeolmok.springcachewithcaffeine.entity.CommonCode;
import yeolmok.springcachewithcaffeine.repository.CommonCodeRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;

    @Cacheable(value = "commonCodes", key = "#groupCode")
    public List<CommonCodeResponseDTO> getCodes(String groupCode) {

        log.info("DB 조회");

        return commonCodeRepository.findByGroupCodeOrderBySortOrder(groupCode)
                .stream()
                .map(code -> new CommonCodeResponseDTO(
                        code.getCode(),
                        code.getCodeName()))
                .toList();
    }
}
