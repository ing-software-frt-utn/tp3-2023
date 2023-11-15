package is.tp3.domain;

import java.util.ArrayList;
import java.util.List;

public class Venta {



    private ArrayList<LineaDeVenta> lineasDeVentas = new ArrayList<LineaDeVenta>();

    public void agregarArticulo(Articulo articulo, Integer cantidad) {

        LineaDeVenta lineaDeVenta = new LineaDeVenta();

        lineaDeVenta.agregarArticuloALineaDeVenta(cantidad, articulo);

        lineasDeVentas.add(lineaDeVenta);

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
