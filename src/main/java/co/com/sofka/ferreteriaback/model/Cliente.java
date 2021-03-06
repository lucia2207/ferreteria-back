package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String clienteId = UUID.randomUUID().toString().substring(0, 10);

    private String nombreCliente;

    private String telefono;

    private String docId;

    public Cliente(){

    }

    public Cliente(String clienteId, String nombreCliente, String telefono, String docId) {
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.docId = docId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(clienteId, cliente.clienteId) && Objects.equals(nombreCliente, cliente.nombreCliente) && Objects.equals(telefono, cliente.telefono) && Objects.equals(docId, cliente.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, nombreCliente, telefono, docId);
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocId() {
        return docId;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + clienteId + '\'' +
                ", nombre='" + nombreCliente + '\'' +
                ", celular='" + telefono + '\'' +
                ", documentoID='" + docId + '\'' +
                '}';
    }

}
