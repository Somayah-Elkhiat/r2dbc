package cams.tv.tvmanagement.services.impl;

import cams.tv.tvmanagement.entity.BoutiqaattvProducts;
import cams.tv.tvmanagement.entity.CatalogProductEntity;
import cams.tv.tvmanagement.model.TvProductModel;
import cams.tv.tvmanagement.model.TvProductsRequest;
import cams.tv.tvmanagement.repository.BoutiqaatTvProductTemplate;
import cams.tv.tvmanagement.repository.CatalogProductEntityRepository;
import cams.tv.tvmanagement.services.TvProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class TvProductsServiceImpl implements TvProductsService {

    @Autowired
    private BoutiqaatTvProductTemplate tvProductsTemplate;

    @Autowired
    private CatalogProductEntityRepository productEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Flux<TvProductModel> getTvProducts(Long tvId, TvProductsRequest request, Pageable pageable) {
        return tvProductsTemplate.findAllBy(tvId, request, pageable)
                .flatMap(product -> {
                    var entity = productEntityRepository
                            .findByRowId(product.getProductId());
                    return entity.map(e -> convertToDta(tvId, product, e));
                }).log();
    }



    private TvProductModel convertToDta(Long tvId, BoutiqaattvProducts product, CatalogProductEntity entity){
        TvProductModel tvProductModel = new TvProductModel();
        tvProductModel.setProductId(product.getProductId());
        tvProductModel.setSku(entity.getSku());
        tvProductModel.setTvId(tvId);
        return tvProductModel;
    }
}
