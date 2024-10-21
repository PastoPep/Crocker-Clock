import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrockerControlFrame implements ActionListener{

    private static String TimeInBox = null;

    private static String SpeedInTextBox = null;
    private static int speed = 1; 

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

    public CrockerControlFrame() {

        frame = new JFrame("Crocker's Control"); //Application Control Window

        // MAIN FRAME
        panel = new JPanel();//Main frame
        panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

        // CONTROL FRAME
        TimeBox = new JPanel(); //Panel that contains the Set Time
        TimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
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
     panel.add(AddTimeBox,BorderLayout.CENTER);
 
     AddTimeTextBox = new JLabel();
     AddTimeTextBox.setText("Add Time to the timer");//puts word down
     AddTimeBox.add(AddTimeTextBox,BorderLayout.CENTER);
 
 
     AddTextField = new JTextField(1); //creates the text field where the user enters the time
     AddTextField.setText("0");
     AddTimeBox.add(AddTextField,BorderLayout.CENTER);

    /* //ADD TIME
     *  using for Seperation of code 
     */ //Buttons
	
	JButton SetButton = new JButton("Set"); //creates a button to set the time
	SetButton.addActionListener(this);
	TimeBox.add(SetButton);//adds the set time buttons

    JButton AddButton = new JButton("Add"); //creates a button to set the time
	AddButton.addActionListener(this);
	AddTimeBox.add(AddButton);//adds the add time buttons

    
    TimeInBox = setTimeField.getText();
    SpeedInTextBox = setTimeField.getText();

    TimeInBox = SetTextField.getText();
    TimeInAddBox = AddTextField.getText();


    }


    public static void main(String[] args) {
        
        new CrockerClockFrame();

        //System.out.println(TimeInBox);


}

    public static int GetTimeInBox() {//getter to get TimeInBox Value
        return Integer.parseInt(TimeInBox);
    }

    public static int GetSpeedInTextBox() {//getter to get TimeInTargetBox Value
        return Integer.parseInt(SpeedInTextBox);
    }

    public static void resetSpeed() {
        speed = 1;
    }

    public static int getSpeed() {
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

	
    @Override
    public void actionPerformed(ActionEvent e) { //button to call the setter 
        if(e.getActionCommand().equals("Set Time")) {
            SetTimeInBox();
        } else if (e.getActionCommand().equals("Set Speed")) {
            SetSpeedInBox();
            speed = GetSpeedInTextBox();

            CrockerClockFrame.ClockDown.cancel();
            CrockerClockFrame.ClockDown = CrockerClockFrame.updateClocky();
        } else if (e.getActionCommand().equals("Add")) {
            SetTimeInAddBox();
        } 
     }
}
