using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class Articulo : EntityBase 
    {
        private const decimal PorcentajeIVA = 0.21m;

        public Articulo() { }
        public int CodigoBarras { get; set; }
        public string Descripcion { get; set; }

        public decimal Costo { get; set; }
//        public Categoria Categoria { get; set;}
//        public Marca Marca { get; set;}

        public Color Color { get; set; }
        public decimal MargenDeGanancia { get; set; }

        public decimal NetoGravado
        {
            get
            {
                return Costo + Costo * MargenDeGanancia;
            }
        }
        public decimal IVA => NetoGravado * PorcentajeIVA;

        public decimal Precio
        {
            get
            {
                return NetoGravado + IVA;
            }
        }

    }
}
