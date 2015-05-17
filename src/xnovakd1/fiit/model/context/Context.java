package xnovakd1.fiit.model.context;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Vsetky moje views obsahuju context ako argument konstruktoru.
 * Context je trieda, ktora specifikuje vsetky funkcie, ktore moja aplikacia vie globalne robit.
 * V tomto pripade sa teda jedna o prepinanie jednotlivych scenes.
 */

public class Context {
    private Stage primaryStage;
    private Scene currScene;

    public Context(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }

    /**
     * switchScene metoda zoberie za argument View, ktory chcem vytvorit
     * a vytvori ho s novou scene.
     * @param root
     */

   /* public void switchScene(Parent root) {
        switchScene(new Scene(root));

    }*/

    public void switchScene(Parent root) {
        Scene scene = new Scene(root);
        currScene = scene;
        primaryStage.setScene(currScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setTitle("ZooManazer");
        primaryStage.show();
    }
}

