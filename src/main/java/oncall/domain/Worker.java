package oncall.domain;

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
}
