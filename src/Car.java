import java.util.Objects;

public class Car {
    final private int enginePower;
    final private String color;
    final private String model;

    public Car(int enginePower, String color, String model) {
        this.enginePower = enginePower;
        this.color = color;
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return enginePower == car.enginePower && Objects.equals(color, car.color) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enginePower, color, model);
    }
}
