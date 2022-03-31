package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.BoletaProv;
import co.com.sofka.ferreteriaback.repository.BoletaRepository;
import co.com.sofka.ferreteriaback.service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BoletaServiceImpl implements BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Override
    public Mono<BoletaProv> nuevaBoleta(BoletaProv boletaProv) {
        return this.boletaRepository.save(boletaProv);
    }

    @Override
    public Flux<BoletaProv> getBoletas() {
        return this.boletaRepository.findAll();
    }

    @Override
    public Mono<BoletaProv> getBoletaById(String id) {
        return this.boletaRepository.findByIdBoleta(id);
    }

    @Override
    public Mono<BoletaProv> deleteBoletaById(String id) {
        return this.boletaRepository.findByIdBoleta(id)
                .flatMap(volante -> boletaRepository.deleteById(volante.getIdBoleta())
                        .thenReturn(volante));
    }

    @Override
    public Mono<BoletaProv> actualizarBoletaById(String id, BoletaProv boletaProv) {
        return this.boletaRepository.findByIdBoleta(id)
                .flatMap(volante -> {
                    boletaProv.setIdBoleta(id);
                    return nuevaBoleta(boletaProv);
                })
                .switchIfEmpty(Mono.empty());
    }
}
