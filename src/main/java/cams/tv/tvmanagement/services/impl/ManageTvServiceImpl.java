package cams.tv.tvmanagement.services.impl;

import cams.tv.tvmanagement.entity.Boutiqaattv;
import cams.tv.tvmanagement.model.TvListRequest;
import cams.tv.tvmanagement.model.TvModel;
import cams.tv.tvmanagement.repository.BoutiqaatTvRepository;
import cams.tv.tvmanagement.repository.BoutiqaatTvRepositoryImpl;
import cams.tv.tvmanagement.services.ManageTvService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
//import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class ManageTvServiceImpl implements ManageTvService {

    @Autowired
    private BoutiqaatTvRepository boutiqaatTvRepository;

    @Autowired
    private BoutiqaatTvRepositoryImpl boutiqaatTvTemplate;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Flux<TvModel> getTvList(TvListRequest request, Pageable pages) {
        return boutiqaatTvTemplate.findAllBy(request, pages)
                .map(this::convertToDto);
    }

    @Override
    public Mono<TvModel> addTv(TvModel request) {

        log.info("Started adding a new TV to the system");
        if (request.getId() != null) {
            log.error("ID must be null");
            return Mono.error(new RuntimeException("ID must be null"));
        }

        Boutiqaattv boutiqaattv = convertToEntity(request);

        if (boutiqaattv != null) {
            Flux<Boutiqaattv> boutiqaatTvFlux = boutiqaatTvTemplate.findAllByEnNameOrArabicName(request.getEnName(), request.getArabicName());
            Boolean exist = null;
            try {
                exist = boutiqaatTvFlux.hasElements().toFuture().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (Boolean.TRUE.equals(exist)) {

                log.error("TV Name must be unique");
                return Mono.error(new RuntimeException("TV Name must be unique"));
            } else {
                    return save(boutiqaattv);
            }
        }else {
            return Mono.empty();
        }

    }

    @NotNull
    private Mono<TvModel> save(Boutiqaattv boutiqaattv) {
        boutiqaattv.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Mono<Boutiqaattv> boutiqaatTvMono = boutiqaatTvRepository.save(boutiqaattv);
        log.info("Entity saved successfully");
        return boutiqaatTvMono.map(this::convertToDto);
    }

    private TvModel convertToDto(Boutiqaattv tv) {
        return modelMapper.map(tv, TvModel.class);
    }

    private Boutiqaattv convertToEntity(TvModel tv) {
        return modelMapper.map(tv, Boutiqaattv.class);
    }
}
