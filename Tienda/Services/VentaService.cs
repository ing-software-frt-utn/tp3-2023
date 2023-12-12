using Domain.Entities;
using Domain.Interfaces;
using Services.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class VentaService : IVentaService
    {
        private readonly IGenericRepository<Cliente> clienteRepository;
        private readonly IGenericRepository<Venta> ventaRepository;
        private readonly ClienteService clienteService = new ClienteService();

        public VentaService(IGenericRepository<Cliente> clienteRepository, IGenericRepository<Venta> ventaRepository)
        {
            this.clienteRepository = clienteRepository;
            this.ventaRepository = ventaRepository;
        }
        public async void AsociarCliente(int idCliente, int idVenta)
        {
            var cliente = clienteService.GetClienteById(idCliente);
            var venta = await ventaRepository.GetAsync(idVenta);
           
            venta.Cliente = cliente;
        }


        public Venta CreateVenta()
        {
            throw new NotImplementedException();
        }

        public Venta GetVentaById(int id)
        {
            throw new NotImplementedException();
        }

        public List<Venta> GetVentasPorCliente(int id)
        {
            throw new NotImplementedException();
        }

        public void ProcesarPago()
        {
            throw new NotImplementedException();
        }
    }
}
