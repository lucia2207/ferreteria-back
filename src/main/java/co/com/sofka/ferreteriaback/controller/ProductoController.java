package co.com.sofka.ferreteriaback.controller;
import co.com.sofka.ferreteriaback.model.Producto;
import co.com.sofka.ferreteriaback.service.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    ProductoServiceImpl productoService;

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Producto> agregarProducto(@RequestBody Producto producto) {
        return this.productoService.agregarProducto(producto);
    }

    @GetMapping("/productos")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Producto> getAllProducts() {
        return this.productoService.getProductos();
    }

    @GetMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Producto> getProductById(@PathVariable("id") String id) {
        return this.productoService.getProductosById(id);
    }

    @DeleteMapping("/productos/{id}")
    private Mono<ResponseEntity<Producto>> deleteProductById(@PathVariable("id") String id) {
        return this.productoService.deleteProductoById(id)
                .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/productos/{id}")
    private Mono<ResponseEntity<Producto>> updateProductById(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.productoService.actualizarProductById(id, producto)
                .flatMap(Producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
