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
    JFrame frame;
    JPanel panel;
    JPanel TimeBox;
    JLabel TimeTextBox;
    JTextField textField;

    public CrockerControlFrame() {

    frame = new JFrame("Crocker's Control"); //Application Control Window

	panel = new JPanel();//Main frame
	panel.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	panel.setLayout(new GridLayout(0,1));
    frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

    TimeBox = new JPanel(); //Panel that contains the Set Time
    TimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
	TimeBox.setLayout(new GridLayout(0,1));
    panel.add(TimeBox,BorderLayout.CENTER);

	TimeTextBox = new JLabel();
    TimeTextBox.setText("Set a Time");//puts word down
    TimeBox.add(TimeTextBox,BorderLayout.CENTER);


    textField = new JTextField(1); //creates the text field where the user enters the time
    TimeBox.add(textField,BorderLayout.CENTER);
	
	JButton StartButton = new JButton("Set"); //creates a button to set the time
	StartButton.addActionListener(this);
	TimeBox.add(StartButton);//adds the buttons

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Crocker's Control");
	frame.pack();
	frame.setVisible(true);

    TimeInBox = textField.getText();


    }


    public static void main(String[] args) {
	
		//new CrockerControlFrame();
        //System.out.println(TimeInBox);


	}

    public static int GetTimeInBox() {//getter to get TimeInBox Value
        return Integer.parseInt(TimeInBox);
    }
    public void SetTimeInBox() {//setter to get TimeInBox Value
        TimeInBox = textField.getText();
    }


    @Override
    public void actionPerformed(ActionEvent e) { //button to call the setter 
        SetTimeInBox();
	}
}
