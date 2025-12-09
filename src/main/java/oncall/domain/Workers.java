package oncall.domain;

import static oncall.constant.ErrorMessage.INVALID_ERROR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Workers {

    private List<String> weekdaysWorkers;
    private List<String> weekendsWorkers;
    private int originSize;

    private Workers() {}

    public static Workers newInstance() {
        return new Workers();
    }

    public void registerWeekdaysWorkers(List<String> weekdaysWorkers) {
        this.weekdaysWorkers = new ArrayList<>(weekdaysWorkers);
        originSize = weekdaysWorkers.size();
    }

    public void registerWeekendsWorkers(List<String> weekendsWorkers) {
        this.weekendsWorkers = new ArrayList<>(weekendsWorkers);
    }

    public void validateMatchWeekdaysAnd(List<String> weekendsWorkers) {
        HashSet<String> weekdaysWorkers = new HashSet<>(this.weekdaysWorkers);
        if (!weekdaysWorkers.equals(new HashSet<>(weekendsWorkers))) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public String getNextWeekdaysWorker(String preWorker) {
        String nextWorker = weekdaysWorkers.get(0);

        if (preWorker != null && preWorker.equals(nextWorker)) {
            nextWorker = weekdaysWorkers.remove(1);
            weekdaysWorkers.add(weekdaysWorkers.get(0));
            weekdaysWorkers.add(nextWorker);
            return nextWorker;
        }

        weekdaysWorkers.remove(0);
        if (weekdaysWorkers.size() < originSize) {
            weekdaysWorkers.add(nextWorker);
        }
        return nextWorker;
    }

    public String getNextHolidaysWorker(String preWorker) {
        String nextWorker = weekendsWorkers.get(0);

        if (preWorker != null && preWorker.equals(nextWorker)) {
            nextWorker = weekendsWorkers.remove(1);
            weekendsWorkers.add(weekendsWorkers.get(0));
            weekendsWorkers.add(nextWorker);
            return nextWorker;
        }

        weekendsWorkers.remove(0);
        if (weekendsWorkers.size() < originSize) {
            weekendsWorkers.add(nextWorker);
        }
        return nextWorker;
    }
}
