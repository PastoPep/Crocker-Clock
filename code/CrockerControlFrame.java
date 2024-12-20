import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

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
    JPanel AddButtonPanel;
    JPanel SetSpeedButtonPanel;
    JPanel SetTimeButtonPanel;
    JPanel setSpeedTextFieldPanel;
    JLabel TimeTextBox;


    JLabel TimeTextBox2;
    JTextField setTimeField;
    JTextField setSpeedField;
    JTextField setSpeedFieldTwo;
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
    Font font;


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
        // FONT IMPLEMENTATION
        try {
            File FontFile = new File("Anton-Regular.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, FontFile);
        } catch(Exception e) {
   
        }



        ClockDown = updateClocky();
        frame = new JFrame("Crocker's Control"); //Application Control Window


        // MAIN FRAME
        panel = new JPanel();//Main frame
        panel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel,BorderLayout.CENTER);//add main frame/panel to the frame

        // CLOCK FRAME
        Clockpanel = new JPanel(); //Panel that contains the real clock
        panel.add(Clockpanel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2,1,0,-10));
        clocky = new RoundedLabel();
        clocky.setText("00:00:00");
        clocky.setPreferredSize(new Dimension(525, 200));
        blackline = BorderFactory.createLineBorder(Color.black); // Border
        clocky.setBorder(blackline); // Border
        // clocky.setFont(new Font("Anton-Regular", Font.BOLD, 95));
        clocky.setFont(font.deriveFont(Font.PLAIN, 95));
        clocky.setHorizontalAlignment(SwingConstants.CENTER);
        clocky.setForeground(Color.WHITE);
        clocky.setBackground(new Color(56, 182, 255));


        clocky.setText(updateClockLabel()); // updates text
        Clockpanel.add(clocky,BorderLayout.CENTER); // add to the panel  


        // CONTROL PANEL
        TimeBox = new JPanel(); //Panel that contains the Set Time
        TimeBox.setBorder(BorderFactory.createEmptyBorder(30,20,50,20));
        TimeBox.setLayout(new GridLayout(2,2,30,50));
        panel.add(TimeBox,BorderLayout.CENTER);



        AddButtonPanel = new RoundedPanel();
        AddButtonPanel.setLayout(new GridLayout(1,2,-50,0));
        AddButtonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        AddButtonPanel.setOpaque(false);
       
        SetTimeButtonPanel = new RoundedPanel();
        SetTimeButtonPanel.setLayout(new GridLayout(1,2,-50,0));
        SetTimeButtonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        SetTimeButtonPanel.setOpaque(false);




        SetSpeedButtonPanel = new JPanel();
        SetSpeedButtonPanel.setLayout(new GridLayout(1,2,-50,0));
        SetSpeedButtonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        SetSpeedButtonPanel.setOpaque(false);


        setSpeedTextFieldPanel = new JPanel();
        setSpeedTextFieldPanel.setLayout(new GridLayout(2,1,0,0));
        setSpeedTextFieldPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        setSpeedTextFieldPanel.setOpaque(false);



        // SET TIME - TEXT LABEL
        // TimeTextBox = new JLabel();
        // TimeTextBox.setText("Set a Time");//Adds a to-do label
        // TimeBox.add(TimeTextBox,BorderLayout.WEST);


        // BUTTON (SET THE ACTUAL TIME)
        JButton SetTimeButton = new RoundedButton("SET TIME"); //creates a button to set the time
        SetTimeButton.addActionListener(this);
        SetTimeButton.setFont(new Font("Arial", Font.BOLD, 25));
        SetTimeButton.setForeground(Color.BLACK);
        SetTimeButton.setBackground(new Color(56, 182, 255));
        SetTimeButton.setPreferredSize(new Dimension(200, 70));
        SetTimeButtonPanel.add(SetTimeButton);//adds the buttons



        // SET TIME (TEXT BOX)

        setTimeField = new RoundJTextField(9); //creates the text field where the user enters the time
        setTimeField.setPreferredSize(new Dimension(5,20));
        setTimeField.setText("0");
        setTimeField.setForeground(Color.BLACK);
        setTimeField.setFont(new Font("Arial", Font.BOLD, 25));
        setTimeField.setBackground(new Color(166,166,166));
        setTimeField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        setTimeField.setHorizontalAlignment(JTextField.CENTER);
        SetTimeButtonPanel.add(setTimeField);
        TimeBox.add(SetTimeButtonPanel);

        JButton AddButton = new RoundedButton("ADD TIME"); //creates a button to set the time
        AddButton.addActionListener(this);
        AddButton.setFont(new Font("Arial", Font.BOLD, 25));
        AddButton.setForeground(Color.BLACK);
        AddButton.setBackground(new Color(56, 182, 255));
        AddButton.setPreferredSize(new Dimension(200, 70));
        //AddTimeBox.add(AddButton);//adds the add time buttons
        AddButtonPanel.add(AddButton,BorderLayout.CENTER);
        AddTextField = new RoundJTextField(9); //creates the text field where the user enters the time
        AddTextField.setText("0");
        AddTextField.setForeground(Color.BLACK);
        AddTextField.setFont(new Font("Arial", Font.BOLD, 25));
        AddTextField.setPreferredSize(new Dimension(5,20));
        AddTextField.setBackground(new Color(166,166,166));
        AddTextField.setHorizontalAlignment(JTextField.CENTER);
        AddTextField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        //AddTimeBox.add(AddTextField,BorderLayout.CENTER);
        AddButtonPanel.add(AddTextField,BorderLayout.CENTER);
        TimeBox.add(AddButtonPanel);

        // SET SPEED - TEXT LABEL
        // TimeTextBox2 = new JLabel();
        // TimeTextBox2.setText("Set the speed (1 is default)");//Adds a second label
        // TimeBox.add(TimeTextBox2,BorderLayout.CENTER); // Adds the SECOND label after the field


        // BUTTON (SET THE SPEED)
        JButton SetSpeedButton = new RoundedButton("DELAY"); //creates a button to set the SPEED
        SetSpeedButton.addActionListener(this);
        SetSpeedButton.setFont(new Font("Arial", Font.BOLD, 25));
        SetSpeedButton.setForeground(Color.BLACK);
        SetSpeedButton.setBackground(new Color(56, 182, 255));
        SetSpeedButton.setPreferredSize(new Dimension(200, 70));
        SetSpeedButtonPanel.add(SetSpeedButton);//adds the buttons


        // TEXT BOX (INPUT)
        setSpeedField = new RoundJTextField(4); //creates the text field where the user enters the SPEED
        setSpeedField.setText("1");
        setTimeField.setForeground(Color.BLACK);
        setSpeedField.setFont(new Font("Arial", Font.BOLD, 25));
        setSpeedField.setPreferredSize(new Dimension(3,20));
        setSpeedField.setBackground(new Color(166,166,166));
        setSpeedField.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        setSpeedField.setHorizontalAlignment(JTextField.CENTER);
        setSpeedTextFieldPanel.add(setSpeedField);
        setSpeedFieldTwo = new RoundJTextField(4); //creates the text field where the user enters the SPEED
        setSpeedFieldTwo.setText("1");
        setSpeedFieldTwo.setForeground(Color.BLACK);
        setSpeedFieldTwo.setFont(new Font("Arial", Font.BOLD, 25));
        setSpeedFieldTwo.setPreferredSize(new Dimension(3,20));
        setSpeedFieldTwo.setBackground(new Color(166,166,166));
        setSpeedFieldTwo.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        setSpeedFieldTwo.setHorizontalAlignment(JTextField.CENTER);
        setSpeedTextFieldPanel.add(setSpeedFieldTwo);
        SetSpeedButtonPanel.add(setSpeedTextFieldPanel);
        TimeBox.add(SetSpeedButtonPanel);
   

        // CONTROL APP. FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Crocker's Control");
        frame.pack();
        frame.setVisible(true);


    // SetTextField = new JTextField(1); //creates the text field where the user enters the time
    // TimeBox.add(SetTextField,BorderLayout.CENTER);


    /* //SET TIME
     *  using for Seperation of code
     */ //ADD TIME


    //  AddTimeBox = new JPanel(); //Panel that contains the Set Time
    //  AddTimeBox.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
    //  AddTimeBox.setLayout(new GridLayout(0,1));
    //  //panel.add(AddTimeBox,BorderLayout.CENTER);
    //  TimeBox.add(AddTimeBox,BorderLayout.CENTER);

 
    //  AddTimeTextBox = new JLabel();
    //  AddTimeTextBox.setText("Add Time to the timer");//puts word down
    //  //AddTimeBox.add(AddTimeTextBox,BorderLayout.CENTER);
    //  TimeBox.add(AddTimeTextBox,BorderLayout.CENTER);
 


    /* //ADD TIME
     *  using for Seperation of code
     */ //Buttons


    TimeInBox = setTimeField.getText();
    SpeedInTextBox = setTimeField.getText();

    // TimeInBox = SetTextField.getText();
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
        return String.format("%02d:%02d:%02d", timeInHour, timeInDisplayedMinute, timeInSecond);
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

            ClockDown.schedule(timerTaskObj, 0, 1000/(CrockerControlFrame.getSpeed()));//delays in ms
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


        @Override
        public void actionPerformed(ActionEvent e) { //button to call the setter
   
            if(e.getActionCommand().equals("SET TIME")) {
                SetTimeInBox();
            } else if (e.getActionCommand().equals("DELAY")) {
                SetSpeedInBox();
                speed = GetSpeedInTextBox();
   
   
                if(CrockerClockFrame.isRunning()) {
                    CrockerClockFrame.ClockDown.cancel();
                    CrockerClockFrame.ClockDown = CrockerClockFrame.updateClocky();
                }
               
            } else if (e.getActionCommand().equals("ADD TIME")) {
                SetTimeInAddBox();
            }
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

    public class RoundedLabel extends JLabel {

        public RoundedLabel() {
            super();
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
    public class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        protected void paintComponent(Graphics g) {
             g.setColor(getBackground());
             g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 51, 51);
             super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
             g.setColor(getForeground());
             g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 51, 51);
        }
        public boolean contains(int x, int y) {
             if (shape == null || !shape.getBounds().equals(getBounds())) {
                 shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             }
             return shape.contains(x, y);
        }
    }
}
