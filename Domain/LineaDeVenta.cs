using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public class LineaDeVenta
    {
        private Stock _stock;
        private int _cantidad;

        public LineaDeVenta(Stock stock, int cantidad)
        {
            _stock = stock;
            if (cantidad > stock.stock)
            {
                throw new ArgumentException("No hay stock suficiente");
            }
            _cantidad = cantidad;
        }

        public double GetPrecio()
        {
            double precioUnitario = _stock.articulo.precio;
            double precio = precioUnitario * _cantidad;
            return precio;
        }

    }
}
