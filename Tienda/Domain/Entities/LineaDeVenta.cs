using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class LineaDeVenta : EntityBase
    {
        public LineaDeVenta() { }
        public int IdVenta { get; }
        public Articulo Articulo { get; set; }
        //public int Talle 
        public int CantidadArticulo { get; set; }
        

    }
}
