package cams.tv.tvmanagement.services.impl;

import cams.tv.tvmanagement.entity.BoutiqaattvProducts;
import cams.tv.tvmanagement.model.TvProductModel;
import cams.tv.tvmanagement.model.TvProductsRequest;
import cams.tv.tvmanagement.repository.BoutiqaatTvProductRepository;
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
    private BoutiqaatTvProductRepository tvProductsTemplate;

    @Autowired
    private CatalogProductEntityRepository productEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Flux<TvProductModel> getTvProducts(Long tvId) {
        return tvProductsTemplate.findByTvId(tvId)
                .map(product -> convertToDta(tvId, product));
    }



    private TvProductModel convertToDta(Long tvId, BoutiqaattvProducts product){
        TvProductModel tvProductModel = new TvProductModel();
        tvProductModel.setProductId(product.getCatalogProductEntity().getRowId());
        tvProductModel.setSku(product.getCatalogProductEntity().getSku());
        tvProductModel.setTvId(tvId);
        return tvProductModel;
    }
}
