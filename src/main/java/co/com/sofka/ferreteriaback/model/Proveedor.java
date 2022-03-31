package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

public class Proveedor {

    @Id
    private String proveedorId = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;

    private String telefono;

    private String docProvId;

    public Proveedor(String proveedorId, String nombre, String telefono, String docProvId) {
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.docProvId = docProvId;
    }

    public String proveedorId() {
        return proveedorId;
    }

    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String docProvId() {
        return docProvId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(proveedorId, proveedor.proveedorId) && Objects.equals(nombre, proveedor.nombre) && Objects.equals(telefono, proveedor.telefono) && Objects.equals(docProvId, proveedor.docProvId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proveedorId, nombre, telefono, docProvId);
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDocProvId(String docProvId) {
        this.docProvId = docProvId;
    }
}
