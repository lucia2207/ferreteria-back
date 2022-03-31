package co.com.sofka.ferreteriaback.controller;

import co.com.sofka.ferreteriaback.model.Inventario;
import co.com.sofka.ferreteriaback.service.impl.InventarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class InventarioController {

    @Autowired
    private InventarioServiceImpl inventarioService;

    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Inventario> nuevoInventario(@RequestBody Inventario inventario) {
        return this.inventarioService.nuevoInventario(inventario);
    }

    @GetMapping(value = "/inventario")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Inventario> getInventario() {
        return this.inventarioService.getInventario();
    }

    @GetMapping(value = "/inventario/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Inventario> getInventarioById(@PathVariable("id") String id) {
        return this.inventarioService.getInventarioById(id);
    }

    @DeleteMapping("/invenatrio/{id}")
    private Mono<ResponseEntity<Inventario>> deleteinventarioById(@PathVariable("id") String id) {
        return this.inventarioService.deleteinventarioById(id)
                .flatMap(inventario -> Mono.just(ResponseEntity.ok(inventario)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/inventario/{id}")
    private Mono<ResponseEntity<Inventario>> actualizarInventarioById(@PathVariable("id") String id, @RequestBody Inventario inventario) {
        return this.inventarioService.actualizarInventarioById(id, inventario)
                .flatMap(inventaio -> Mono.just(ResponseEntity.ok(inventario)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
