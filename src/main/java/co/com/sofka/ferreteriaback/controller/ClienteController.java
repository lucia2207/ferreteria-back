package co.com.sofka.ferreteriaback.controller;
import co.com.sofka.ferreteriaback.model.Cliente;
import co.com.sofka.ferreteriaback.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> AgregarCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.AgregarCliente(cliente);
    }

    @GetMapping("/clientes")
    private Flux<Cliente> TraerClientes() {
        return this.clienteServiceImpl.TraerClientes();
    }

    @GetMapping(value="/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Cliente> ClienteById(@PathVariable("id") String id) {
        return this.clienteServiceImpl.ClienteById(id);
    }

    @DeleteMapping("/clientes/{id}")
    private Mono<ResponseEntity<Cliente>> deleteClienteById(@PathVariable("id") String id) {
        return this.clienteServiceImpl.deleteClienteById(id)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/clientes/{id}")
    private Mono<ResponseEntity<Cliente>> actualizarClientById(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return this.clienteServiceImpl.actualizarClientById(id, cliente)
                .flatMap(clientes -> Mono.just(ResponseEntity.ok(clientes)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
