package Option;

import java.util.Optional;

public class OptionalInAction {
    public static void main(String[] args) {
        Person person=    new Person();
        System.out.println(person==null);
        System.out.println(getall(person));

    }

    private static String getall(Person person){
      return  Optional.ofNullable(person).flatMap(Person::getCar).
              flatMap(Car::getInsurance).map(insurance ->insurance.getName()).
              orElse("not value");
    }
}
