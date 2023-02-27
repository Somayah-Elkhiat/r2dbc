package cams.tv.tvmanagement.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "boutiqaattv")
@Data
public class Boutiqaattv implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    private String arabicName;

    private Integer brandId;

    private Integer categoryId;

    private Integer celebrityId;

//    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp createdDate;

//    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate endDate;

//    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate startDate;

    private String enName;

    private String gender;

    private Integer showInHome;

    private Integer sortOrder;

    private Integer status;

//    @Column(name = "store_ids")
    private String storeIds;

    private String thumbnail;

//    @Column(name = "thumbnail_grid")
    private String thumbnailGrid;

//    @Column(name = "thumbnail_list")
    private String thumbnailList;

//    @Column(name = "video_url")
    private String videoUrl;

//    @Column(name = "views_count")
    private Integer viewsCount;

//    @Column(name = "tv_display")
    private String tvDisplay;

//    @Column(name = "exclude_country")
    private String excludeCountry;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "boutiqaattv")
//    private Set<BoutiqaatTvProduct> products;
}
