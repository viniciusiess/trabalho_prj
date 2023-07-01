package trabalho_prj;

import view.Splash;

public class Trabalho_prj {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {

        }

        Splash splash = new Splash(5000);
        splash.showSplashAndExit();
    }
}
