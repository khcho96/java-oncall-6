package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.Weeks;
import oncall.domain.date.Date;
import oncall.domain.date.Dates;

public class OnCalls {

    private final List<OnCall> onCalls;

    public OnCalls() {
        onCalls = new ArrayList<>();
    }

    public static OnCalls newInstance() {
        return new OnCalls();
    }

    public void assignWorkers(Dates dates, Workers workers) {
        for (Date date : dates.getDates()) {
            if (registerBoth(workers, date)) {
                continue;
            }

            if (registerHolidays(workers, date)) {
                continue;
            }

            registerWeekdays(workers, date);
        }
    }

    private boolean registerBoth(Workers workers, Date date) {
        if (date.isBoth()) {
            Worker worker = workers.next(Weeks.HOLIDAYS, getLastWorker());
            onCalls.add(OnCall.of(date, worker, date.isBoth()));
            return true;
        }
        return false;
    }

    private boolean registerHolidays(Workers workers, Date date) {
        if (date.isHolidays()) {
            Worker worker = workers.next(Weeks.HOLIDAYS, getLastWorker());
            onCalls.add(OnCall.of(date, worker));
            return true;
        }
        return false;
    }

    private void registerWeekdays(Workers workers, Date date) {
        if (date.isWeekdays()) {
            Worker worker = workers.next(Weeks.WEEKDAYS, getLastWorker());
            onCalls.add(OnCall.of(date, worker));
        }
    }

    private Worker getLastWorker() {
        if (!onCalls.isEmpty()) {
            return onCalls.get(onCalls.size() - 1).getWorker();
        }
        return null;
    }

    public List<OnCall> getOnCalls() {
        return onCalls;
    }
}
