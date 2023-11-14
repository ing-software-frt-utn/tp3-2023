using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public class Venta
    {
        private List<LineaDeVenta> _lineasDeVenta = new List<LineaDeVenta>();
        public void AgregarArticulo(Stock stock, int cantidad)
        {
            LineaDeVenta lineaDeVenta = new LineaDeVenta(stock, cantidad);
            _lineasDeVenta.Add(lineaDeVenta);
        }

        public double GetTotal()
        {
            double total = 0;
            foreach (LineaDeVenta lv in  _lineasDeVenta)
            {
                total += lv.GetPrecio();
            }
            return _lineasDeVenta.Sum(lv => lv.GetPrecio());
        }
    }
}
