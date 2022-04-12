package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "producto")
public class Producto {
    @Id
    private String productoId = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;

    private int cantidad;

    private double precio;

    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(String id, String nombre, double precio) {
        this.productoId = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String id, String nombre, int cantidad, double precio, Proveedor proveedor) {
        this.productoId = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getId() {
        return productoId;
    }

    public void setId(String id) {
        this.productoId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + productoId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", proveedor=" + proveedor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return cantidad == producto.cantidad && Double.compare(producto.precio, precio) == 0 && Objects.equals(productoId, producto.productoId) && Objects.equals(nombre, producto.nombre) && Objects.equals(proveedor, producto.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId);
    }
}
