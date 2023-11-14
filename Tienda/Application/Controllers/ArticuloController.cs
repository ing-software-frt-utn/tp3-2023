using Domain.Entities;
using Domain.Interfaces;
using Microsoft.AspNetCore.Mvc;
using System.Linq.Expressions;

namespace Application.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ArticuloController : ControllerBase
    {
        private readonly IGenericRepository<Articulo> _articuloRepository;

        public ArticuloController(IGenericRepository<Articulo> articuloRepository)
        {
            _articuloRepository = articuloRepository;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Articulo>>> GetArticulos()
        {
            var articulos = await _articuloRepository.GetAllAsync();
            return Ok(articulos);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Articulo>> GetArticuloById(int id)
        {
            var articulo = await _articuloRepository.GetAsync(id);

            if (articulo == null)
            {
                return NotFound();
            }

            return Ok(articulo);
        }

        [HttpPost]
        public async Task<ActionResult<int>> CreateArticulo([FromBody] Articulo articulo)
        {
            var articuloId = await _articuloRepository.AddAsync(articulo);

            return CreatedAtAction(nameof(GetArticuloById), new { id = articuloId }, articuloId);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateArticulo(int id, [FromBody] Articulo articulo)
        {
            if (id != articulo.Id)
            {
                return BadRequest();
            }

            await _articuloRepository.UpdateAsync(articulo);

            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteArticulo(int id)
        {
            await _articuloRepository.DeleteAsync(id);

            return NoContent();
        }

        [HttpGet("filter")]
        public async Task<ActionResult<IEnumerable<Articulo>>> GetArticulosConFiltro([FromQuery] Expression<Func<Articulo, bool>> predicado)
        {
            var articulos = await _articuloRepository.GetWithFilter(predicado);
            return Ok(articulos);
        }

        [HttpDelete("delete-range")]
        public async Task<IActionResult> DeleteArticulosRango([FromBody] IEnumerable<Articulo> elementos)
        {
            await _articuloRepository.DeleteRange(elementos);

            return NoContent();
        }
    }
}