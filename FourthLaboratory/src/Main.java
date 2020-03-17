import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // Creating the resident objects

        var residents = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        var hospitals = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);

        /*
         * Creating the lists
         * */

        List<Resident> residentList = new ArrayList<>(Arrays.asList(residents));
        residentList.addAll(Arrays.asList(residents));


        Set<Hospital> hospitalSet = new TreeSet<>(Arrays.asList(hospitals));

        /*
         * Sorting
         * */

        List<Resident> newSortedList = residentList.stream()
                .sorted(Comparator.comparing(Resident::getName))
                .collect(Collectors.toList());

        /*
         * Creating a Map
         * */

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(residents[0], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        resPrefMap.put(residents[1], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        resPrefMap.put(residents[2], Arrays.asList(hospitals[0], hospitals[1]));
        resPrefMap.put(residents[3], Arrays.asList(hospitals[0], hospitals[2]));

        Map<Hospital, List<Resident>> hospitalListMap = new TreeMap<>();

        List<Resident> resPrefList = new ArrayList<>();
        resPrefList.add(residents[3]);
        resPrefList.add(residents[0]);
        resPrefList.add(residents[1]);
        resPrefList.add(residents[2]);
        hospitalListMap.put(hospitals[0], resPrefList);

        List<Resident> resPrefList1 = new ArrayList<>();
        resPrefList1.add(residents[0]);
        resPrefList1.add(residents[2]);
        resPrefList1.add(residents[1]);
        hospitalListMap.put(hospitals[1], resPrefList1);

        List<Resident> resPrefList2 = new ArrayList<>();
        resPrefList2.add(residents[0]);
        resPrefList2.add(residents[1]);
        resPrefList2.add(residents[3]);
        hospitalListMap.put(hospitals[2], resPrefList2);

        System.out.println(hospitalListMap.toString());

        /*
         * Querying (Filtering)
         * */

        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(hospitals[0]))
                .forEach(System.out::println);

        List<Hospital> target = Arrays.asList(hospitals[0], hospitals[2]);;

        List<Resident> result = residentList.stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .collect(Collectors.toList());
    }
}
