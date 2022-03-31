package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FacturaService {
    Mono<Factura> crearFactura(Factura factura);
    Flux<Factura> todasLasFacturas();
    Mono<Factura> facturaById(String id);
    Mono<Factura> deleteFacturaById(String id);
    Mono<Factura> actualizaFacturaById(String id, Factura factura);
}
