package xnovakd1.fiit.model.file;

import xnovakd1.fiit.model.exception.RegisterException;
import xnovakd1.fiit.model.user.*;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Daniel on 18.4.2015.
 * V tejto triede mam implementovane prihlasovanie a registrovanie uzivatelov.
 * V login metode overim zadaneho usera, ci sa zhoduje s databazou uzivatelov v subore "temp.txt".
 * Ak sa najde zhoda, tak uzivatela pustim dalej a dostane taky View, ktory koresponduje s jeho ID.
 * Taktiez mam v tejto triede implementovanu registraciu v metode register.
 */
public class Login {
    private LoggedUser loggedUser;
    private boolean logged = false;
    private int ID;
    private String user;



    public boolean login(String fileName, String userName) {
        Scanner scan = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            scan = new Scanner(new java.io.File(fileName));

            while (scan.hasNext()) {
                user = scan.nextLine();
                if (userName.equals(user)) {
                    logged = true;
                    ID = scan.nextInt();
                    validateLoggedInUser();
                    break;
                } else
                    logged = false;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file" + fileName);
        } catch (IOException ex) {
            System.out.println("Error reading file" + fileName);
        } finally {
            if (scan != null) scan.close();
        }
        return logged;
    }

    public boolean register(String fileName, String userName, String ID) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {

            try {
                validateRegisteredName(out, userName, ID);
            } catch (RegisterException e) {
                System.out.println("S danym menom a/alebo ID sa neda zaregistrovat.");
                return false;
            }

        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
            return true;
    }

    private void validateRegisteredName(PrintWriter out, String userName, String ID) throws RegisterException {
        if(userName.equals("") || ID.equals("") || userName.equals(" ") || userName.equals("  "))
            throw new RegisterException();
        out.println(userName);
        out.println(ID);

    }


    private void validateLoggedInUser() {
        if (ID >= 200 && ID < 300)
            loggedUser = new Vet();
        else if (ID >= 300 && ID < 400)
            loggedUser = new Plumber();
        else if (ID >= 400 && ID < 500)
            loggedUser = new Janitor();
        else if (ID == 100)
            loggedUser = new Boss();
    }

    public LoggedUser getLoggedUser() {
        return loggedUser;

    }

}
