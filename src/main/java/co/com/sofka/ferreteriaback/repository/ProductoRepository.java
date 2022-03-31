package co.com.sofka.ferreteriaback.repository;
import co.com.sofka.ferreteriaback.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
    Mono<Producto> findByIdProducto(String id);
}