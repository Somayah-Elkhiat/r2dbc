package cams.tv.tvmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvProductsRequest {

    private Integer productIdFrom;
    private Integer productIdTo;
    private String name;
    private String sku;
    protected String productId;

    private Map<String, Object> filterOptions;

    public Map<String, Object> getFilters() {

        Map<String, Object> filterOptions = new HashMap<>();
        filterOptions.put("productId", this.productId);
        filterOptions.put("sku", this.sku);
        filterOptions.put("name", Strings.isBlank(this.name) ? null : this.name);
        filterOptions.put("productIdFrom", productIdFrom);
        filterOptions.put("productIdTo", productIdTo);
        //       filterOptions.put("enabledProductsCount", Objects.isNull(this.enabledProductsCount) ? null : this.enabledProductsCount);

        filterOptions.entrySet().removeIf(entry -> ObjectUtils.isEmpty(entry.getValue()));
        if (ObjectUtils.isEmpty(filterOptions) && !ObjectUtils.isEmpty(this.getFilterOptions())) {
            filterOptions.putAll(this.getFilterOptions());
        }
        filterOptions.entrySet().removeIf(entry -> ObjectUtils.isEmpty(entry.getValue()));
        return filterOptions;
    }
}
