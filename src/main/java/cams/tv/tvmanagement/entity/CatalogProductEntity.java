package cams.tv.tvmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.lecousin.reactive.data.relational.annotations.ForeignTable;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;

@org.springframework.data.relational.core.mapping.Table(name = "catalog_product_entity")
@Data
@NoArgsConstructor
public class CatalogProductEntity {
    @Id
    @Column(name = "row_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowId;

    @Column(name = "attribute_set_id")
    private Integer attributeSetId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_in")
    private BigInteger createdIn;

    @Column(name = "has_options")
    private short hasOptions;

    @Column(name = "required_options")
    private Integer requiredOptions;

    private String sku;

    @Column(name = "type_id")
    private String typeId;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_in")
    private BigInteger updatedIn;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "catalogProductEntity", fetch = FetchType.LAZY)
    @ForeignTable(joinKey = "catalogProductEntity")
    private Set<BoutiqaattvProducts> tvs;

}