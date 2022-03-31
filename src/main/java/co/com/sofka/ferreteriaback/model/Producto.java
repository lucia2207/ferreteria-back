package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "inventario")
public class Producto {
    @Id
    private String productoId = UUID.randomUUID().toString().substring(0, 10);

    private String nombreProd;

    private Double precioProd;

    public Producto(String producoId, String nombreProd, Double precioProd) {
        this.productoId = producoId;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
    }

    public String productoId() { return productoId; }

    public String nombreProd() { return nombreProd; }

    public Double precioProd() { return precioProd; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(productoId, producto.productoId) && Objects.equals(nombreProd, producto.nombreProd) && Objects.equals(precioProd, producto.precioProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, nombreProd, precioProd);
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public void setPrecioProd(Double precioProd) {
        this.precioProd = precioProd;
    }
}
