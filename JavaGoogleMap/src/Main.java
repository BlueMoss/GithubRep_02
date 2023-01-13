import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {
	
	private JTextField textField = new JTextField(30);
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Search");
	
	private GoogleAPI googleAPI = new GoogleAPI();
	private JLabel googleMap = new JLabel();
	
	public class Event implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			setMap(textField.getText());
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
	public void setMap(String location) {
		
		googleAPI.downloadMap(location);
		googleMap.setIcon(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		
		add(BorderLayout.SOUTH, googleMap);
		pack();
	}
	
	public Main() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Google Map_Made by 오세빈");
		setVisible(true);
		
		panel.add(textField);
		panel.add(button);
		button.addMouseListener(new Event());
		
		add(BorderLayout.NORTH, panel);
		pack();
	}

}
