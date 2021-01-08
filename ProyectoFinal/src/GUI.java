import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JPanel panel1;
	private int flag;
	
	public GUI() {
		frame = new JFrame();
		
		JButton button = new JButton(new AbstractAction("Click me") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("Clickado");
				flag = 1;
				}
			
		});
		
		button.setFocusable(false);
		label = new JLabel("Sin clicks");
		Font font = new Font("",Font.PLAIN,30);
		label.setFont(font);
		
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel1.setLayout(new GridLayout(0, 1));
		panel1.add(label);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(2, 2));
		panel.add(button);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public int getFlag() {
		return this.flag;
	}
	public void setFlag(int numero) {
		this.flag = numero;
	}

}