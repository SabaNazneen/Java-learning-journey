package javafunctionals.inbuilt;
import java.util.function.Supplier;
public class SupplierDemo {
    static void main() {
        Supplier<Double> randomSupplier = Math::random;
        Supplier<Double> randomSupplier2 = () ->  Math.random();
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier2.get());
    }
}
