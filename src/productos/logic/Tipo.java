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
public class Tipo {
    String idTipo;
    String descripcion;
    int procentajeImpuesto;

    public Tipo(String idTipo, String descripcion, int procentajeImpuesto) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
        this.procentajeImpuesto = procentajeImpuesto;
    }

    public Tipo() {
        this.idTipo = "";
        this.descripcion = "";
        this.procentajeImpuesto = 0;
    }
    
    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getProcentajeImpuesto() {
        return procentajeImpuesto;
    }

    public void setProcentajeImpuesto(int procentajeImpuesto) {
        this.procentajeImpuesto = procentajeImpuesto;
    }
    
    @Override
    public String toString(){
        return descripcion;
    }
}
