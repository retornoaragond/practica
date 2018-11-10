/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.awt.Color;
import productos.logic.ModelLogic;
import productos.presentation.ControllerProductos;
import productos.presentation.ModelProductos;
import productos.presentation.ProductosView;

/**
 *
 * @author ExtremeTech
 */
public class Productos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelLogic domainModel = ModelLogic.instance();
        
        ModelProductos modelproductos = new ModelProductos();
        ProductosView productosview= new ProductosView();
        PRODUCTOS_CONTROLLER = new ControllerProductos(domainModel, productosview, modelproductos);
        productosview.setVisible(true);

    }
    public static ControllerProductos PRODUCTOS_CONTROLLER;
    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK = Color.black;

}
