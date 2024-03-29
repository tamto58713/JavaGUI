import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LinearEquation {
	// frame
	JFrame frame = new JFrame("My Frame");
	
	// panel
	JPanel panelBtn = new JPanel();
	JPanel panelInput = new JPanel();
	JPanel panelContent = new JPanel();
	// label
	JLabel labelA = new JLabel("A");
	JLabel labelB = new JLabel("B");
	JLabel labelResult = new JLabel("");
	JLabel labelContent = new JLabel("This is a Program that solve Linear Equation ax + b = 0");
	JLabel labelContentDemo = new JLabel("");
	// input
	JTextField txtA = new JTextField();
	JTextField txtB = new JTextField();
	
	
	// button
	JButton btnSolve = new JButton("Solve");
	JButton btnContinue = new JButton("Continue");
	JButton btnExit = new JButton("Exit");

	public void buildLayout() {
		// set Frame
		frame.setSize(800, 500);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panelBtn, BorderLayout.SOUTH);
		frame.add(panelInput, BorderLayout.NORTH);
		frame.add(panelContent, BorderLayout.CENTER);

		// set Panel input
		panelInput.setSize(10, 50);
		panelBtn.setLocation(100, 100);
		panelInput.setLayout(new GridLayout(3, 2));
		panelInput.add(labelA);
		panelInput.add(txtA);
		panelInput.add(labelB);
		panelInput.add(txtB);
		panelInput.add(labelResult);
		
		// set Panel content
		panelContent.setLayout(new GridLayout(2, 1));
		panelContent.add(labelContent);
		panelContent.add(labelContentDemo);
		
		// set Panel button
		panelBtn.setSize(800, 500);
		panelBtn.setLocation(100, 100);
		
		panelBtn.setLayout(new GridLayout(1, 3));
		panelBtn.add(btnSolve);
		panelBtn.add(btnContinue);
		panelBtn.add(btnExit);
		
		
		// set input
		
		
		// set button
		btnSolve.addActionListener(new process());
		btnContinue.addActionListener(new process());
		btnExit.addActionListener(new process());
		
	}
	class Solve {
		private int a;
		private int b;
		public Solve() {
			this.a = 0;
			this.b = 1;
		}
		
		public Solve(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public double solveLinear() {
			return (double) -b/a;
		}
	}

	class process implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnExit) {
				frame.dispose();
				// System.exit(0);
			}
			else if (e.getSource() == btnSolve) {
				if (Integer.parseInt(txtA.getText()) == 0)
					labelResult.setText("Parameter A different 0!!!!!!!!!!!!!!!!!!!");
				else {
					Solve result = new Solve(Integer.parseInt(txtA.getText()), Integer.parseInt(txtB.getText()));
					labelResult.setText(new Double(result.solveLinear()).toString());
				}
			}
		}

	}

}
