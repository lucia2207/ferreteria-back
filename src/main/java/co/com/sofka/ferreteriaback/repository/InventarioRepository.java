package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface InventarioRepository extends ReactiveMongoRepository<Inventario, String> {

}
