package co.com.sofka.ferreteriaback.repository;
import co.com.sofka.ferreteriaback.model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {

    Mono<Proveedor> findByProveedorId(String idProveedor);
}