package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Proveedor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProveedorService {
    Mono<Proveedor> nuevoProveedor(Proveedor proveedor);
    Flux<Proveedor> getProveedores();
    Mono<Proveedor> getProveedoresById(String id);
    Mono<Proveedor> deleteProveedorById(String id);
    Mono<Proveedor> actualizarProveedorById(String id, Proveedor proveedor);

}
