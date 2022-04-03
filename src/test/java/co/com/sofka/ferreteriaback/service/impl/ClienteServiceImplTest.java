package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ClienteServiceImplTest {


    @Autowired
    ClienteServiceImpl service;

    @Test
    void agregarCliente() {
        Cliente cliente = new Cliente("3","Lucia", "091652998","51566257");
        Mono<Cliente> clienteone = service.AgregarCliente(cliente);
        StepVerifier.create(clienteone).expectNext(cliente).verifyComplete();
    }
;
    @Test
    void traerClientes() {
        Cliente cliente = new Cliente("3", "Lucia", "091652998", "51566257");
        Flux<Cliente> clienteone = service.TraerClientes();
        StepVerifier.create(clienteone).expectNext(cliente).verifyComplete();

    }

    @Test
    void clienteById() {
        Cliente cliente = new Cliente("3","Lucia", "091652998", "51566257");
        Mono<Cliente> clienteone = service.deleteClienteById("3");
        StepVerifier.create(clienteone).expectNext(cliente).verifyComplete();
    }

    @Test
    void deleteClienteById() {

        Cliente cliente = new Cliente("3", "Lucia", "091652998", "51566257");
        Mono<Cliente> clienteone = service.deleteClienteById("3");
        StepVerifier.create(clienteone).expectNext(cliente).verifyComplete();
    }

    @Test
    void actualizarClientById() {
        Cliente cliente = new Cliente("3", "Lucia", "091652998", "51566257");
        Mono<Cliente> cliente1 = service.actualizarClientById("3", cliente);
        StepVerifier.create(cliente1).expectNext(cliente).verifyComplete();
    }
}