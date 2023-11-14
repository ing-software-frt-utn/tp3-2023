using Domain.Entities;
using Domain.Interfaces;
using Moq;
using Services.Interfaces;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace SpecFlowasd.StepDefinitions
{
    [Binding]
    public class AsociarClienteStepDefinitions
    {
        private Venta venta;
        private Cliente cliente;
        private ICollection<Cliente> clientes = new List<Cliente>();
        private Mock<IGenericRepository<Venta>> ventaRepositoryMock;
        private Mock<IGenericRepository<Cliente>> clienteRepositoryMock;
        private Mock<IVentaService> ventaServiceMock;

        [BeforeScenario]
        public void Setup()
        {
            ventaRepositoryMock = new Mock<IGenericRepository<Venta>>();
            clienteRepositoryMock = new Mock<IGenericRepository<Cliente>>();
            ventaServiceMock = new Mock<IVentaService>();
        }

        [Given(@"una venta con IdVenta (.*):")]
        public void GivenUnaVentaConIdVenta(int idVenta, Table table )
        {
            venta = new Venta { Id = idVenta, LineasDeVenta = new List<LineaDeVenta>() };
            foreach (var row in table.Rows)
            {
                int Id = int.Parse(row["LineaDeVenta"]);
                LineaDeVenta lineaDeVenta = new LineaDeVenta { Id = Id };
                venta.LineasDeVenta.Add(lineaDeVenta);
            }
            ventaServiceMock.Setup(service => service.GetVentaById(idVenta)).Returns(venta);
        }



        [Given(@"un cliente registrado con el dni (.*)")]
        public void GivenUnClienteRegistradoConElDNI(int dni)
        {
            cliente = new Cliente { Id = dni};
            clienteRepositoryMock.Setup(clienteRepositoryMock => clienteRepositoryMock.GetAsync(dni)).ReturnsAsync(cliente);
        }


        [When(@"el vendedor asocia el cliente con DNI: (.*) a la venta con idVenta: (.*)")]
        public void WhenElVendedorAsociaElClienteConDNIALaVentaConIdVenta(int dni, int idVenta)
        {
            ventaServiceMock.Setup(service => service.AsociarCliente(dni))
                   .Callback<int>(async (clienteDni) =>
                   {
                       var venta = await ventaRepositoryMock.Object.GetAsync(idVenta);

                       var cliente = await clienteRepositoryMock.Object.GetAsync(clienteDni);

                       venta.Cliente = cliente;

                       await ventaRepositoryMock.Object.UpdateAsync(venta);
                   });
        }

        [Then(@"se muestra la venta (.*) con el cliente (.*) asociado")]
        public void ThenSeMuestraLaVentaConElClienteAsociado(int idVenta, int idCliente, Table table)
        {
            cliente.Id = idCliente;
            venta.Cliente = cliente;

            ventaServiceMock.Setup(service => service.GetVentaById(idVenta))
                .Returns((int id) =>
                {
                    var ventaSimulada = new Venta
                    {
                        Id = idVenta,
                        Cliente = cliente,
                        LineasDeVenta = table.Rows.Select(row =>
                           new LineaDeVenta
                            {
                               Id = int.Parse(row["LineaDeVenta"])
                            }).ToList()
                    };
                    return ventaSimulada;
                });

            var ventaDespuesAsociacion = ventaServiceMock.Object.GetVentaById(idVenta);

            Assert.NotNull(ventaDespuesAsociacion);

            Assert.Equal(idCliente, ventaDespuesAsociacion.Cliente.Id);
            Assert.Equal(idVenta, ventaDespuesAsociacion.Id);

            foreach (var row in table.Rows)
            {
                int lineaDeVentaId = int.Parse(row["LineaDeVenta"]);
                Assert.Equal(lineaDeVentaId, ventaDespuesAsociacion.LineasDeVenta.Single(l => l.Id == lineaDeVentaId).Id);
            }
        }

        [Given(@"los cliente registrados")]
        public void GivenLosClienteRegistradosConElDni(Table table)
        {
            foreach (var row in table.Rows)
            {
                Cliente cliente = new Cliente { Id = int.Parse(row["dni"]) };
                clientes.Add(cliente);
            }
            clienteRepositoryMock.Setup(clienteRepositoryMock => clienteRepositoryMock.GetAllAsync()).ReturnsAsync(clientes);
            var clientesMock = clienteRepositoryMock.Object.GetAllAsync();
            //aqui debería comparar los valores de clientes y clientesMock?

        }


        [When(@"el vendedor intenta asociar el cliente con DNI: (.*) a la venta con idVenta: (.*)")]
        public void WhenElVendedorIntentaAsociarElClienteConDNIALaVentaConIdVenta(int dni, int idVenta)
        {
            //ventaServiceMock.Setup(service => service.AsociarCliente(dni)).
            throw new PendingStepException();
        }

        [Then(@"se muestra mensaje de error que el cliente con DNI (.*) no existe")]
        public void ThenSeMuestraMensajeDeErrorQueElClienteConDNINoExiste(int p0)
        {
            throw new PendingStepException();
        }



    }
}
