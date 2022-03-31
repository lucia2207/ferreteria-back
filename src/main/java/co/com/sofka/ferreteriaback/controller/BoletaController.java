package co.com.sofka.ferreteriaback.controller;
import co.com.sofka.ferreteriaback.model.BoletaProv;
import co.com.sofka.ferreteriaback.service.impl.BoletaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class BoletaController {

    @Autowired
    private BoletaServiceImpl boletaService;

    @PostMapping("/boleta")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<BoletaProv> nuevaBoleta(@RequestBody BoletaProv boletaProv) {
        return this.boletaService.nuevaBoleta(boletaProv);
    }

    @GetMapping(value = "/boletas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<BoletaProv> getBoletas() {
        return this.boletaService.getBoletas();
    }

    @GetMapping(value = "/boletas/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<BoletaProv> getBoletaById(@PathVariable("id") String id) {
        return this.boletaService.getBoletaById(id);
    }

    @DeleteMapping("/boletas/{id}")
    private Mono<ResponseEntity<BoletaProv>> deleteBoletaById(@PathVariable("id") String id) {
        return this.boletaService.deleteBoletaById(id)
                .flatMap(boleta -> Mono.just(ResponseEntity.ok(boleta)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/boletas/{id}")
    private Mono<ResponseEntity<BoletaProv>> actualizarBoletaById(@PathVariable("id") String id, @RequestBody BoletaProv boletaProv) {
        return this.boletaService.actualizarBoletaById(id, boletaProv)
                .flatMap(boleta -> Mono.just(ResponseEntity.ok(boleta)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
