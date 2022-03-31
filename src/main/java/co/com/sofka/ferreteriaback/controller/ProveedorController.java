package co.com.sofka.ferreteriaback.controller;
import co.com.sofka.ferreteriaback.model.Proveedor;
import co.com.sofka.ferreteriaback.service.impl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class ProveedorController {
    @Autowired
    ProveedorServiceImpl proveedorServiceImpl;

    @PostMapping("/proveedores")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Proveedor> nuevoProveedor(@RequestBody Proveedor proveedor) {
        return this.proveedorServiceImpl.nuevoProveedor(proveedor);
    }

    @GetMapping(value="/proveedores")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Proveedor> getProveedores() {
        return this.proveedorServiceImpl.getProveedores();
    }

    @GetMapping(value="/proveedores/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Proveedor> getProveedoresById(@PathVariable("id") String id) {
        return this.proveedorServiceImpl.getProveedoresById(id);
    }

    @DeleteMapping("/proveedores/{id}")
    private Mono<ResponseEntity<Proveedor>> deleteProveedorById(@PathVariable("id") String id) {
        return this.proveedorServiceImpl.deleteProveedorById(id)
                .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/proveedores/{id}")
    private Mono<ResponseEntity<Proveedor>> actualizarProveedorById(@PathVariable("id") String id, Proveedor proveedor) {
        return this.proveedorServiceImpl.actualizarProveedorById(id, proveedor)
                .flatMap(proveedorUpdate -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
