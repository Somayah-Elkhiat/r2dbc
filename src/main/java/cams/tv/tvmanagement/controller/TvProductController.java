package cams.tv.tvmanagement.controller;

import cams.tv.tvmanagement.exception.BoutiqaatTvNotFoundException;
import cams.tv.tvmanagement.model.TvProductModel;
import cams.tv.tvmanagement.model.TvProductsRequest;
import cams.tv.tvmanagement.services.TvProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/tv/products")
public class TvProductController {

    @Autowired
    private TvProductsService tvProductsService;

    public static final int LIMIT_DEFAULT = 20;
    public static final String DEFAULT_SORT_BY_COLUMN = "product_id";

    @PostMapping("/{tvId}")
    public Mono<ResponseEntity<List<TvProductModel>>> getProducts(@PathVariable("tvId") Long tvId, TvProductsRequest tvFilterProductsRequest,
                                                                  @PageableDefault(size = LIMIT_DEFAULT,
                                                                          sort = DEFAULT_SORT_BY_COLUMN,
                                                                          direction = Sort.Direction.ASC) Pageable page){
        return tvProductsService.getTvProducts(tvId, tvFilterProductsRequest, page)
                .collectList().map(products -> ResponseEntity.ok().body(products))
                .switchIfEmpty(Mono.error(new BoutiqaatTvNotFoundException("No Products Found")));


    }
}
