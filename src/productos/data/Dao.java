/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import productos.logic.Producto;
import productos.logic.Tipo;

/**
 *
 * @author ExtremeTech
 */
public class Dao {

    RelDatabase dbb;

    public Dao() {
        dbb = new RelDatabase();
    }

    public List<Tipo> getAllTipos() {
        List<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "select * from tipo";
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                tipos.add(tipo(rs));
            }
        } catch (SQLException ex) {

        }
        return tipos;
    }

    public Tipo getTipo(String id) throws Exception {
        String sql = "SELECT * FROM tipo WHERE idTipo = '%s'";
        sql = String.format(sql, id);
        ResultSet rs = dbb.executeQuery(sql);
        if (rs.next()) {
            return tipo(rs);
        } else {
            throw new Exception("Funcionario no Existe");
        }
    }

    public Tipo tipo(ResultSet rs) {
        try {
            Tipo t = new Tipo();
            t.setIdTipo(rs.getString("idTipo"));
            t.setDescripcion(rs.getString("descripcion"));
            t.setProcentajeImpuesto(rs.getInt("porcentajeImpuesto"));
            return t;
        } catch (SQLException ex) {
            return null;
        }
    }

    //  <editor-fold desc="Manera 1" defaultstate="collapsed">
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto";
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto(rs));
            }
        } catch (SQLException ex) {

        }
        return productos;
    }

    public List<Producto> getAllProductosbyNombre(Producto p) {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto where nombre like '%%%s%%'";
            sql = String.format(sql, p.getNombre());
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto(rs));
            }
        } catch (SQLException ex) {

        }
        return productos;
    }

    public List<Producto> getAllProductosbyTipo(Producto p) {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto where tipo = '%s'";
            sql = String.format(sql, p.getTipo().getIdTipo());
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto(rs));
            }
        } catch (SQLException ex) {

        }
        return productos;
    }

    public Producto producto(ResultSet rs) {
        try {
            Producto p = new Producto();
            p.setCodigo(rs.getString("codigo"));
            p.setImportado(rs.getBoolean("importado"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            p.setTipo(this.getTipo(rs.getString("tipo")));
            return p;
        } catch (SQLException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
    //</editor-fold>

    //  <editor-fold desc="manera 2" defaultstate="collapsed">
    public List<Producto> getAllProductos2() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto "
                    + "inner join tipo "
                    + "on producto.tipo = tipo.idTipo";
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto2(rs));
            }
        } catch (SQLException ex) {
        }
        return productos;
    }

    public List<Producto> getAllProductosbyNombre2(Producto p) {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto "
                    + "inner join tipo "
                    + "on producto.tipo = tipo.idTipo "
                    + "where producto.nombre like '%%%s%%'";
            sql = String.format(sql, p.getNombre());
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto2(rs));
            }
        } catch (SQLException ex) {
        }
        return productos;
    }

    public List<Producto> getAllProductosbyTipo2(Producto p) {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto "
                    + "inner join tipo "
                    + "on producto.tipo = tipo.idTipo "
                    + "where tipo.idTipo = '%s'";
            sql = String.format(sql, p.getTipo().getIdTipo());
            ResultSet rs = dbb.executeQuery(sql);
            while (rs.next()) {
                productos.add(producto2(rs));
            }
        } catch (SQLException ex) {
        }
        return productos;
    }

    public Producto producto2(ResultSet rs) {
        try {
            Producto p = new Producto();
            Tipo t = new Tipo();
            p.setCodigo(rs.getString("codigo"));
            p.setImportado(rs.getBoolean("importado"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            t.setIdTipo(rs.getString("idTipo"));
            t.setDescripcion(rs.getString("descripcion"));
            t.setProcentajeImpuesto(rs.getInt("porcentajeImpuesto"));
            p.setTipo(t);
            return p;
        } catch (SQLException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
    //</editor-fold>

    public void agregarProducto(Producto n) throws Exception {
        String sql = "INSERT INTO producto (codigo, nombre, importado, precio, tipo) "
                + "VALUES ('%s', '%s', '%d', '%d', '%s');";
        if (n.isImportado()) {
            sql = String.format(sql, n.getCodigo(), n.getNombre(), 1, n.getPrecio(), n.getTipo().getIdTipo());
        } else {
            sql = String.format(sql, n.getCodigo(), n.getNombre(), 0, n.getPrecio(), n.getTipo().getIdTipo());
        }
        int count = dbb.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Producto ya existe.");
        }
    }
}
