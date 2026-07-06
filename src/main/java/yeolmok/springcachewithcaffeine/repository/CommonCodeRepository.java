package yeolmok.springcachewithcaffeine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeolmok.springcachewithcaffeine.entity.CommonCode;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {

    List<CommonCode> findByGroupCodeOrderBySortOrder(String groupCode);
}
