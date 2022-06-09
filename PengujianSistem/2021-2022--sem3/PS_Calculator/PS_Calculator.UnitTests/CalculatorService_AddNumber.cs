using NUnit.Framework;
using PS_Calculator.Services;

namespace PS_Calculator.UnitTests
{
    [TestFixture]
    public class CalculatorService_AddNumber
    {
        private CalculatorService CreateOrDefaultCalculatorService()
        {
            return new CalculatorService();
        }

        [Test]
        public void AddNumber_SingleParameter_ReturnsCorrectAnswer()
        {
            // Arrange
            var calculatorService = CreateOrDefaultCalculatorService();
            var expectedResult = 0;

            // Act
            var actualResult = calculatorService.AddNumber(0);

            // Assert
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestCase(-1)]
        [TestCase(0)]
        [TestCase(1)]
        public void AddNumber_SingleParameter_ReturnsAnswer(int value)
        {
            var calculatorService = CreateOrDefaultCalculatorService();
            var expectedResult = value + value;

            var actualResult = calculatorService.AddNumber(value);

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}