package xnovakd1.fiit;

import javafx.application.Application;
import javafx.stage.Stage;
import xnovakd1.fiit.model.context.Context;
import xnovakd1.fiit.view.screen.MainScreen;

/**
 * Trieda Zoo extenduje Application (musim, kedze pouzivam JavaFX).
 * Vytvorim si tu MainScreen, moj zakladny View z ktoreho dalej
 * riadim aplikaciu.
 */

public class Zoo extends Application {
    private Context context;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context = new Context(primaryStage);
        context.switchScene(new MainScreen(context));
    }
}
