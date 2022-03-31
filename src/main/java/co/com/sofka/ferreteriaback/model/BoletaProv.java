package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BoletaProv {

    @Id
    private String idBoleta = UUID.randomUUID().toString().substring(0, 10);

    private String nombreProv;

    private Date Fecha;

    private List<Producto> listaProductos;

    private String docIdProv;

    public BoletaProv(String idBoleta, String nombreProv, Date fecha, List<Producto> listaProductos, String docIdProv) {
        this.idBoleta = idBoleta;
        this.nombreProv = nombreProv;
        Fecha = fecha;
        this.listaProductos = listaProductos;
        this.docIdProv = docIdProv;
    }

    public String idBoleta() {  return idBoleta; }

    public String nombreProv() { return nombreProv; }

    public Date fecha() { return Fecha; }

    public List<Producto> listaProductos() { return listaProductos; }

    public String docIdProv() {  return docIdProv; }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setDocIdProv(String docIdProv) {
        this.docIdProv = docIdProv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoletaProv that = (BoletaProv) o;
        return Objects.equals(idBoleta, that.idBoleta) && Objects.equals(nombreProv, that.nombreProv) && Objects.equals(Fecha, that.Fecha) && Objects.equals(listaProductos, that.listaProductos) && Objects.equals(docIdProv, that.docIdProv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBoleta, nombreProv, Fecha, listaProductos, docIdProv);
    }
}
