using Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services.Contracts
{
    public interface IArticuloService
    {
        public Articulo BuscarArticulo(int codigo);
        public bool BorrarArticulo(Articulo articulo);
    }
}
