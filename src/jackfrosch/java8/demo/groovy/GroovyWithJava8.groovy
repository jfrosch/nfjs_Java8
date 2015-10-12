// tested with Groovy 2.4.5
package jackfrosch.java8.demo.groovy

import java.util.function.Predicate
import java.util.stream.Collectors

public List<Integer> pickSome(List<Integer> values,
                              Predicate<Integer> pickingStrategy) {
    values.stream()
          .filter(pickingStrategy)
          .collect(Collectors.toList())
}

List<Integer> values = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

List<Integer> evens = pickSome(values, {value -> value % 2 == 0})
println evens

List<Integer> odds = pickSome(values) { value -> value % 2 != 0 }
println odds

def threes = values.findAll { value -> value % 3 == 0 }
println threes