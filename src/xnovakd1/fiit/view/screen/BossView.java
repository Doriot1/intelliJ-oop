package xnovakd1.fiit.view.screen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import xnovakd1.fiit.model.Commands;
import xnovakd1.fiit.model.context.Context;
import xnovakd1.fiit.model.problem.Problem;
import xnovakd1.fiit.model.problem.Tasks;
/**
 * V tejto triede, BossView mam implementovane tri tlacidla,
 * kazde generuje ulohu inemu pracovnikovi
 *   
 */

public class BossView extends TaskListView {

    private Button task;
    private Button task2;
    private Button task3;
    private Label label;

    private ObservableList<Problem> list2;


    public BossView(Context context) {
        super(context);

    }

    @Override
    protected void initView() {
        super.initView();

        task = new Button("Veterinar");
        task2 = new Button("Plumber ");
        task3 = new Button("Janitor    ");
        label = new Label("Generuj ulohy:");


        list2 = FXCollections.observableArrayList(Tasks.getInstance());
        list.setItems(list2);


        task.setOnAction(e -> {
            login.getLoggedUser().interpret(Commands.GENERATE_TASK_VET);
            list.setItems(FXCollections.observableArrayList(Tasks.getInstance()));
        });

        task2.setOnAction(e -> {
            login.getLoggedUser().interpret(Commands.GENERATE_TASK_PLUMBER);
            list.setItems(FXCollections.observableArrayList(Tasks.getInstance()));
        });

        task3.setOnAction(e -> {
            login.getLoggedUser().interpret(Commands.GENERATE_TASK_JANITOR);
            list.setItems(FXCollections.observableArrayList(Tasks.getInstance()));

        });
    }

    @Override
    protected void addViews() {
        super.addViews();
        add(task, 1, 0);
        add(task2, 1, 1);
        add(task3, 1, 2);
        add(list, 2, 0, 3, 5);
        add(label, 0, 0);
    }
}
