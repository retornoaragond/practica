/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.logic;

/**
 *
 * @author ExtremeTech
 */
public class Producto {

    String codigo;
    String nombre;
    boolean importado;
    int precio;
    Tipo tipo;

    public Producto(String codigo, String nombre, boolean importado, int precio, Tipo tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.importado = importado;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Producto() {
        this.codigo = "";
        this.nombre = "";
        this.importado = false;
        this.precio = 0;
        this.tipo = new Tipo();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
