package oncall;

import oncall.controller.OnCallController;
import oncall.service.OnCallService;

public class Application {

    public static void main(String[] args) {
        OnCallService onCallService = new OnCallService();
        OnCallController onCallController = new OnCallController(onCallService);
        onCallController.run();
    }
}
