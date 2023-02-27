package cams.tv.tvmanagement.repository;

import cams.tv.tvmanagement.entity.CatalogProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CatalogProductEntityRepository extends R2dbcRepository<CatalogProductEntity, Integer> {

    Mono<CatalogProductEntity> findByRowId(Integer rowId);
}
