using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public enum CondicionTributaria
    {
        CF,
        RI
    }
    public class Cliente : EntityBase
    {
        public Cliente() { }
        public int Dni { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        
        public string Cuit { get; set; }

        public int RazonSocial { get; set; }
        public string Direccion { get; set; }
        
        public CondicionTributaria CondicionTributaria { get; set; }
    }
}
