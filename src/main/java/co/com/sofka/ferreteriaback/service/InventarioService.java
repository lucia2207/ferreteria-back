package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventarioService {
    Mono<Inventario> nuevoInventario(Inventario inventario);
    Flux<Inventario> getInventario();
    Mono<Inventario> getInventarioById(String id);
    Mono<Inventario> deleteinventarioById(String id);
    Mono<Inventario> actualizarInventarioById(String id, Inventario inventario);
}
