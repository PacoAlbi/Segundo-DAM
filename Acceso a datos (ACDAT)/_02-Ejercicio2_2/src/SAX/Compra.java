package SAX;

public class Compra {
    private String fecha;
    private double precio;
    private double unidades = 1;
    private int cantidadProductos;
    private double totalDescuentos;

    public Compra(String fecha, double precio, double unidades, int cantidadProductos, double totalDescuentos) {
        this.fecha = fecha;
        this.precio = precio;
        this.unidades = unidades;
        this.cantidadProductos = cantidadProductos;
        this.totalDescuentos = totalDescuentos;
    }

    public Compra (){};

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getUnidades() {
        return unidades;
    }

    public void setUnidades(double unidades) {
        this.unidades = unidades;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(double totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }
}
