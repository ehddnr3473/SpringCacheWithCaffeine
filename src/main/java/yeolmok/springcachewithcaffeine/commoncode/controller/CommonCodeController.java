package yeolmok.springcachewithcaffeine.commoncode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeolmok.springcachewithcaffeine.commoncode.dto.CommonCodeDTO;
import yeolmok.springcachewithcaffeine.commoncode.service.CommonCodeService;

import java.util.List;

@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CommonCodeController {

    private final CommonCodeService commonCodeService;

    @GetMapping("/{groupCode}")
    public List<CommonCodeDTO> getCodes(@PathVariable("groupCode") String groupCode) {
        return commonCodeService.getCodes(groupCode);
    }
}
