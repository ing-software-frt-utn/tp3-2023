using System.Text.RegularExpressions;
using System;
using System.Runtime.InteropServices;

namespace Domain
{
    public class Articulo
    {
        public int codigo { get; set; }
        public string marca { get; set; }
        public string descripcion { get; set; }
        public double precio { get; set; }
        public bool activo { get; set; } = true;
    }
}