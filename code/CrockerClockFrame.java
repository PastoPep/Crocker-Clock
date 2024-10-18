//Clock for Mr. Crocker
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
// Driver Class
public class CrockerClockFrame implements ActionListener{
	private int time = 5; 
	private int OGtime = time+0; 
	Timer ClockDown;//creates a universal countdown

	JFrame frame;

	private final JLabel clocky;

	private final RoundedPanel ClockFrame;

	// Create a new JFrame
	public CrockerClockFrame() {

		frame = new JFrame("Crocker's Clock"); //creates the full program, and the entire box as a whole


		// Creates and formats the whole panel for the appplication
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(83,106,83,106));
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridLayout(0,1));
		panel.setPreferredSize(new Dimension(960, 540));


		// Creates and formats the frame for the Display Timer
		ClockFrame = new RoundedPanel();
		ClockFrame.setBackground(new Color(56, 182, 255));
		ClockFrame.setPreferredSize(new Dimension(750, 210));


		// Creates and formats the text for the Display Timer
		clocky = new JLabel();
		clocky.setFont(new Font("Arial", Font.BOLD, 160));
		clocky.setForeground(Color.BLACK);


		// Creates and formats panel to hold all the buttons
		JPanel buttonFrame = new JPanel(); 
		buttonFrame.setBorder(BorderFactory.createEmptyBorder(73,38,0,38));
		buttonFrame.setBackground(Color.WHITE);
		buttonFrame.setLayout(new GridLayout(0, 3, 36, 0));


		// Creates and formats Start Button
		RoundedButton StartButton = new RoundedButton("Start");
		StartButton.addActionListener(this);
		StartButton.setFont(new Font("Arial", Font.BOLD, 40));
		StartButton.setForeground(Color.WHITE);
		StartButton.setBackground(new Color(154, 255, 156));
		StartButton.setPreferredSize(new Dimension(200, 70)); 


		// Creates and formats Stop Button
		RoundedButton StawpButton = new RoundedButton("Stop");
		StawpButton.addActionListener(this);
		StawpButton.setFont(new Font("Arial", Font.BOLD, 40));
		StawpButton.setBackground(new Color(255, 129, 101));
		StawpButton.setForeground(Color.WHITE);
		StawpButton.setPreferredSize(new Dimension(200, 70)); 


		// Creates and formats Reset Button
		RoundedButton ResetButtons = new RoundedButton("Reset");
		ResetButtons.addActionListener(this);
		ResetButtons.setFont(new Font("Arial", Font.BOLD, 40));
		ResetButtons.setBackground(new Color(166, 166, 166));
		ResetButtons.setForeground(Color.WHITE);
		ResetButtons.setPreferredSize(new Dimension(200, 70));
		

		// Adds all panels and buttons to their locations
		panel.add(ClockFrame,BorderLayout.CENTER); 
		panel.add(buttonFrame,BorderLayout.CENTER); 
		ClockFrame.add(clocky,BorderLayout.CENTER); 
		buttonFrame.add(StartButton); 
		buttonFrame.add(StawpButton);
		buttonFrame.add(ResetButtons);
		
		
		// Formats main frame
		frame.add(panel,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		frame.add(panel,BorderLayout.CENTER); //addings panel with button and text to main frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Crocker's Clock");
		frame.pack();
		frame.setVisible(true);
	}


	// Subclass to allow for rounded panels with rounded borders
	public class RoundedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create(); 
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 51, 51); // Rounded corners
            g2.dispose();
        }

		protected void paintBorder(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setStroke(new BasicStroke(2));
			g2.setColor(new Color(0,0,0));
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 51, 51);  // Draw the border with rounded corners


			g2.dispose();
		}
    }

	public class RoundedButton extends JButton {

		public RoundedButton(String text) {
			super(text);
			setContentAreaFilled(false);  // Turn off the default painting
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Button background
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), 51, 51); // Rounded corners
			
			// Button text
			super.paintComponent(g2);
			g2.dispose();
		}

		@Override
		protected void paintBorder(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setStroke(new BasicStroke(2));
			g2.setColor(new Color(0,0,0));
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 51, 51);  // Draw the border with rounded corners


			g2.dispose();
		}

		
	}

	public static void main(String[] args) {
		new CrockerClockFrame();//calls the method to opent he frame
        //colorChangeFrameBGColor(ClockFrame);
		
		new CrockerControlFrame();

	}

    @Override
    public void actionPerformed(ActionEvent e) { //start button to start countdown

		time = CrockerControlFrame.GetTimeInBox();//updates the timer based on the crocker control panel
		OGtime = time;

		if(e.getActionCommand().equals("Start")){
		System.out.print(e);
		clocky.setText(""+time);//puts word down
        ClockDown = updateClocky();


        throw new UnsupportedOperationException("Not supported yet.");
    } else if (e.getActionCommand().equals("Stop")) { //when stop button, calls cancel on the tmer
		ClockDown.cancel();

	} else if (e.getActionCommand().equals("Reset")) {//when reset button, calls cancel on timer and resets to og time
		time = 0;
		ClockDown.cancel();
		time = OGtime;
		clocky.setText(""+time);//puts word down
		
		
	}
}
	
	public Timer updateClocky() { //the code to update the timer to countdown

		ClockDown = new Timer();
		TimerTask timerTaskObj;
            timerTaskObj = new TimerTask() {
                public void run() {

					if(time <=-1) {
						time = 0;
						ClockDown.cancel(); // stops clock
					} else {
						clocky.setText(""+time);//puts word down
						time--;
					}
					
                }
            };

			ClockDown.schedule(timerTaskObj, 0, 1000);//delays in ms
			return ClockDown;
	}	

}


/*








 */
