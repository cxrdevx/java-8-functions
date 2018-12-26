package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static Predicate<Person> filtroNombre(String nombre){
        return (Person p) ->{
          return p.getName().equals(nombre);
        };
    }

    public static Predicate<Person> mayorEdad(){
        return (Person p) ->{
            return p.getAge() >= 18;
        };
    }

    public static void main(String[] args) {
        List<Person> lista = new ArrayList<>();
        lista.add(new Person("Pepito",15));
        lista.add(new Person("Juan",8));
        lista.add(new Person("Mario",99));
        System.out.println("Mostrar todas las personas");
        lista.forEach(System.out::println);
        System.out.println("Filtrar personas por nombre");
        lista.stream()
                .filter(PredicateTest.filtroNombre("Pepito"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("Solo mayores de edad");
        lista.stream()
                .filter(PredicateTest.mayorEdad())
                .forEach(System.out::println);
        System.out.println("Solo mayores de edad y por nombre");
        lista.stream()
                .filter(PredicateTest.mayorEdad())
                .filter(PredicateTest.filtroNombre("Mario"))
                .forEach(System.out::println);
    }
}
