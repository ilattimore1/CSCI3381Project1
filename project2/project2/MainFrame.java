//India Lattimore
//3381 O-O Java Developemnt

package project2;

import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Patient Collection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);

		
		frame.getContentPane().add(new MainPanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}

}

