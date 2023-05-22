import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        InterfazHanoi Ih = new InterfazHanoi();
        Ih.setTitle("pr");
        Ih.setSize(1000, 500);
        Ih.setVisible(true);
        Ih.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}