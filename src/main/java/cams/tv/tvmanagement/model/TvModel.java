package cams.tv.tvmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;

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
     
//    @Pattern(regexp = Constants.BOUTIQAATTV.VALIDATION_NAME_REGEX)
    private String enName;
     
    private String arabicName;
     
    private String videoUrl;
     
    private String thumbnail;
     
    private String thumbnailList;
     
    private String thumbnailGrid;
     
    private String storeIds;
     
    private String gender;
    private Integer brandId;
    private Integer categoryId;
    private Integer celebrityId;
    private Integer sortOrder;
     
    private Integer status;
    private Integer showInHome;

    private String tvDisplay;
    private Integer viewsCount;
    private Timestamp createdDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String excludeCountry;
}
