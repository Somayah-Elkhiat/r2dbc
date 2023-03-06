package cams.tv.tvmanagement.repository;

import cams.tv.tvmanagement.entity.BoutiqaatProductPK;
import cams.tv.tvmanagement.entity.BoutiqaattvProducts;
import net.lecousin.reactive.data.relational.query.SelectQuery;
import net.lecousin.reactive.data.relational.query.criteria.Criteria;
import net.lecousin.reactive.data.relational.repository.LcR2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoutiqaatTvProductRepository extends LcR2dbcRepository<BoutiqaattvProducts, BoutiqaatProductPK> {
    default Flux<BoutiqaattvProducts> findByTvId(Long tvId){
        return SelectQuery
                .from(BoutiqaattvProducts.class, "boutiqaattv_products")
                .join("boutiqaattv_products", "boutiqaattv", "boutiqaattv")
                .join("boutiqaattv_products", "catalogProductEntity", "catalogProductEntity")
                .where(Criteria.property("boutiqaattv", "id").is(tvId))
                .execute(getLcClient());

    }
}
