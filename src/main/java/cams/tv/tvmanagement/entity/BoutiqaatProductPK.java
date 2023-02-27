package cams.tv.tvmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BoutiqaatProductPK {

    private Long boutiqaattv;

    private Integer catalogProductEntity;
}
