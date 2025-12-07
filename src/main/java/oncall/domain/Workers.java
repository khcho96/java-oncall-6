package oncall.domain;

import static oncall.constant.ErrorMessage.INVALID_ERROR;

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

    public void validateMatchWeekdaysAnd(List<String> weekendsWorkers) {
        if (!weekdaysWorkers.containsAll(weekendsWorkers) || !weekendsWorkers.containsAll(weekdaysWorkers)) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }
}
