package Controller;

import java.io.IOException;

import Model.DBHelper;
import View.PRGFrame;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        DBHelper.inizializza();     
        new PRGFrame();    // Program frame
    }

}
