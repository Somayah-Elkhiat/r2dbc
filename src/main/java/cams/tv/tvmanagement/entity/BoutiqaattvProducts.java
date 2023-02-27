package cams.tv.tvmanagement.entity;

import lombok.Data;
//import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "boutiqaattv_products")
@Data
@IdClass(BoutiqaatProductPK.class)
public class BoutiqaattvProducts {

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "sort_order")
    private Integer sortOrder;

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tv_id")
    private Long tvId;

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
    private Integer productId;

}
