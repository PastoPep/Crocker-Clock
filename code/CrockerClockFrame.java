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
// Driver Class
public class CrockerClockFrame implements ActionListener{
	private int time = 0; 
	private int OGtime = time+0; 
	private int timeInSecond = time%60; //time in seconds
	private int timeInRealMinute = time/60; //time in minutes, used for calculations
	private int timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock
	private int timeInHour = timeInRealMinute/60;  //time in hours
	private boolean Isclockrunning = false; //boolean used to check if a timertask/clock is being ran
	private boolean IsStopped = true; //boolean used to check if the clock is in a stopped state

	Timer ClockDown;//creates a universal countdown
	
//		clocky.setText(""+ timeInHour +" : " + timeInMinute " : " + timeInSecond);//puts word down

	JFrame frame;

	private final JLabel clocky;

	private final JPanel ClockFrame;

	// Create a new JFrame
	public CrockerClockFrame() {
    ClockDown = updateClocky();

		

	frame = new JFrame("Crocker's Clock"); //creates the full program, and the entire box as a whole


	JButton StartButton = new JButton("Start");
	StartButton.addActionListener(this);

	JButton StawpButton = new JButton("Stop");//add buttons
	StawpButton.addActionListener(this);

	JButton ResetButtons = new JButton("Reset");//add buttons
	ResetButtons.addActionListener(this);


	// StartButton.setPreferredSize(new Dimension(300, 300));
	// StawpButton.setPreferredSize(new Dimension(300, 300));

	clocky = new JLabel();//puts word down

	ClockFrame = new JPanel(); //create frame in place inside panel
	JPanel buttonFrame = new JPanel(); //create frame in place inside panel

	Border border = BorderFactory.createLineBorder(Color.black);
	ClockFrame.setBorder(border);

	JPanel panel = new JPanel();//creates the frame/appplication
	panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	panel.setLayout(new GridLayout(0,1));

	panel.add(ClockFrame,BorderLayout.CENTER);//adds the clock frame where the timer will be
	ClockFrame.add(clocky,BorderLayout.CENTER);//temp text will be timer later
	panel.add(buttonFrame,BorderLayout.CENTER);//adds the button frame
	buttonFrame.add(StartButton);//adds the buttons
	buttonFrame.add(StawpButton);
	buttonFrame.add(ResetButtons);
	

	frame.add(panel,BorderLayout.CENTER);//main frame
	frame.pack();
	frame.setVisible(true);

	frame.add(panel,BorderLayout.CENTER);//addings panel with button and text to main frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Crocker's Clock");
	frame.pack();
	frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		new CrockerClockFrame();//calls the method to opent he frame
        //colorChangeFrameBGColor(ClockFrame);
		
		new CrockerControlFrame();
		
	}

    @Override
    public void actionPerformed(ActionEvent e) { //start button to start countdown
		
		if(e.getActionCommand().equals("Start")){
			


			if(Isclockrunning == false) { //CHECKS WEATHER TIMER TASK IS BEING RAN

				time = CrockerControlFrame.GetTimeInBox();//updates the timer based on the crocker control panel
				OGtime = time;
				ClockDown = updateClocky();
				Isclockrunning = true;
				IsStopped = false;
				
			} else if (IsStopped == true) { //CHECKS TO SEE IF THE CODE HAS BEEN STOPPED PREVIOUSLT AND IF SO RUNS

				ClockDown = updateClocky();
				IsStopped = false;

			} else {

			}
		
		
		clocky.setText(updateClockLabel());//puts word down

        throw new UnsupportedOperationException("Not supported yet.");
    } else if (e.getActionCommand().equals("Stop")) { //when stop button, calls cancel on the tmer
		ClockDown.cancel();
		IsStopped = true;

	} else if (e.getActionCommand().equals("Reset")) {//when reset button, calls cancel on timer and resets to og time
		time = CrockerControlFrame.GetTimeInBox();//updates the timer based on the crocker control panel
		OGtime = time;
		ClockDown.cancel();
		Isclockrunning = false;
		IsStopped = true;
		clocky.setText(updateClockLabel()); //runs the UpdateClockLabel method to change the label shown
		
	}
}
	
	public Timer updateClocky() { //the code to update the timer to countdown

		ClockDown = new Timer();
		TimerTask timerTaskObj;
            timerTaskObj = new TimerTask() {
				@Override
                public void run() {

					if(time <=-1) {
						time = 0;
						Isclockrunning = false;
						ClockDown.cancel(); // stops clock
					} else {
						timeInSecond = time%60; //time in seconds
						timeInRealMinute = time/60; //time in minutes
						timeInHour = timeInRealMinute/60;  //time in hours
						timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock

						clocky.setText(updateClockLabel());//puts word down

						time--;
					}
					
                }
            };

			ClockDown.schedule(timerTaskObj, 0, 1000/(CrockerControlFrame.getSpeed()));//delays in ms
			return ClockDown;
	}	

	public String updateClockLabel() {

		timeInSecond = time%60; //time in seconds
		timeInRealMinute = time/60; //time in minutes
		timeInHour = timeInRealMinute/60;  //time in hours
		timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock


		// Using format!
		return String.format("%02d : %02d : %02d", timeInHour, timeInDisplayedMinute, timeInSecond);
		// return (""+ timeInHour +" : " + timeInDisplayedMinute + " : " + timeInSecond); //RETURNS THE TIME IN HH:MM:SS format USED FOR TEXT LABELS
	}

}


