package cams.tv.tvmanagement.entity;

import lombok.Data;
import net.lecousin.reactive.data.relational.annotations.ForeignKey;
//import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.sql.Timestamp;

@org.springframework.data.relational.core.mapping.Table(name = "boutiqaattv_products")
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
    @ForeignKey
    private Boutiqaattv boutiqaattv;

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey
    private CatalogProductEntity catalogProductEntity;

}
