package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Inventario {
    @Id
    private String inventario = UUID.randomUUID().toString().substring(0, 10);

    private List<Producto> listaProductos;

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Inventario(String inventario, List<Producto> listaProductos) {
        this.inventario = inventario;
        this.listaProductos = listaProductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(inventario, that.inventario) && Objects.equals(listaProductos, that.listaProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventario, listaProductos);
    }
}
