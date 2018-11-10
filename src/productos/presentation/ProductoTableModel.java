package productos.presentation;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import productos.logic.Producto;

/**
 *
 * @author ExtremeTech
 */
public class ProductoTableModel extends AbstractTableModel {

    List<Producto> rows;
    int[] cols;
    double precio_t;
    

    public ProductoTableModel(int[] cols, List<Producto> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[cols[col]];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        switch (cols[col]) {
            case IMPORTADO:
                return Boolean.class;
            default:
                return super.getColumnClass(col);
        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Producto producto = rows.get(row);

        switch (cols[col]) {
            case CODIGO:
                return producto.getCodigo();
            case NOMBRE:
                return producto.getNombre();
            case IMPORTADO:
                return producto.isImportado();
            case PRECIO:
                return producto.getPrecio();
            case TIPO:
                return producto.getTipo();
            case PORCENTAJE:
                return producto.getTipo().getProcentajeImpuesto();

            case IMPUESTO:
                precio_t = producto.getPrecio() * producto.getTipo().getProcentajeImpuesto() / 100.0;
                if (producto.isImportado()) {
                    precio_t += precio_t * 0.5;
                }
                return (int)precio_t;
            case PRECIO_FINAL:
                return producto.getPrecio() + (int)precio_t;
            default:
                return "";
        }
    }

    public Producto getRowAt(int row) {
        return rows.get(row);
    }

    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int IMPORTADO = 2;
    public static final int PRECIO = 3;
    public static final int TIPO = 4;
    public static final int PORCENTAJE = 5;
    public static final int IMPUESTO = 6;
    public static final int PRECIO_FINAL = 7;

    String[] colNames = new String[8];

    private void initColNames() {
        colNames[CODIGO] = "Codigo";
        colNames[NOMBRE] = "Nombre";
        colNames[IMPORTADO] = "Importado";
        colNames[PRECIO] = "Precio";
        colNames[TIPO] = "Tipo";
        colNames[PORCENTAJE] = "Porcentaje";
        colNames[IMPUESTO] = "Impuesto";
        colNames[PRECIO_FINAL] = "Precio Final";
    }
}
