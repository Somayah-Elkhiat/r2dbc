package cams.tv.tvmanagement.repository;


import cams.tv.tvmanagement.entity.Boutiqaattv;
import cams.tv.tvmanagement.model.TvListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.data.relational.core.query.Criteria.where;

//import static org.springframework.data.relational.core.query.Criteria.where;

@Component
@RequiredArgsConstructor
public class BoutiqaatTvRepositoryImpl{

    private final R2dbcEntityTemplate template;

    public Flux<Boutiqaattv> findAllBy(TvListRequest request, Pageable pageable){
        return this.template.select(Boutiqaattv.class)
                .matching(Query.query(query(request)).with(pageable)).all();
    }

    public Flux<Boutiqaattv> findAllByEnNameOrArabicName(String enName, String arName){
        return this.template.select(Boutiqaattv.class)
                .matching(Query.query(where("enName").is(enName)
                        .or(where("arabicName").is(arName)))).all();
    }

    public Criteria query(TvListRequest request){
            List<Criteria> criteriaList = new ArrayList<>();

        for (Map.Entry<String, Object> filterOptions : request.getFilters().entrySet()) {
            switch (filterOptions.getKey()) {
                case "enName", "videoUrl", "arabicName", "gender":  // for handing gender
                    criteriaList.add(where(filterOptions.getKey()).like( "%" + filterOptions.getValue().toString() + "%"));
                    break;
                case "categoryId":
                    criteriaList.add(where(filterOptions.getKey()).is( filterOptions.getValue().toString()));
                    break;
                case "idTo":
                    criteriaList.add(where("id").lessThanOrEquals(request.getIdTo()));
                    break;
                case "idFrom": // IdFrom
                    criteriaList.add(where("id").greaterThanOrEquals(request.getIdTo()));
                    break;
                case "status":  // for handing status
                    criteriaList.add(where(filterOptions.getKey()).is(filterOptions.getValue()));
                    break;
                case "id":
                    criteriaList.add(where(filterOptions.getKey())
                            .in(request.getId()));
                    break;
                default:
                    criteriaList.add(where(filterOptions.getKey()).is(filterOptions.getValue()));
                    break;
            }
        }
        return Criteria.from(criteriaList);

    }
}
