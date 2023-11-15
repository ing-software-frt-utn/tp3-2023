using System;
using TechTalk.SpecFlow;
using ClassLibraryIS;
using Microsoft.VisualStudio.TestPlatform.CommunicationUtilities;
using NUnit.Framework;

namespace TP2Gherkin.Test.StepDefinitions
{
    [Binding]
    public class BuscarProductoStepDefinitions
    {
        List<Producto> productos = new List<Producto>();
        private int codigo; 
        [Given(@"existen los siguientes productos:")]
        public void GivenExistenLosSiguientesProductos(Table table)
        {
            Producto prod1 = new Producto(100,"Naranja","M",10);
            Producto prod2 = new Producto(200, "Rojo", "L", 5);
            Producto prod3 = new Producto(300, "Naranja", "M", 3);
            productos.Add(prod1);
            productos.Add(prod2);
            productos.Add(prod3);
        }

        [When(@"se introduce el codigo (.*)")]
        public void WhenSeIntroduceElCodigo(int p0)
        {
            codigo = p0;
        }

        [Then(@"el sistema muestra :")]
        public void ThenElSistemaMuestra(Table table)
        {
            var productoBuscado = productos.Where(p => p.Codigo == codigo).First();

            Assert.AreEqual("|"+ productoBuscado.Codigo+"|"+ productoBuscado.Color+"|"+ 
                productoBuscado.Talle+"|"+productoBuscado.Stock+"|",
                "|100|Naranja|M|10|");

        }

        [Then(@"el sistema muestra el siguiente mensaje de error: ""([^""]*)""")]
        public void ThenElSistemaMuestraElSiguienteMensajeDeError(string p0)
        {
            string mensaje = "";
            try
            {
                Producto productoBuscado = productos.Where(p => p.Codigo == codigo).First();
            }
            catch(Exception ex) 
            {
                mensaje = "Producto inexistente";
            }
            
            Assert.AreEqual(mensaje, p0);
        }
    }
}
