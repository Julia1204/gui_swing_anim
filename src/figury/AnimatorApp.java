package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //uniemozliwienie zmiany wymiarow
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 450, wh = 300;
		//setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		setSize(ww,wh);
		setLocationRelativeTo(null); //wyswietla ramke na środku ekranu - zapisane w inny sposob
		contentPane = new JPanel();
		setContentPane(contentPane);
		setBackground(Color.WHITE);  // przywraca biale tlo podczas trawania animacji
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.add(kanwa);

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);

		
	}

}
