package Option;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return this.car;
    }
}
