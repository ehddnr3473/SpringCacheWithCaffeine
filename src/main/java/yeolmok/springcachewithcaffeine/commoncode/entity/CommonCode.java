package yeolmok.springcachewithcaffeine.commoncode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "common_code_detail")
@IdClass(CommonCodeId.class)
@Getter
@NoArgsConstructor
public class CommonCode {

    @Id
    private String code;

    @Id
    private String groupCode;

    private String codeName;
    private int sortOrder;
}
