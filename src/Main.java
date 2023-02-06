import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Car> collection = new ArrayList<>();
        collection.add(new Car(150, "white", "VW"));
        collection.add(new Car(100, "yellow", "Kia"));
        collection.add(new Car(120, "red", "mersedes"));
        collection.add(new Car(180, "black", "BMW"));
        collection.add(new Car(200, "green", "Jeep"));
        collection.add(new Car(90, "blue", "Lada"));


        BiConsumer<Optional<Car>, Optional<Car>> minMaxConsumer = new BiConsumer<Optional<Car>, Optional<Car>>() {
            @Override
            public void accept(Optional<Car> o, Optional<Car> o2) {
                if (o.isEmpty() || o2.isEmpty()) {
                    System.out.println("Элементы отсутствуют");
                } else {
                    System.out.println("Максимальное значение: " + o.get() + "\nМинимальное значение: " + o2.get());
                }
            }
        };
        findMinMax(collection, new MaxMinComparator(), minMaxConsumer);

        evenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static void findMinMax(List<Car> list, Comparator<Object> comparator, BiConsumer<Optional<Car>, Optional<Car>> minMaxConsumer) {

        Optional<Car> min = list.stream().min(comparator);
        Optional<Car> max = list.stream().max(comparator);
        minMaxConsumer.accept(max, min);
    }


    public static void evenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}