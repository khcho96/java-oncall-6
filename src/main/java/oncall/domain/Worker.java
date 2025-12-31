package oncall.domain;

import java.util.Objects;
import oncall.constant.ErrorMessage;

public class Worker {

    private final String name;

    private Worker(String name) {
        this.name = name;
    }

    public static Worker from(String name) {
        validateNameLength(name);

        return new Worker(name);
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Worker worker = (Worker) object;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
