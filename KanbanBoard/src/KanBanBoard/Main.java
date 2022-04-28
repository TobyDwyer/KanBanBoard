package KanBanBoard;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // <editor-fold desc="Varible Declaration">
    public static String inptPw;
    public static String inptUn;
    public static String inptFn;
    public static String inptSurname;
    public static JFrame Homeframe = new JFrame("KanBan Board");
    public static JPanel pnlWindow = new JPanel();
    public static JPanel pnlBckgrd = new JPanel();
    public static JPanel pnlLogin = new JPanel();
    public static JPanel pnlSignUp = new JPanel();

    public static int winWidth, winHeight, panelx, panely,
            panelWidth, panelHeight;

    //</editor-fold>
    //<editor-fold desc="Array Declaration">
    public static ArrayList<String> arrUn = new ArrayList();
    public static ArrayList<String> arrPw = new ArrayList();
    public static ArrayList<String> arrFname = new ArrayList();
    public static ArrayList<String> arrSurnames = new ArrayList();
    //</editor-fold>

    public static void main(String[] args) {

        //Calls method to create home screen Gui on program run.
        GuiCreator objGui = new GuiCreator();
        objGui.GUIHomeScreen();
        arrUn.add("Greg_");
        arrPw.add("Greg321@");
        arrFname.add("Toby");
        arrSurnames.add("Dwyer");

    }

    public static void writetoarray() {
        arrFname.add(inptFn);
        arrSurnames.add(inptSurname);
        arrUn.add(inptUn);
        arrPw.add(inptPw);
    }

    public static boolean containsSpecialCharacter(String s) {

        /*Creates a pattern which Searches if a letter is not(^) 
        one of the digits specified*/
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher match = pattern.matcher(s);

        return match.find();

    }

 

}
