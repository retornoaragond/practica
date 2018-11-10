
package productos.logic;

import java.util.List;
import productos.data.Dao;

/**
 *
 * @author ExtremeTech
 */
public class ModelLogic {
    
    private final Dao dao;
    
    private static ModelLogic uniqueInstance;

    public static ModelLogic instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ModelLogic();
        }
        return uniqueInstance;
    }

    public ModelLogic() {
        this.dao = new Dao();
    }

    public List<Producto> searchProductosbyTipo(Producto filter) {
        return this.dao.getAllProductosbyTipo2(filter);
    }
    
    public List<Producto> searchProductosbyNombre(Producto filter) {
        return this.dao.getAllProductosbyNombre2(filter);
    }
    
    public List<Tipo> getAllTipos(){
        return dao.getAllTipos();
    }
    
    public List<Producto> getAllProductos(){
        return dao.getAllProductos2();
    }
    
   public void agregarProducto(Producto nuevo) throws Exception{
        dao.agregarProducto(nuevo);
   }
    
}
