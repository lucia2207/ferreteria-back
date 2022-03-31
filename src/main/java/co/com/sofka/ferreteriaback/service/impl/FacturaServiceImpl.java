package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.repository.FacturaRepository;
import co.com.sofka.ferreteriaback.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Mono<Factura> crearFactura(Factura factura) {
        return this.facturaRepository.save(factura);
    }

    @Override
    public Flux<Factura> todasLasFacturas() {
        return this.facturaRepository.findAll();
    }

    @Override
    public Mono<Factura> facturaById(String id) {
        return this.facturaRepository.findByFacturaId(id);
    }

    @Override
    public Mono<Factura> deleteFacturaById(String id) {
        return this.facturaRepository.findByFacturaId(id)
                .flatMap(factura -> this.facturaRepository.deleteById(factura.getFacturaId())
                        .thenReturn(factura));
    }

    @Override
    public Mono<Factura> actualizaFacturaById(String id, Factura factura) {
        return this.facturaRepository.findByFacturaId(id)
                .flatMap(Factura -> {
                    factura.setFacturaId(id);
                    return crearFactura(factura);
                })
                .switchIfEmpty(Mono.empty());
    }
}
