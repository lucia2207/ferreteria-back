package co.com.sofka.ferreteriaback.service.impl;

import co.com.sofka.ferreteriaback.model.Cliente;
import co.com.sofka.ferreteriaback.repository.ClienteRepository;
import co.com.sofka.ferreteriaback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Mono<Cliente> AgregarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Flux<Cliente> TraerClientes() {
        return this.clienteRepository.findAll();
    }


    @Override
    public Mono<Cliente> ClienteById(String id) {
        return this.clienteRepository.findByClienteId(id);
    }

    @Override
    public Mono<Cliente> deleteClienteById(String id) {
        return this.clienteRepository.findByClienteId(id)
                .flatMap(cliente -> this.clienteRepository.deleteById(cliente.getClienteId())
                        .thenReturn(cliente));
    }

    @Override
    public Mono<Cliente> actualizarClientById(String id, Cliente cliente) {
        return this.clienteRepository.findByClienteId(id)
                .flatMap(clienteact -> {
                    cliente.setClienteId(id);
                    return AgregarCliente(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }


}
