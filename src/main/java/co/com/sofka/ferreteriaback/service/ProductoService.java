package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    Mono<Producto> agregarProducto(Producto producto);
    Flux<Producto> getProductos();
    Mono<Producto> getProductosById(String id);
    Mono<Producto> deleteProductoById(String id);
    Mono<Producto> actualizarProductById(String id, Producto producto);
}
