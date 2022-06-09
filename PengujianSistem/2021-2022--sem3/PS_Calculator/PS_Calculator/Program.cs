using PS_Calculator.Services;
using System;

namespace PS_Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            var calculatorService = new CalculatorService();
            var number1 = 10;
            var number2 = 5;

            var result = calculatorService.MultiplyNumber(number1, number2);

            Console.WriteLine($"Result: {result}");
        }
    }
}
