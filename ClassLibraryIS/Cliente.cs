using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibraryIS
{
    public class Cliente
    {
        public string CUIT { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Domicilio { get; set; }
        public string RazonSocial { get; set; }

        public Cliente(string _cuit, string _nombre, string _apellido, string _domicilio , string _razons)
        {
            CUIT = _cuit;
            Nombre = _nombre;
            Apellido = _apellido;   
            Domicilio = _domicilio;
            RazonSocial = _razons;
        }
    }
}
