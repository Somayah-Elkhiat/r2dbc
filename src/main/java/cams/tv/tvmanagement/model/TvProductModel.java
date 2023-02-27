package cams.tv.tvmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvProductModel {

    private Integer productId;
    private String name;
    private Long tvId;
    private String sku;
    private Double price;
    private String gender;
    private String productMappingStatus;
    private String imageUrl;
    private Boolean stockOut;
}
