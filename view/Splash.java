package view;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Splash extends JWindow {

    private int duration;
    private ImageIcon backgroundImage;

    public Splash(int d) {
        duration = d;
    }

    public void showSplash() {
        URL bgURL = Splash.class.getResource("/assets/background.png");
        ImageIcon originalImageIcon = new ImageIcon(bgURL);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(resizedImage);

        JPanel content = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, 800, 400, null);
            }
        };
        content.setBackground(Color.white);

        int width = 800;
        int height = 400;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        ImageIcon gifIcon = new ImageIcon(Splash.class.getResource("/assets/loading5.gif"));
        Image gifImage = gifIcon.getImage();
        Image resizedGifImage = gifImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon resizedGifIcon = new ImageIcon(resizedGifImage);

        JLabel label = new JLabel(resizedGifIcon);
        content.add(label, BorderLayout.CENTER);
        setContentPane(content);
        setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
        setVisible(false);

        Tabela tabela = new Tabela(null, true);
        tabela.setLocationRelativeTo(null);
        tabela.setVisible(true);
    }

    public void showSplashAndExit() {
        showSplash();
        System.exit(0);
    }

    public static void main(String[] args) {
        Splash splash = new Splash(10000);
        splash.showSplashAndExit();
    }
}
