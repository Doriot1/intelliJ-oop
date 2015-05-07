package xnovakd1.fiit.view;

import javafx.geometry.HPos;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import xnovakd1.fiit.model.context.Context;
import xnovakd1.fiit.model.file.Login;

/**
 * BasicView je parent vsetkych Views a sam extenduje GridPane,
 * co je nazov layout-u ktory uplatnujem v kazdom View. Mam tu final
 * context aby nikdy nebol prepisany, stale ten isty sa podava dalej
 * pomocou geteru, kt. je tiez final, cize sa neda prekonat.
 */

public abstract class BasicView extends GridPane {

	private final Context context;
	private Label credits;

	protected static Login login = new Login();

	/**
	 * Konstruktor BasicView je prekonavany v kazdom "pohlade",
	 * bere ako argument context pomocou getteru, cize vsetky views
	 * maju ten isty context. Dalej spusta metodu initView() ktora
	 * inicializuje vsetky prvky, ktore v metode addViews() vykreslim
	 * na obrazovku.
	 * @param context
	 */

	public BasicView(Context context) {
		this.context = context;
		initView();
		addViews();
	}

	protected void initView() {
		setWidth(500);
		setHeight(500);

		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10, 10, 10, 10));
		setGridLinesVisible(false);

		for (int i = 0; i < 5; i++) {
			getColumnConstraints().add(new ColumnConstraints(80));
			getRowConstraints().add(new RowConstraints(30));
		}
		getRowConstraints().add(new RowConstraints(30));

		credits = new Label("Daniel Novak, OOP");
	}

	protected void addViews() {
		add(credits, 0, 5, 2, 1);
		setHalignment(credits, HPos.LEFT);
		credits.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
	}

	protected final Context getContext() { // cannot be overriden 'cos final
		return context;

	}
}
