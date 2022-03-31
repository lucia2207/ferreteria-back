package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Producto;
import co.com.sofka.ferreteriaback.repository.ProductoRepository;
import co.com.sofka.ferreteriaback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Mono<Producto> agregarProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public Flux<Producto> getProductos() {
        return this.productoRepository.findAll();
    }

    @Override
    public Mono<Producto> getProductosById(String id) {
        return this.productoRepository.findByProductoId(id);
    }

    @Override
    public Mono<Producto> deleteProductoById(String id) {
        return this.productoRepository.findByProductoId(id)
                .flatMap(producto -> productoRepository.deleteById(producto.getProductoId())
                        .thenReturn(producto));
    }

    @Override
    public Mono<Producto> actualizarProductoById(String id, Producto producto) {
        return this.productoRepository.findByProductoId(id)
                .flatMap(productoo -> {
                    producto.setProductoId(id);
                    return agregarProducto(producto);
                })
                .switchIfEmpty(Mono.empty());
    }
}
