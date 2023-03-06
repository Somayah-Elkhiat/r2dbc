package cams.tv.tvmanagement.entity;

import lombok.Data;
import net.lecousin.reactive.data.relational.annotations.ForeignTable;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@org.springframework.data.relational.core.mapping.Table(name = "boutiqaattv")
@Data
public class Boutiqaattv implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "arabic_name")
    private String arabicName;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "celebrity_id")
    private Integer celebrityId;

    @Column(name = "created_date")
//    @JsonSerialize(using = CustomDateSerializer.class)
    private Timestamp createdDate;

    @Column(name = "end_date")
//    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate endDate;

    @Column(name = "start_date")
//    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate startDate;

    @Column(name = "en_name")
    private String enName;

    private String gender;

    @Column(name = "show_in_home")
    private Integer showInHome;

    @Column(name = "sort_order")
    private Integer sortOrder;

    private Integer status;

    @Column(name = "store_ids")
    private String storeIds;

    private String thumbnail;

    @Column(name = "thumbnail_grid")
    private String thumbnailGrid;

    @Column(name = "thumbnail_list")
    private String thumbnailList;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "views_count")
    private Integer viewsCount;

    @Column(name = "tv_display")
    private String tvDisplay;

    @Column(name = "exclude_country")
    private String excludeCountry;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "boutiqaattv")
    @ForeignTable(joinKey = "boutiqaattv")
    private List<BoutiqaattvProducts> products;
}
