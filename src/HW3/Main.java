package HW3;

import HW3.presenter.Presenter;
import HW3.view.ConsoleView;
import HW3.view.View;

public class Main {
    public static void main(String[] args) {
        Presenter<View> launch = new Presenter<View>(new ConsoleView());
        launch.start();
    }
}
