using Domain.Entities;
using Domain.Interfaces;
using Moq;
using Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpecFlowasd.Unit
{
    public class GenericRepositoryTests
    {
        [Fact]
        public async Task GetAsync_DeberiaDevolverEntidadCorrecta()
        {
            // Arrange
            int id = 1;
            var mockEntity = new Mock<EntityBase>(); 
            var repositoryMock = new Mock<IGenericRepository<EntityBase>>();
            repositoryMock.Setup(repo => repo.GetAsync(id)).ReturnsAsync(mockEntity.Object);

            // Act
            var result = await repositoryMock.Object.GetAsync(id);

            // Assert
            Assert.NotNull(result);
            Assert.Same(mockEntity.Object, result);
        }

        [Fact]
        public async Task AddAsync_DeberiaAgregarEntidadCorrectamente()
        {
            // Arrange
            var mockEntity = new Mock<EntityBase>(); 
            var repositoryMock = new Mock<IGenericRepository<EntityBase>>();
            repositoryMock.Setup(repo => repo.AddAsync(mockEntity.Object)).ReturnsAsync(1);

            // Act
            var result = await repositoryMock.Object.AddAsync(mockEntity.Object);

            // Assert
            Assert.Equal(1, result);
        }

        [Fact]
        public async Task GetAllAsync_DeberiaDevolverColeccionNoNula()
        {
            // Arrange
            var entities = new List<EntityBase> { new Mock<EntityBase>().Object, new Mock<EntityBase>().Object };
            var repositoryMock = new Mock<IGenericRepository<EntityBase>>();
            repositoryMock.Setup(repo => repo.GetAllAsync()).ReturnsAsync(entities);

            // Act
            var result = await repositoryMock.Object.GetAllAsync();

            // Assert
            Assert.NotNull(result);
            Assert.Equal(entities.Count, result.Count);
        }
    }
}
