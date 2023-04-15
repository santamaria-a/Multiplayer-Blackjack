package com.oblackjack.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Import ActionListener
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MainFrame {
    private CardLayout cLayout = new CardLayout();
    private JPanel cards = new JPanel(cLayout);
    private MainMenuPanel mainMenuPanel;
    private LoginPanel loginPanel;

    public MainFrame() {
        // Listeners
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonName = ((JButton) e.getSource()).getName();
                switch (buttonName) {
                    case MainMenuPanel.PLAYGAME:
                        swapPlayGame();
                        break;
                    case LoginPanel.SUBMIT:
                        System.out.print("Attempting to login as " + loginPanel.getUsername() + ":" + loginPanel.getPasswordHash());
                }
            }
        };
        mainMenuPanel = new MainMenuPanel(actionListener);
        loginPanel = new LoginPanel(actionListener);

        cards.add(mainMenuPanel.getPanel(), MainMenuPanel.MAINMENU);
        cards.add(loginPanel.getPanel(), MainMenuPanel.PLAYGAME);
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cards);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void swapMainMenu() {
        cLayout.show(cards, MainMenuPanel.MAINMENU);
    }

    public void swapPlayGame() {
        cLayout.show(cards, MainMenuPanel.PLAYGAME);
    }

    public void swapInstructions() {
        cLayout.show(cards, MainMenuPanel.INSTRUCTIONS);
    }

    public void swapLeaderboard() {
        cLayout.show(cards, MainMenuPanel.LEADERBOARD);
    }

    public void quitGame() {
        System.exit(0);
    }
}