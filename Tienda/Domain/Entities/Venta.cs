using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class Venta : EntityBase
    {
        public Venta() { }  
        public DateTime fecha { get; set; }
        public List<LineaDeVenta> LineasDeVenta { get; set; }
        public double total { get; set; }
        public Cliente Cliente { get; set; }    

    }
}
