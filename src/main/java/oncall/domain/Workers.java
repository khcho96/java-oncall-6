package oncall.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import oncall.constant.ErrorMessage;
import oncall.constant.Weeks;

public class Workers {

    private final Map<Weeks, Deque<Worker>> workers;
    private final Map<Weeks, Deque<Worker>> workersWaiting;

    private Workers() {
        workers = new HashMap<>();
        workers.put(Weeks.WEEKDAYS, new ArrayDeque<>());
        workers.put(Weeks.HOLIDAYS, new ArrayDeque<>());

        workersWaiting = new HashMap<>();
        workersWaiting.put(Weeks.WEEKDAYS, new ArrayDeque<>());
        workersWaiting.put(Weeks.HOLIDAYS, new ArrayDeque<>());
    }

    public static Workers newInstance() {
        return new Workers();
    }

    public void addWeekdaysWorkers(Weeks weeks, List<String> workerNames) {
        addWorkers(weeks, workerNames);
    }

    public void addHolidaysWorkers(Weeks weeks, List<String> workerNames) {
        addWorkers(weeks, workerNames);
        validateWorkersDifference();
    }

    private void validateWorkersDifference() {
        if (!new HashSet<>(workers.get(Weeks.WEEKDAYS)).equals(new HashSet<>(workers.get(Weeks.WEEKDAYS)))) {
            throw new IllegalArgumentException(ErrorMessage.WORKERS_NAMES_DIFFERENCE_ERROR.getErrorMessage());
        }
    }

    public void addWorkers(Weeks weeks, List<String> workerNames) {
        for (String workerName : workerNames) {
            Worker worker = Worker.from(workerName);
            ValidateWorkerUnique(weeks, worker);
            ValidateWorkerMaxSize(weeks);
            this.workers.get(weeks).add(worker);
        }

        validateWorkersMinSize(weeks);
    }

    private void ValidateWorkerUnique(Weeks weeks, Worker worker) {
        if (this.workers.get(weeks).contains(worker)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_UNIQUE_ERROR.getErrorMessage());
        }
    }

    private void ValidateWorkerMaxSize(Weeks weeks) {
        if (this.workers.get(weeks).size() >= 35) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MAX_ERROR.getErrorMessage());
        }
    }

    private void validateWorkersMinSize(Weeks weeks) {
        if (this.workers.get(weeks).size() < 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MAX_ERROR.getErrorMessage());
        }
    }

    public Worker next(Weeks weeks, Worker lastWorker) {
        if (workersWaiting.get(weeks).isEmpty()) {
            Worker nextWorker = workers.get(weeks).removeFirst();
            workers.get(weeks).addLast(nextWorker);

            if (nextWorker.equals(lastWorker)) {
                workersWaiting.get(weeks).addLast(nextWorker);
                nextWorker = workers.get(weeks).removeFirst();
                workers.get(weeks).addLast(nextWorker);
            }

            return nextWorker;
        }

        return workersWaiting.get(weeks).removeFirst();
    }
}
