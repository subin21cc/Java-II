package sec02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImageViewer extends JFrame{
    JPanel panel1;
    JPanel panel2;
    JLabel label;
    JButton button1, button2, button3, button4;

    ImageViewer() {
        setTitle("ImageViewer");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label = new JLabel();

        ImageIcon icon = new ImageIcon("250709/sec02/ewha.png");
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton button1 = new JButton("<<");
        JButton button2 = new JButton("<");
        JButton button3 = new JButton(">");
        JButton button4 = new JButton(">>");

        panel1.add(label);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("<<");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("<");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(">");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(">>");
            }
        });

        setSize(400, 250);
        setVisible(true);
    }

}
public class ImageViewerTest {
    public static void main(String[] args) {
        new ImageViewer();
    }
}
