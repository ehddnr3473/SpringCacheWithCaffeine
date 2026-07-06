package yeolmok.springcachewithcaffeine.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeolmok.springcachewithcaffeine.dto.CommonCodeResponseDTO;
import yeolmok.springcachewithcaffeine.service.CommonCodeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CommonCodeController {

    private final CommonCodeService commonCodeService;

    @GetMapping("/{groupCode}")
    public List<CommonCodeResponseDTO> getCodes(@PathVariable("groupCode") String groupCode) {
        return commonCodeService.getCodes(groupCode);
    }
}
