package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.repository.FacturaRepository;
import co.com.sofka.ferreteriaback.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
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
        return this.facturaRepository.findByIdFactura(id);
    }

    @Override
    public Mono<Factura> deleteFacturaById(String id) {
        return this.facturaRepository.findByIdFactura(id)
                .flatMap(factura -> this.facturaRepository.deleteById(factura.facturaId())
                        .thenReturn(factura));
    }

    @Override
    public Mono<Factura> actualizaFacturaById(String id, Factura factura) {
        return this.facturaRepository.findByIdFactura(id)
                .flatMap(Factura -> {
                    factura.setFacturaId(id);
                    return crearFactura(factura);
                })
                .switchIfEmpty(Mono.empty());
    }
}
