import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Problem {




    Collection<String> hospitals = Arrays.asList("h0", "h1", "h2", "h3");
    Collection<String> residents = Arrays.asList("r0", "r1", "r2", "r3");
    Stream<String> streamOfHospitals = hospitals.stream();
    Stream<String> streamOfResidents = residents.stream();
}
