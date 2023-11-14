using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class Cliente : EntityBase
    {
        public Cliente() { }
        public int Dni { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }

        public int Cuit { get; set; }

        public int RazonSocial { get; set; }
        public string Direccion { get; set; }
    }
}
