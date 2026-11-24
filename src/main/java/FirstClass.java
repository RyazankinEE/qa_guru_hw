public class FirstClass {
    public static void main(String[] args) {

        int a = 7;
        int b = 4;
        double c = 3.5;

        System.out.println(" Арифметические операции ( + , -, * , /) над двумя примитивами типа int");

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        System.out.println("Арифметические операции над int и double в одном выражении");

        System.out.println(a + b + c);
        System.out.println(a - b - c);
        System.out.println(a * b * c);
        System.out.println(a / b / c);

        System.out.println("Арифметические операции сравнения ( < , >, >=, <= )");

        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        System.out.println("Максимальные и минимальные значения");

        System.out.println("Int " + "MAX_VALUE " + Integer.MAX_VALUE);
        System.out.println("Int " + "MIN_VALUE " + Integer.MIN_VALUE);

        System.out.println("Переполнение при арифметической операции");

        int maxInt = Integer.MAX_VALUE + 5;
        System.out.println("OutOfRange " + maxInt);

    }
}
