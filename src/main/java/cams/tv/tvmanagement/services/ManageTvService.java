package cams.tv.tvmanagement.services;

import cams.tv.tvmanagement.model.TvListRequest;
import cams.tv.tvmanagement.model.TvModel;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ManageTvService {

    Flux<TvModel> getTvList(TvListRequest request, Pageable pages);

    Mono<TvModel> addTv(TvModel tvModel);
}
