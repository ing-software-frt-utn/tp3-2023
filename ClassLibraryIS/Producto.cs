using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibraryIS
{
    public class Producto
    {
        public int? Codigo { get; set; }
        public string? Color { get; set; }
        public string? Talle { get; set; }
        public int? Stock{ get; set; }

        public Producto(int _cod,string _color, string _talle, int _stock)
        {
             Codigo = _cod;
            Color = _color;
            Talle = _talle;
            Stock = _stock;
        }
    }
}
