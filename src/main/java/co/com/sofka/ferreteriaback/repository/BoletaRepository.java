package co.com.sofka.ferreteriaback.repository;
import co.com.sofka.ferreteriaback.model.BoletaProv;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BoletaRepository extends ReactiveMongoRepository<BoletaProv, String> {

    Mono<BoletaProv> findByIdBoleta(String idVolantes);

}
