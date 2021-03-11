/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package objetos;

public class Producto {

    private int idProducto;
    private int codigoProducto;
    private String nombreProducto;
    private String insumoProducto;
    private String sucursalProducto;
    private int existenciaProducto;
    private String marcaProducto;

    public Producto() {
    }

    public Producto(int idProducto, int codigoProducto, String nombreProducto, String insumoProducto, String sucursalProducto, int existenciaProducto, String marcaProducto) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.insumoProducto = insumoProducto;
        this.sucursalProducto = sucursalProducto;
        this.existenciaProducto = existenciaProducto;
        this.marcaProducto = marcaProducto;
    }

    public Producto(int codigoProducto, String nombreProducto, String insumoProducto, String sucursalProducto, String marcaProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.insumoProducto = insumoProducto;
        this.sucursalProducto = sucursalProducto;
        this.marcaProducto = marcaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getInsumoProducto() {
        return insumoProducto;
    }

    public void setInsumoProducto(String insumoProducto) {
        this.insumoProducto = insumoProducto;
    }

    public String getSucursalProducto() {
        return sucursalProducto;
    }

    public void setSucursalProducto(String sucursalProducto) {
        this.sucursalProducto = sucursalProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", insumoProducto=" + insumoProducto + ", sucursalProducto=" + sucursalProducto + ", existenciaProducto=" + existenciaProducto + ", marcaProducto=" + marcaProducto + '}';
    }
}
