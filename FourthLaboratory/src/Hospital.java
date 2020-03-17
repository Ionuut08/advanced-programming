import java.util.Objects;

public class Hospital implements Comparable<Hospital> {

    private String name;
    private int order;

    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return getOrder() == hospital.getOrder() &&
                getName().equals(hospital.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrder());
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\n' +
                "}\n";
    }

    @Override
    public int compareTo(Hospital o) {
        return name.compareTo(o.getName());
    }
}
