package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Proveedor;
import co.com.sofka.ferreteriaback.repository.ProveedorRepository;
import co.com.sofka.ferreteriaback.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Mono<Proveedor> nuevoProveedor(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    @Override
    public Flux<Proveedor> getProveedores() {
        return this.proveedorRepository.findAll();
    }

    @Override
    public Mono<Proveedor> getProveedoresById(String id) {
        return this.proveedorRepository.findByProveedorId(id);
    }

    @Override
    public Mono<Proveedor> deleteProveedorById(String id) {
        return this.proveedorRepository.findByProveedorId(id)
                .flatMap(proveedor -> proveedorRepository.deleteById(proveedor.proveedorId())
                        .thenReturn(proveedor));
    }

    @Override
    public Mono<Proveedor> actualizarProveedorById(String id, Proveedor proveedor) {
        return this.proveedorRepository.findByProveedorId(id)
                .flatMap(proveedorUpdate -> {
                    proveedor.setProveedorId(id);
                    return nuevoProveedor(proveedor);
                })
                .switchIfEmpty(Mono.empty());
    }
}
