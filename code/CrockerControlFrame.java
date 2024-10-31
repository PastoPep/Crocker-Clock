
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
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CrockerControlFrame implements ActionListener{

    private static String TimeInBox = null;

    private static String SpeedInTextBox = null;
    private static double speed = 1.0; 

    private static String TimeInAddBox = "0";
    static int returnTime = 0;

    JFrame frame;
    JPanel panel;
    JPanel TimeBox;
    JPanel AddTimeBox;
    JLabel TimeTextBox;

    JLabel TimeTextBox2;
    JTextField setTimeField;
    JTextField setSpeedField;
    JLabel AddTimeTextBox;
    JTextField SetTextField;
    static JTextField AddTextField;

    //CLOCK FRAME RELATED
    JPanel Clockpanel;
    Border blackline;
    static JLabel clocky;

    //Clock Related
    private static int time = 0; 
	private static int OGtime = time+0; 
	private static int timeInSecond = time%60; //time in seconds
	private static int timeInRealMinute = time/60; //time in minutes, used for calculations
	private static int timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock
	private static int timeInHour = timeInRealMinute/60;  //time in hours
    static Timer ClockDown;

    // public CrockerControlFrame() {

    // frame = new JFrame("Crocker's Control"); //Application Control Window

	// panel = new JPanel();//Main frame
	// panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	// panel.setLayout(new GridLayout(0,1));
    // frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

    // /*
    //  *  using for Seperation of code 
    //  */ //SET TIME

    // TimeBox = new JPanel(); //Panel that contains the Set Time
    // TimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	// TimeBox.setLayout(new GridLayout(0,1));
    // panel.add(TimeBox,BorderLayout.CENTER);

    // JLabel AddTimeTextBox;
    // JTextField SetTextField;
    // static final JTextField AddTextField;

    public CrockerControlFrame() {
        ClockDown = updateClocky();
        frame = new JFrame("Crocker's Control"); //Application Control Window

        // MAIN FRAME
        panel = new JPanel();//Main frame
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

        // CLOCK FRAME
        Clockpanel = new JPanel(); //Panel that contains the real clock
        panel.add(Clockpanel,BorderLayout.CENTER);
        blackline = BorderFactory.createLineBorder(Color.black);
        Clockpanel.setBorder(blackline);
        clocky = new JLabel();
        Clockpanel.add(clocky,BorderLayout.CENTER);
        clocky.setText(updateClockLabel());

        // CONTROL FRAME
        TimeBox = new JPanel(); //Panel that contains the Set Time
        TimeBox.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        TimeBox.setLayout(new GridLayout(0,1));
        panel.add(TimeBox,BorderLayout.CENTER);

        // SET TIME - TEXT LABEL
        TimeTextBox = new JLabel();
        TimeTextBox.setText("Set a Time");//Adds a to-do label
        TimeBox.add(TimeTextBox,BorderLayout.CENTER);

        setTimeField = new JTextField(1); //creates the text field where the user enters the time
        TimeBox.add(setTimeField,BorderLayout.CENTER);


        // BUTTON (SET THE ACTUAL TIME)
        JButton SetTimeButton = new JButton("Set Time"); //creates a button to set the time
        SetTimeButton.addActionListener(this);
        TimeBox.add(SetTimeButton);//adds the buttons


        // SET SPEED - TEXT LABEL
    	TimeTextBox2 = new JLabel();
    	TimeTextBox2.setText("Set the speed (1 is default)");//Adds a second label
    	TimeBox.add(TimeTextBox2,BorderLayout.CENTER); // Adds the SECOND label after the field


        // TEXT BOX (INPUT)
    	setSpeedField = new JTextField(1); //creates the text field where the user enters the SPEED
    	setSpeedField.setText("1");
        TimeBox.add(setSpeedField,BorderLayout.CENTER); 
    

        // BUTTON (SET THE SPEED)
        JButton SetSpeedButton = new JButton("Set Speed"); //creates a button to set the SPEED
        SetSpeedButton.addActionListener(this);
        TimeBox.add(SetSpeedButton);//adds the buttons
    


        // CONTROL APP. FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Crocker's Control");
        frame.pack();
        frame.setVisible(true);

    SetTextField = new JTextField(1); //creates the text field where the user enters the time
    TimeBox.add(SetTextField,BorderLayout.CENTER);

    /* //SET TIME
     *  using for Seperation of code 
     */ //ADD TIME

     AddTimeBox = new JPanel(); //Panel that contains the Set Time
     AddTimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
     AddTimeBox.setLayout(new GridLayout(0,1));
     //panel.add(AddTimeBox,BorderLayout.CENTER);
     TimeBox.add(AddTimeBox,BorderLayout.CENTER);

 
     AddTimeTextBox = new JLabel();
     AddTimeTextBox.setText("Add Time to the timer");//puts word down
     //AddTimeBox.add(AddTimeTextBox,BorderLayout.CENTER);
     TimeBox.add(AddTimeTextBox,BorderLayout.CENTER);
 
     AddTextField = new JTextField(1); //creates the text field where the user enters the time
     AddTextField.setText("0");
     //AddTimeBox.add(AddTextField,BorderLayout.CENTER);
     TimeBox.add(AddTextField,BorderLayout.CENTER);

    /* //ADD TIME
     *  using for Seperation of code 
     */ //Buttons
		
    JButton AddButton = new JButton("Add"); //creates a button to set the time
	AddButton.addActionListener(this);
	//AddTimeBox.add(AddButton);//adds the add time buttons
    TimeBox.add(AddButton,BorderLayout.CENTER);
    

    TimeInBox = setTimeField.getText();
    SpeedInTextBox = setTimeField.getText();

    TimeInBox = SetTextField.getText();
    TimeInAddBox = AddTextField.getText();

    }


    public static void main(String[] args) {

        
        new CrockerClockFrame();


	
		new CrockerControlFrame();

        //System.out.println(TimeInBox);


}

    public static int GetTimeInBox() {//getter to get TimeInBox Value
        return Integer.parseInt(TimeInBox);
    }

    public static double GetSpeedInTextBox() {//getter to get TimeInTargetBox Value
        return Double.parseDouble(SpeedInTextBox);
    }

    public static void resetSpeed() {
        speed = 1;
    }

    public static double getSpeed() {
        return speed;
    }

    public void SetTimeInBox() {//setter to get TimeInBox Value
        TimeInBox = setTimeField.getText();
    }

    public void SetSpeedInBox() {//setter to get TimeInTargetBox Value
        SpeedInTextBox = setSpeedField.getText();

        TimeInBox = SetTextField.getText();
    }

    public static int GetTimeInAddBox() {//getter to get TimeInBox Value
        returnTime = Integer.parseInt(TimeInAddBox);
        return returnTime;
    }
    public void SetTimeInAddBox() {//setter to get TimeInBox Value
        TimeInAddBox = AddTextField.getText();
    }
    public static void ResetTimeAddBox() {//RESETS THE TIMEINADDBOX TO 0 SO WHEN THE TIMER TASK RUNS IT DOESNT ADD IT EVERY TIME
        AddTextField.setText("0");
        TimeInAddBox = "0";
    }

    public static String updateClockLabel() {

		timeInSecond = time%60; //time in seconds
		timeInRealMinute = time/60; //time in minutes
		timeInHour = timeInRealMinute/60;  //time in hours
		timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock
		
		// Using format!
		return String.format("%02d : %02d : %02d", timeInHour, timeInDisplayedMinute, timeInSecond);
		// return (""+ timeInHour +" : " + timeInDisplayedMinute + " : " + timeInSecond); //RETURNS THE TIME IN HH:MM:SS format USED FOR TEXT LABELS
	}
    
	//THE CLOCK
    public static Timer updateClocky() { //the code to update the timer to countdown
		ClockDown = new Timer();
		TimerTask timerTaskObj;
            timerTaskObj = new TimerTask() {
				@Override
                public void run() {

					if(time <=-1) {
						time = 0;
						ClockDown.cancel(); // stops clock
					} else {

						if (CrockerControlFrame.GetTimeInAddBox() != 0) {
							time += CrockerControlFrame.GetTimeInAddBox();
							CrockerControlFrame.ResetTimeAddBox();
						}

						timeInSecond = time%60; //time in seconds
						timeInRealMinute = time/60; //time in minutes
						timeInHour = timeInRealMinute/60;  //time in hours
						timeInDisplayedMinute = timeInRealMinute%60; //time in minutes, used for display in clock

						clocky.setText(updateClockLabel());//puts word down

						time--;
					}
					
                }
            };

            ClockDown.schedule(timerTaskObj, 0, (int) (1000/(CrockerControlFrame.getSpeed())));//delays in ms
			return ClockDown;
        }

        public static void StartClock(int times) { //starts clock from ClockFrame used for when startCountdown new time
            time = times;
            ClockDown = updateClocky();
        }
        public static void StartClock() { //starts clock from ClockFrame
            ClockDown = updateClocky();
        }
        public static void StopClock() {
            ClockDown.cancel();
        }
        public static void ResetClockDown(int times) {
            ClockDown.cancel();
            time = times;
            ClockDown = updateClocky();
            
        }

        @Override
        public void actionPerformed(ActionEvent e) { //button to call the setter 
    
            if(e.getActionCommand().equals("Set Time")) {
                SetTimeInBox();
            } else if (e.getActionCommand().equals("Set Speed")) {
                SetSpeedInBox();
                speed = GetSpeedInTextBox();
    
    
                if(!CrockerClockFrame.isRunning()){
                    CrockerClockFrame.ClockDown.cancel();
                    CrockerClockFrame.ClockDown = CrockerClockFrame.updateClocky();
                }
                
                
            } else if (e.getActionCommand().equals("Add")) {
                SetTimeInAddBox();
            } 
         }
    }
