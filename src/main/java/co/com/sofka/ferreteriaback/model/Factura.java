package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "factura")
public class Factura {

    @Id
    private String facturaId = UUID.randomUUID().toString().substring(0, 10);

    private Date fechaFactura;

    private String vendedor;

    private String nombreClienteF;

    private Double precioTotal;

    private String numFactura;

    private List<Producto> listaProductos;


    public Factura(String facturaId, Date fechaFactura, String vendedor, String nombreClienteF, Double precioTotal, String numFactura, List<Producto> listaProductos) {
        this.facturaId = facturaId;
        this.fechaFactura = fechaFactura;
        this.vendedor = vendedor;
        this.nombreClienteF = nombreClienteF;
        this.precioTotal = precioTotal;
        this.numFactura = numFactura;
        this.listaProductos = listaProductos;
    }

    public String facturaId() {  return facturaId; }

    public Date fechaFactura() { return fechaFactura; }

    public String vendedor() { return vendedor; }

    public String nombreClienteF() { return nombreClienteF; }

    public Double precioTotal() { return precioTotal; }

    public String numFactura() { return numFactura; }

    public List<Producto> listaProductos() { return listaProductos; }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setNombreClienteF(String nombreClienteF) {
        this.nombreClienteF = nombreClienteF;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
