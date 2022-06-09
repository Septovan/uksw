using NUnit.Framework;
using PS_Calculator.Services;
using System;
using System.Collections.Generic;
using System.Text;

namespace PS_Calculator.UnitTests
{
    [TestFixture]
    public class CalculatorService_DivideNumber
    {
        private CalculatorService CreateOrDefaultCalculatorService()
        {
            return new CalculatorService();
        }

        [Test]
        public void DivideNumber_FullParameter_ThrowsDividedByZeroException()
        {
            var calculatorService = CreateOrDefaultCalculatorService();

            TestDelegate testDelegate = () => calculatorService.DivideNumber(2, 0);

            Assert.Throws<DivideByZeroException>(testDelegate);
        }
    }
}
