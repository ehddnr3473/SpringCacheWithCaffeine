package yeolmok.springcachewithcaffeine.commoncode.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import yeolmok.springcachewithcaffeine.commoncode.dto.CommonCodeDTO;
import yeolmok.springcachewithcaffeine.commoncode.entity.CommonCode;
import yeolmok.springcachewithcaffeine.commoncode.mapper.CommonCodeMapper;
import yeolmok.springcachewithcaffeine.commoncode.repository.CommonCodeRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeMapper commonCodeMapper;

    private final CacheManager cacheManager;

    @PostConstruct
    public void loadCache() {
        refresh();
    }

    @Scheduled(fixedRate = 60 * 5 * 1000)
    public void refresh() {
        List<CommonCode> codes = commonCodeRepository.findAll();

        Map<String, List<CommonCode>> map = codes.stream().collect(Collectors.groupingBy(CommonCode::getGroupCode));

        cacheManager.getCache("commonCodes")
                    .put("ALL", map);
    }

    @SuppressWarnings("unchecked")
    public List<CommonCodeDTO> getCodes(String groupCode) {
        Cache.ValueWrapper wrapper = cacheManager.getCache("commonCodes").get("ALL");

        if (wrapper == null) {
            refresh();
            wrapper = cacheManager.getCache("commonCodes").get("ALL");
        }

        Map<String, List<CommonCode>> map = (Map<String, List<CommonCode>>) wrapper.get();

        return map.getOrDefault(groupCode, List.of())
                .stream()
                .map(commonCodeMapper::commonCodeToCommonCodeDTO)
                .toList();
    }
}
