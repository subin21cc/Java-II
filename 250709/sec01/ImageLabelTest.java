package sec01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class ImageLabel extends JFrame{
    // 멤버변수 정의
    JPanel panel;
    JLabel label;
    JButton button;

    ImageLabel() {
        // 원도우 초기화
        setTitle("Image viewer");
//        setLayout(new FlowLayout()); // 배치관리자

        // 컴포넌트 생성: 패널, 레이블, 버튼
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        // 이미지객체 생성: ImageIcon
        ImageIcon icon = new ImageIcon("250709/sec01/image.png");
        label.setIcon(icon);
        JButton button = new JButton("click!!");

        panel.add(label);
        panel.add(button);
        add(panel);

//        add(label);
//        add(button);

        // 이벤트 처리 클래스 정의
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click!!");
            }
        });

        setSize(400, 400);
        setVisible(true); // 중요
    }
}
public class ImageLabelTest {
    public static void main(String[] args) {
        new ImageLabel();
    }
}
