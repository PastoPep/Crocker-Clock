// Java Swing Program to demonstrate
// a simple JFrame
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
// Driver Class
public class CrockerClockFrame implements ActionListener{
	private int time = 5; 
	private JLabel clocky;

	// Create a new JFrame
	public CrockerClockFrame() {

	JFrame frame = new JFrame("Crocker's Clock"); //creates the full program, and the entire box as a whole

	JButton StartButton = new JButton("Start");
	StartButton.addActionListener(this);

	JButton StawpButton = new JButton("Stop");//add buttons


	// StartButton.setPreferredSize(new Dimension(300, 300));
	// StawpButton.setPreferredSize(new Dimension(300, 300));

	clocky = new JLabel();//puts word down

	JPanel ClockFrame = new JPanel(); //create frame in place inside panel
	JPanel buttonFrame = new JPanel(); //create frame in place inside panel

	Border border = BorderFactory.createLineBorder(Color.black);
	ClockFrame.setBorder(border);

	JPanel panel = new JPanel();//creates the frame/appplication
	panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	panel.setLayout(new GridLayout(0,1));

	panel.add(ClockFrame,BorderLayout.CENTER);//adds the clock frame where the timer will be
	ClockFrame.add(clocky,BorderLayout.CENTER);//temp text will be timer later
	panel.add(buttonFrame,BorderLayout.CENTER);//adds the button frame
	buttonFrame.add(StartButton);//adds both buttons
	buttonFrame.add(StawpButton);
	

	frame.add(panel,BorderLayout.CENTER);//main frame
	frame.pack();
	frame.setVisible(true);

	frame.add(panel,BorderLayout.CENTER);//addings panel with button and text to main frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Crocker's Clock");
	frame.pack();
	frame.setVisible(true);
	}

	//color

	public static void main(String[] args) {
		new CrockerClockFrame();//calls the method to opent he frame


	}

    @Override
    public void actionPerformed(ActionEvent e) { //start button to start countdown
		clocky.setText(""+time);//puts word down
        updateClocky();

        throw new UnsupportedOperationException("Not supported yet.");
    }
	
	public void updateClocky() { //the code to update the timer to countdown

		Timer timerObj = new Timer();
		TimerTask timerTaskObj;
            timerTaskObj = new TimerTask() {
                public void run() {

					if(time <=-1) {
						time = 0;
						timerObj.cancel();
					} else {
						clocky.setText(""+time);//puts word down
						time--;
					}
					
                }
            };

timerObj.schedule(timerTaskObj, 0, 1000);//delays in ms

	}	


}


/* OLD CODE

		
		// Create a new JFrame
		JFrame frame = new JFrame("Crocker's Clock"); //creates the full program, and the entire box as a whole
		// Set frame properties
		frame.setSize(500,350); // Set the size of the frame

		
		JInternalFrame jClockInternalFrame=new JInternalFrame(); //creates the inner box where the display clock will be
		jClockInternalFrame.setPreferredSize(new Dimension(200, 250));
        jClockInternalFrame.setLocation(50, 50);
        jClockInternalFrame.setSize(10, 5);
        jClockInternalFrame.setTitle("Crocker Clock");
        jClockInternalFrame.setVisible(true);
        jClockInternalFrame.setClosable(true);
        jClockInternalFrame.setResizable(true);
		jClockInternalFrame.pack();

		JLabel label
			= new JLabel("Clock For Crocker", SwingConstants.CENTER);
			jClockInternalFrame.add(label); //adds the text to the mid of the internal layer
		

        frame.add(jClockInternalFrame,BorderLayout.CENTER);
        frame.repaint();

		//creates button
		JButton button = new JButton("Start");
		// JInternalFrame.add(button);

		// Close operation
		frame.setDefaultCloseOperation(
			JFrame.EXIT_ON_CLOSE);

		// Make the frame visible
		frame.setVisible(true);



 */
