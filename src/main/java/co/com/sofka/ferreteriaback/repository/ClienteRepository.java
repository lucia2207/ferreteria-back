package co.com.sofka.ferreteriaback.repository;
import co.com.sofka.ferreteriaback.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Mono<Cliente> findByIdCliente(String id);
}