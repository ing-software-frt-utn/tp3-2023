package is.tp3.domain;

import java.util.ArrayList;
import java.util.List;

public class Venta {



    private ArrayList<LineaDeVenta> lineasDeVentas = new ArrayList<LineaDeVenta>();

    public String agregarArticulo(Articulo articulo, Integer cantidad) {

        if (cantidad <= articulo.getStock()){

        LineaDeVenta lineaDeVenta = new LineaDeVenta();

        lineaDeVenta.agregarArticuloALineaDeVenta(cantidad, articulo);

        lineasDeVentas.add(lineaDeVenta);

        return "Se agrego el articulo con exito";
        }else{
            return "No hay suficiente stock";
        }
        /*
        try {
            // Código que podría lanzar una excepción
            LineaDeVenta lineaDeVenta = new LineaDeVenta();

            lineaDeVenta.agregarArticuloALineaDeVenta(cantidad, articulo);

            lineasDeVentas.add(lineaDeVenta);
            System.out.println("Se agrego el articulo en la venta: ");
        } catch (Exception e) {
            throw new Exception("No se encontró el artículo");

        }
*/

    }

    public ArrayList<LineaDeVenta> getLineasDeVentas() {

        return lineasDeVentas;
    }

    public Articulo obtenerArticulo(Integer codigo) {

        for (LineaDeVenta lv : lineasDeVentas) {
            if (lv.articulo.getCodigo() == codigo) {

                return lv.articulo;

            }
            }
        return null;
    }



    public double getTotal() {
        double acumulador = 0.0;

        for (LineaDeVenta lv : lineasDeVentas) {
            acumulador += lv.getSubTotal();
        }
        return acumulador;
    }

    public boolean quitarArticulo(Integer codigo) {

         int index = 0;

        for (LineaDeVenta lv : lineasDeVentas) {

            if(lv.articulo.getCodigo() == codigo){
                lineasDeVentas.remove(index);

                return true;
            }
            index++;
        }

        return false;
    }
}
