using ClassLibraryIS;
using Microsoft.VisualStudio.TestPlatform.CommunicationUtilities;
using NUnit.Framework;
using System;
using TechTalk.SpecFlow;

namespace TP2Gherkin.Test.StepDefinitions
{
    [Binding]
    public class EliminarClienteStepDefinitions
    {
        List<Cliente> clientes = new List<Cliente>();
        private string cuit;

        [Given(@"existen los siguientes clientes:")]
        public void GivenExistenLosSiguientesClientes(Table table)
        {
            Cliente cliente1 = new Cliente("20-11.222.444-0","Juan","Perez","Jujuy 4000","Monotributista");
            Cliente cliente2 = new Cliente("27-11.222.333-1", "Maria", "del Valle", "Calle 10", "Responsable I");

            clientes.Add(cliente1);
            clientes.Add(cliente2);
        }

        [When(@"se introduce el CUIT ""([^""]*)"" para su eliminacion")]
        public void WhenSeIntroduceElCUITParaSuEliminacion(string p0)
        {
            cuit = p0;
        }

        [Then(@"el sistema muestra el siguiente mensaje: ""([^""]*)""")]
        public void ThenElSistemaMuestraElSiguienteMensaje(string p0)
        {
            var mensaje = "";
            var clienteBuscado = clientes.Where(p => p.CUIT == cuit).First();
            clientes.Remove(clienteBuscado);
            var result = clientes.Select(p => p.CUIT == cuit).First();
            if (!result)
            {
                mensaje = "Cliente eliminado con exito";
            }
            Assert.AreEqual(mensaje, p0);
        }

    }
}
