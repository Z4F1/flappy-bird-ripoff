package no.floatinggoat.flappy.view.score;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import no.floatinggoat.game.helpers.WebRequest;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class ScoreSubmitFrame extends JFrame {
    
    private static final long serialVersionUID = -2851812543327889322L;

    private JTextField textField;
    private int score;

    public ScoreSubmitFrame(int score){
        super("Submit your score:");
        
        this.score = score;

        initialiseElements();
        
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialiseElements(){
        JPanel info = new JPanel();

        info.add(new JLabel(String.format("Your score was: %d", score)), BorderLayout.CENTER);

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout());

        form.add(new JLabel("Name:"));

        textField = new JTextField(20);
        form.add(textField);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());

                dispose();

                postScore(textField.getText());
            }
        });

        form.add(submitBtn);

        add(info, BorderLayout.PAGE_START);
        add(form, BorderLayout.PAGE_END);
    }

    private void postScore(String name){
        try {
            String data = WebRequest.post("https://flappyapi.floatinggoat.no/api/scores", String.format("{\"name\": \"%s\", \"score\": %d}", name, this.score));
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
