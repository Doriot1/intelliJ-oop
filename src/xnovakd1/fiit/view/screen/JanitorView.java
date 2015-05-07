package xnovakd1.fiit.view.screen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import xnovakd1.fiit.model.Commands;
import xnovakd1.fiit.model.context.Context;
import xnovakd1.fiit.model.problem.DirtProblem;
import xnovakd1.fiit.model.problem.Problem;
import xnovakd1.fiit.model.problem.Tasks;

/**
 * Trieda JanitorView, pokryva grafiku a logiku, ked uzivatel,
 * ktory sa prihlasil je typu Janitor/Upratovac.
 * Created by Daniel on 25.4.2015.
 */
public class JanitorView extends TaskListView {

    private Button vycisti;
    private Label label1;
    private ObservableList<Problem> list2;


    public JanitorView(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        super.initView();
        vycisti = new Button("Vycistit");
        label1 = new Label("Ste prihlaseny ako Upratovac");


        list2 = FXCollections.observableArrayList(Tasks.getInstance().getAll(DirtProblem.class));
        list.setItems(list2);

        vycisti.setOnAction(e -> {
            select = list.getSelectionModel().getSelectedIndex();
            try {
                if (select != -1) {
                    Tasks.getInstance().remove(list2.remove(select));
                    login.getLoggedUser().interpret(Commands.TASK_RESOLVE);
                }
                else {
                    Tasks.getInstance().remove(list2.remove(0));
                    login.getLoggedUser().interpret(Commands.TASK_RESOLVE);
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("V zozname uloh pre upratovaca sa uz nenachadzaju dalsie ulohy.");
            }
        });


    }

    @Override
    protected void addViews() {
        super.addViews();
        add(vycisti, 1, 1);
        add(label1, 0, 0, 3, 1);
        add(list, 2, 0, 3, 5);
    }
}
