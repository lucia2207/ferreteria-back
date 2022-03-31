package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Cliente> AgregarCliente(Cliente cliente);
    Flux<Cliente> TraerClientes();
    Mono<Cliente> ClienteById(String id);
    Mono<Cliente> deleteClienteById(String id);
    Mono<Cliente> actualizarClientById(String id, Cliente cliente);
}
