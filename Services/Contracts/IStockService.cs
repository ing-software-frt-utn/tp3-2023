using Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories.Contracts
{
    public interface IStockService
    {
        List<Stock> ObtenerStocks(Articulo articulo);
    }
}
