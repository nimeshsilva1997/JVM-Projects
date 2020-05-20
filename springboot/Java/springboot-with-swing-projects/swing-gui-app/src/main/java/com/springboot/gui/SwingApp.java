package com.springboot.gui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

@SpringBootApplication //the Swing application is decorated, enabling the Spring Boot services
public class SwingApp extends JFrame {

    public SwingApp() {

        initUI();
    }

    private void initUI() {

        var quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(quitButton);

        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

    public static void main(String[] args) {

        var ctx = new SpringApplicationBuilder(SwingApp.class)
                .headless(false).run(args);
        //retrieve the Swing application bean from the application context
        EventQueue.invokeLater(() -> {

            var ex = ctx.getBean(SwingApp.class);
            ex.setVisible(true);
        });
    }
}
