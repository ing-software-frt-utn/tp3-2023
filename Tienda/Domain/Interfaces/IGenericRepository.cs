using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces
{
    public interface IGenericRepository<T> 
        where T : EntityBase
    {
        Task<T> GetAsync(int id);
        Task<int> AddAsync(T item);
        Task<ICollection<T>> GetAllAsync();
        Task<int> UpdateAsync(T item);
        Task DeleteAsync(int id);
        Task<ICollection<T>> GetWithFilter(Expression<Func<T, bool>> predicado);
        Task DeleteRange(IEnumerable<T> elements);
    }
    
}
