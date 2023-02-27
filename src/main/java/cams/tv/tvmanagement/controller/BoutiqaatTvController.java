package cams.tv.tvmanagement.controller;

import cams.tv.tvmanagement.exception.BoutiqaatTvNotFoundException;
import cams.tv.tvmanagement.model.TvListRequest;
import cams.tv.tvmanagement.model.TvModel;
import cams.tv.tvmanagement.services.ManageTvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/v1/tv")
public class BoutiqaatTvController {

    @Autowired
    private ManageTvService manageTvService;

    public static final int LIMIT_DEFAULT = 3;
    public static final String DEFAULT_SORT_BY_COLUMN = "id";

    @PostMapping
    public Mono<ResponseEntity<List<TvModel>>> getListingPage(
            @PathVariable(value = "tvId", required = false) Long tvId,
            TvListRequest requestOptions,
            @PageableDefault(size = LIMIT_DEFAULT,
                    sort = DEFAULT_SORT_BY_COLUMN,
                    direction = Sort.Direction.ASC) Pageable pages){

        return manageTvService.getTvList(requestOptions, pages)
                        .collectList().map(tvModels -> ResponseEntity.ok().body(tvModels))
                .switchIfEmpty(Mono.error(new BoutiqaatTvNotFoundException("No TVs are found")));

    }

    @PostMapping("/addTv")
    public Mono<ResponseEntity<TvModel>> addTv(@Validated @RequestBody TvModel tvModel) {
        return manageTvService.addTv(tvModel)
                .map(tvModel1 -> ResponseEntity.ok().body(tvModel1))
                .switchIfEmpty(Mono.error(new RuntimeException("Error while mapping the tv to entity")));
    }
}
