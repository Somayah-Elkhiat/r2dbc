package cams.tv.tvmanagement.repository;

import cams.tv.tvmanagement.entity.Boutiqaattv;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoutiqaatTvRepository extends R2dbcRepository<Boutiqaattv, Long> {

    Flux<Boutiqaattv> findAllBy(Pageable pageable);

    Flux<Boutiqaattv> findAllByEnNameOrArabicName(String enName, String arabicName);
}
