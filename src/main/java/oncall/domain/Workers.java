package oncall.domain;

import java.util.List;

public class Workers {

    private List<String> weekdaysWorkers;
    private List<String> weekendsWorkers;

    private Workers() {}

    public static Workers newInstance() {
        return new Workers();
    }

    public void registerWeekdaysWorkers(List<String> weekdaysWorkers) {
        this.weekdaysWorkers = weekdaysWorkers;
    }

    public void registerWeekendsWorkers(List<String> weekendsWorkers) {
        this.weekendsWorkers = weekendsWorkers;
    }
}
