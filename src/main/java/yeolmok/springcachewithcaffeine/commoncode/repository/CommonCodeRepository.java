package yeolmok.springcachewithcaffeine.commoncode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeolmok.springcachewithcaffeine.commoncode.entity.CommonCode;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {

    List<CommonCode> findByGroupCodeOrderBySortOrder(String groupCode);
}
