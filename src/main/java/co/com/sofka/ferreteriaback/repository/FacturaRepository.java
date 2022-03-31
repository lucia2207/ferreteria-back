package co.com.sofka.ferreteriaback.repository;
import co.com.sofka.ferreteriaback.model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura, String> {
    Mono<Factura> findByIdFactura(String idFactura);
}