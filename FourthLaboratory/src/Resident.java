import java.util.Objects;

public class Resident {

    private String name;
    private int position;

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resident)) return false;
        Resident resident = (Resident) o;
        return getPosition() == resident.getPosition() &&
                getName().equals(resident.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\n' +
                "}";
    }
}
