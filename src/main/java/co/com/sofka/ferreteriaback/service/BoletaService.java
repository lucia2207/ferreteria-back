package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.BoletaProv;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoletaService {
    Mono<BoletaProv> nuevaBoleta(BoletaProv boletaProv);
    Flux<BoletaProv> getBoletas();
    Mono<BoletaProv> getBoletaById(String id);
    Mono<BoletaProv> deleteBoletaById(String id);
    Mono<BoletaProv> actualizarBoletaById(String id, BoletaProv boletaProv);

}
