using System;

namespace PS_Calculator.Services
{
    public class CalculatorService
    {
        public int AddNumber(int number1, int number2)
        {
            return number1 + number2;
        }

        public int AddNumber(int number)
        {
            return number + number;
        }

        public int SubstractNumber(int number1, int number2)
        {
            return number1 - number2;
        }

        public int MultiplyNumber(int number1, int number2)
        {
            return number1 * number2;
        }

        public double DivideNumber(int number1, int number2)
        {
            return number1 / number2;
        }
    }
}
