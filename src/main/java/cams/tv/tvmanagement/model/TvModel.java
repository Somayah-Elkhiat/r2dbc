package cams.tv.tvmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
//    @Pattern(regexp = Constants.BOUTIQAATTV.VALIDATION_NAME_REGEX)
    private String enName;
    @NotNull
    private String arabicName;
    @NotNull
    private String videoUrl;
    @NotNull
    private String thumbnail;
    @NotNull
    private String thumbnailList;
    @NotNull
    private String thumbnailGrid;
    @NotNull
    private String storeIds;
    @NotNull
    private String gender;
    private Integer brandId;
    private Integer categoryId;
    private Integer celebrityId;
    private Integer sortOrder;
    @NotNull
    private Integer status;
    private Integer showInHome;

    private String tvDisplay;
    private Integer viewsCount;
    private Timestamp createdDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String excludeCountry;
}
