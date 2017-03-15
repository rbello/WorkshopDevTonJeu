package fr.exia;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					Panel.Animation anim = new MonAnimation();
					Panel panel = new Panel(anim);
					frame.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent e) {
							if (e.getKeyCode() != KeyEvent.VK_ENTER) return;
							System.out.println("Fire !!");
						}
					});
					frame.getContentPane().add(panel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setResizable(false);
		setTitle("Balistik - Hit [Enter] to fire !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

	public void afficher() {
		// TODO Auto-generated method stub
		
	}

}
