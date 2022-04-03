package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Inventario;
import co.com.sofka.ferreteriaback.repository.InventarioRepository;
import co.com.sofka.ferreteriaback.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Mono<Inventario> nuevoInventario(Inventario inventario) {
        return this.inventarioRepository.save(inventario);
    }

    @Override
    public Flux<Inventario> getInventario() {
        return this.inventarioRepository.findAll();
    }


    @Override
    public Mono<Inventario> getInventarioById(String id) {
        return this.inventarioRepository.findById(id);
    }


    @Override
    public Mono<Inventario> deleteinventarioById(String id) {
        return this.inventarioRepository.findById(id)
                .flatMap(inventario -> this.inventarioRepository.deleteById(inventario.getId())
                        .thenReturn(inventario));
    }


    @Override
    public Mono<Inventario> actualizarInventarioById(String id, Inventario inventario) {
        return this.inventarioRepository.findById(id)
                .flatMap(inventarioact -> {
                    inventario.setId(id);
                    return nuevoInventario(inventario);
                })
                .switchIfEmpty(Mono.empty());
    }
}
