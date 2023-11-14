using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services.Interfaces
{
    public interface IVentaService
    {
        public List<Venta> GetVentasPorCliente(int id);
        public Venta GetVentaById(int id);
        public Venta CrearVenta();
        public void ProcesarPago();
        public void AsociarCliente(int idCliente);
    }
}
    