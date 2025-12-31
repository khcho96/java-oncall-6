package oncall.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workers {

    private final Map<Weeks, List<Worker>> workers;

    public Workers() {
        workers = new HashMap<>();
    }
}
