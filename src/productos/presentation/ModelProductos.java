/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import productos.logic.Producto;
import productos.logic.Tipo;

/**
 *
 * @author ExtremeTech
 */
public class ModelProductos extends java.util.Observable {

    Producto filter = new Producto();
    ProductoTableModel productos;
    ComboBoxModel<Tipo> combotiposask;
    ComboBoxModel<Tipo> combotiposadd;

    public ModelProductos() {
        this.reset();
    }

    public void setCombo(List<Tipo> Tipo) {
        this.combotiposask = new DefaultComboBoxModel(Tipo.toArray());
        this.combotiposadd = new DefaultComboBoxModel(Tipo.toArray());
        this.commit();
    }

    public void resetCombo(List<Tipo> TA) {
        this.setCombo(TA);
        this.setFilter(new Producto());
    }

    public void reset() {
        filter = new Producto();
        List<Producto> rows = new ArrayList<>();
        this.setProductos(rows);
        this.commit();
    }

    public void setProductos(List<Producto> productos) {
        int[] cols = {
            ProductoTableModel.CODIGO,
            ProductoTableModel.NOMBRE,
            ProductoTableModel.IMPORTADO,
            ProductoTableModel.PRECIO,
            ProductoTableModel.TIPO,
            ProductoTableModel.PORCENTAJE,
            ProductoTableModel.IMPUESTO,
            ProductoTableModel.PRECIO_FINAL};
        this.productos = new ProductoTableModel(cols, productos);
    }

    public Producto getFilter() {
        return filter;
    }

    public void setFilter(Producto filter) {
        this.filter = filter;
    }

    public ProductoTableModel getPersonas() {
        return productos;
    }

    public ProductoTableModel getProductos() {
        return productos;
    }

    public ComboBoxModel<Tipo> getCombotiposask() {
        return combotiposask;
    }

    public void setCombotiposask(ComboBoxModel<Tipo> combotiposask) {
        this.combotiposask = combotiposask;
    }

    public ComboBoxModel<Tipo> getCombotiposadd() {
        return combotiposadd;
    }

    public void setCombotiposadd(ComboBoxModel<Tipo> combotiposadd) {
        this.combotiposadd = combotiposadd;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit() {
        setChanged();
        notifyObservers();
    }
}
