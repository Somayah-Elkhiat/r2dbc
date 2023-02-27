package cams.tv.tvmanagement.services;

import cams.tv.tvmanagement.model.TvProductModel;
import cams.tv.tvmanagement.model.TvProductsRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public interface TvProductsService {

    Flux<TvProductModel> getTvProducts(Long tvId, TvProductsRequest request, Pageable pageable);
}
