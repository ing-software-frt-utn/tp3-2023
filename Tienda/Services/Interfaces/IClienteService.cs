using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services.Interfaces
{
    public interface IClienteService
    {
        public List<Cliente> GetClientes();
        public Cliente GetClienteById(int id);
        public Cliente CreateCliente();
    }
}
