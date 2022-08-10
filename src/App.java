import java.util.List;

public class App {
    /*
        Samochód jest reprezentowany przez klasę Car (pola składowe opisujące model oraz szybkość samochodu).
        Napisz program, w którym z przykładowej listy samochodów wyznaczysz te samochody, które charakteryzuje
        szybkość z ustalonego przez Ciebie przedziału liczbowego. Dla wyznaczonej wcześniej kolekcji samochodów
        oblicz średnią szybkość.
    */

    public static void main(String[] args) {
        var cars = List.of(
                new Car("C1", 120),
                new Car("C2", 170),
                new Car("C3", 140),
                new Car("C4", 220),
                new Car("C5", 240),
                new Car("C6", 130)
        );

        var filteredCars = Car.getCarsWithSpeedBetween(130, 180, cars);
        System.out.println(filteredCars);

        var avgSpeed = Car.getCarsSpeedAverage(filteredCars);
        System.out.println(avgSpeed);

    }

}
