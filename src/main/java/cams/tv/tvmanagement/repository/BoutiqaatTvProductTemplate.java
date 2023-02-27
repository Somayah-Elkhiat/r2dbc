package cams.tv.tvmanagement.repository;


import cams.tv.tvmanagement.entity.BoutiqaattvProducts;
import cams.tv.tvmanagement.model.TvProductsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.data.relational.core.query.Criteria.where;

@Component
@RequiredArgsConstructor
public class BoutiqaatTvProductTemplate {

    private final R2dbcEntityTemplate template;

    public Flux<BoutiqaattvProducts> findAllBy(Long tvId, TvProductsRequest request, Pageable pageable) {

        return this.template.select(BoutiqaattvProducts.class)
                .matching(Query.query(query(tvId, request)).with(pageable)).all();
    }

    public Criteria query(Long tvId, TvProductsRequest request) {
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(where("tv_id").is(tvId));
        for (Map.Entry<String, Object> filterOptions : request.getFilters().entrySet()) {
            switch (filterOptions.getKey()) {
                case "name":  // for handing gender
                    criteriaList.add(where(filterOptions.getKey()).like("%" + filterOptions.getValue().toString() + "%"));
                    break;
                case "sku":
                    criteriaList.add(where(filterOptions.getKey()).is(filterOptions.getValue().toString()));
                    break;
                case "productIdTo":
                    criteriaList.add(where("product_id").lessThanOrEquals(request.getProductIdTo()));
                    break;
                case "productIdFrom": // IdFrom
                    criteriaList.add(where("product_id").greaterThanOrEquals(request.getProductIdFrom()));
                    break;
                case "productId":
                    criteriaList.add(where("product_id")
                            .in(request.getProductId()));
                    break;
                default:
                    criteriaList.add(where(filterOptions.getKey()).is(filterOptions.getValue()));
                    break;
            }
        }
        return Criteria.from(criteriaList);


    }

}
