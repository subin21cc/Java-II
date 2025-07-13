import java.awt.*;
import javax.swing.*;

public class Piano extends JFrame {
    public Piano() {
        JButton btn;
        String str[] = {"도", "레", "미", "파", "솔", "라", "시", "도"};
        setTitle("Piano");
        setSize(400,150);
        setLayout(new GridLayout(1,8));
        for (String i : str) {
            btn = new JButton(i);
            add(btn);
        }
        setVisible(true);
    }
    public static void main(String[] args) {
        new Piano();
    }
}