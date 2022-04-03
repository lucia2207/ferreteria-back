package co.com.sofka.ferreteriaback.controller;
import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.service.impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaController {
    @Autowired
    FacturaServiceImpl facturaServiceImpl;

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> crearFactura(@RequestBody Factura factura) {
        return this.facturaServiceImpl.crearFactura(factura);
    }

    @GetMapping(value="/facturas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Factura> facturaById() {
        return this.facturaServiceImpl.todasLasFacturas();
    }

    @GetMapping(value="/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Factura> facturaById(@PathVariable("id") String id) {
        return this.facturaServiceImpl.facturaById(id);
    }

    @DeleteMapping("/facturas/{id}")
    private Mono<ResponseEntity<Factura>> deleteFacturaById(@PathVariable("id") String id) {
        return this.facturaServiceImpl.deleteFacturaById(id)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/facturas/{id}")
    private Mono<ResponseEntity<Factura>> actualizaFacturaById(@PathVariable("id") String id, @RequestBody Factura factura) {
        return this.facturaServiceImpl.actualizaFacturaById(id, factura)
                .flatMap(Factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
