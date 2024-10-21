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
    private static String TimeInAddBox = "0";
    static int returnTime = 0;
    JFrame frame;
    JPanel panel;
    JPanel TimeBox;
    JPanel AddTimeBox;
    JLabel TimeTextBox;
    JLabel AddTimeTextBox;
    JTextField SetTextField;
    static JTextField AddTextField;

    public CrockerControlFrame() {

    frame = new JFrame("Crocker's Control"); //Application Control Window

	panel = new JPanel();//Main frame
	panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	panel.setLayout(new GridLayout(0,1));
    frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

    /*
     *  using for Seperation of code 
     */ //SET TIME

    TimeBox = new JPanel(); //Panel that contains the Set Time
    TimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	TimeBox.setLayout(new GridLayout(0,1));
    panel.add(TimeBox,BorderLayout.CENTER);

	TimeTextBox = new JLabel();
    TimeTextBox.setText("Set a Time");//puts word down
    TimeBox.add(TimeTextBox,BorderLayout.CENTER);


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

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Crocker's Control");
	frame.pack();
	frame.setVisible(true);

    TimeInBox = SetTextField.getText();
    TimeInAddBox = AddTextField.getText();

    }


    public static void main(String[] args) {
	
		new CrockerControlFrame();
        //System.out.println(TimeInBox);


	}

    public static int GetTimeInBox() {//getter to get TimeInBox Value
        return Integer.parseInt(TimeInBox);
    }
    public void SetTimeInBox() {//setter to get TimeInBox Value
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
        if(e.getActionCommand().equals("Set")){
            SetTimeInBox();
        } else if (e.getActionCommand().equals("Add")) {
            SetTimeInAddBox();


        }
	}
}
