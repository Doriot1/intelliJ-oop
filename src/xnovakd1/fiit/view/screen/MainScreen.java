package xnovakd1.fiit.view.screen;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import xnovakd1.fiit.model.context.Context;
import xnovakd1.fiit.model.user.Boss;
import xnovakd1.fiit.model.user.Janitor;
import xnovakd1.fiit.model.user.Plumber;
import xnovakd1.fiit.model.user.Vet;
import xnovakd1.fiit.view.BasicView;

/**
 * MainScreen je View ktory vidime, ked spustime aplikaciu. Mame
 * v nom potrebne prvky vytvorene a inicializovane, zahrna graficky
 * prihlasovanie a registraciu, taktiez obrazok, ktory ma licencne povolene
 * znovu pouzitie za edukacnym cielom. 
 * Po zadani prihlasovacieho mena sa da prihlasit aj stlacenim Enteru,
 * a vratit sa naspat do tohto view sa da stlacenim Back_SPACE.
 */

public class MainScreen extends BasicView {
    public TextField loginText;
    public TextField registerText;
    public TextField id;
    private Button logButton;
    private Button register;
    private Label label;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label labelId;
    private Image img;
    private ImageView imgView;


    public MainScreen(Context context) {
        super(context);
    }

    @Override
    protected void addViews() {
        super.addViews();
        add(logButton, 2, 1);
        add(loginText, 1, 1);
        add(registerText, 1, 3);
        add(label, 0, 1);
        add(label2, 1, 0, 2, 1);
        add(label3, 0, 2, 3, 1);
        add(label4, 0, 3);
        add(labelId, 0, 4);
        add(imgView, 3, 2, 1, 1);
        add(register, 2, 4);
        add(id, 1, 4);

    }

    @Override
    protected void initView() {
        super.initView();
        logButton = new Button("Login");
        loginText = new TextField();
        label = new Label("Username:");
        label2 = new Label("Nie ste prihlaseny");
        label3 = new Label("Ak nemate ucet, mozete sa registrovat");
        label4 = new Label("Username:");
        labelId = new Label("ID uzivatela:");
        img = new Image("zebra.png");
        imgView = new ImageView(img);
        register = new Button("Registrovat");
        registerText = new TextField();
        id = new TextField();

        setHalignment(label, HPos.CENTER);
        setHalignment(label3, HPos.CENTER);
        setHalignment(label4, HPos.CENTER);
        setHalignment(labelId, HPos.CENTER);


        register.setOnAction(e -> {
            if (login.register("temp.txt", registerText.getText(), id.getText()))
                label3.setText("Registracia prebehla uspesne!");
            else
                label3.setText("Nezadali ste meno alebo ID");
        });


        logButton.setOnAction(e -> {
            if (login.login("temp.txt", loginText.getText())) {
                if (login.getLoggedUser() instanceof Boss)
                    getContext().switchScene(new BossView(getContext()));
                else if (login.getLoggedUser() instanceof Vet)
                    getContext().switchScene(new VetView(getContext()));
                else if (login.getLoggedUser() instanceof Janitor)
                    getContext().switchScene(new JanitorView(getContext()));
                else if (login.getLoggedUser() instanceof Plumber)
                    getContext().switchScene(new PlumberView(getContext()));
            } else
                label2.setText("Nespravne meno");
        });


        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (login.login("temp.txt", loginText.getText())) {
                    if (login.getLoggedUser() instanceof Boss)
                        getContext().switchScene(new BossView(getContext()));
                    else if (login.getLoggedUser() instanceof Vet)
                        getContext().switchScene(new VetView(getContext()));
                    else if (login.getLoggedUser() instanceof Janitor)
                        getContext().switchScene(new JanitorView(getContext()));
                    else if (login.getLoggedUser() instanceof Plumber)
                        getContext().switchScene(new PlumberView(getContext()));
                } else
                    label2.setText("Nespravne meno");
            }
        });
    }
}
