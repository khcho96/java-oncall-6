package oncall.domain;

import oncall.domain.date.Date;

public class OnCall {

    private Date date;
    private Worker worker;
    private boolean both;

    private OnCall(Date date, Worker worker, boolean both) {
        this.date = date;
        this.worker = worker;
        this.both = both;
    }

    public static OnCall of(Date date, Worker worker, boolean both) {
        return new OnCall(date, worker, both);
    }

    public static OnCall of(Date date, Worker worker) {
        return new OnCall(date, worker, false);
    }

    public Date getDate() {
        return date;
    }

    public Worker getWorker() {
        return worker;
    }

    public boolean isBoth() {
        return both;
    }
}
