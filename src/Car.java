import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {
    private final String model;
    private final int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public boolean hasSpeedBetween(int speedFrom, int speedTo) {
        return speedFrom <= speed && speed <= speedTo;
    }

    @Override
    public String toString() {
        return "CAR [%s %d]".formatted(model, speed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, speed);
    }

    public static List<Car> getCarsWithSpeedBetween(int speedFrom, int speedTo, List<Car> cars) {
        if (speedFrom > speedTo) {
            throw new IllegalArgumentException("Speed range is not correct");
        }

        if (cars == null) {
            throw new IllegalArgumentException("Cars is null");
        }

        return cars
                .stream()
                .filter(car -> car.hasSpeedBetween(speedFrom, speedTo))
                .toList();
    }

    public static double getCarsSpeedAverage(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("Cars is null");
        }

        return cars
                .stream()
                .collect(Collectors.summarizingInt(car -> car.speed))
                .getAverage();
    }
}
