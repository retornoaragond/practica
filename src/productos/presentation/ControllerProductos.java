package productos.presentation;

import java.util.ArrayList;
import java.util.List;
import productos.logic.ModelLogic;
import productos.logic.Producto;
import productos.logic.Tipo;

/**
 *
 * @author ExtremeTech
 */
public class ControllerProductos {

    ModelLogic domainModel;
    ProductosView view;
    ModelProductos model;

    public ControllerProductos(ModelLogic domainModel, ProductosView view, ModelProductos model) {
        initCobosB(domainModel, model);
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);

    }

    public void initCobosB(ModelLogic domainModel, ModelProductos model) {
        try {
            List<Tipo> tipos = domainModel.getAllTipos();
            tipos.add(0, new Tipo());
            model.resetCombo(tipos);
        } catch (Exception ex) {

        }
    }

    public void buscar(Producto filter) throws Exception {
        model.setFilter(filter);
        this.refrescarBusqueda();
    }
    
    public void agregar(Producto nuevo) throws Exception {
        domainModel.agregarProducto(nuevo);
        this.refrescarBusqueda();
    }

    public void refrescarBusqueda() throws Exception {
        List<Producto> rows;
        Tipo aux = new Tipo();
        if (!model.getFilter().getTipo().getIdTipo().equals(aux.getIdTipo())) {
            rows = domainModel.searchProductosbyTipo(model.getFilter());
        } else if (!"".equals(model.getFilter().getNombre())) {
            rows = domainModel.searchProductosbyNombre(model.getFilter());
        } else {
            rows = domainModel.getAllProductos();
        }
        model.setProductos(rows);
        model.commit();
        if (rows.isEmpty()) {
            throw new Exception("Ningún dato coincide");
        }
    }

    public void reset() {
        model.reset();
    }

    public void show() {
        view.setVisible(true);
    }

}
