import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GUI extends JFrame {
    JList studList1, dormList1;
    JLabel openFileLabel, studList1Label, dormList1Label, roomListLabel;
    JLabel nameLabel, genderLabel, gradeLabel, roomLabel, dormLabel;
    JFileChooser chooser;
    JButton openFileButton, returnToHousingButton, pairNewStudentsButton, pairReturningStudentsButton;
    static JPanel p = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    JSeparator s1,s2,s3;
    JScrollPane studentScrollList, dormScrollList, roomDataScrollList;
    File studentDataFile,dormDataFile;

    private void initializeDataInputScreenComponents(){
        s1 = new JSeparator(SwingConstants.HORIZONTAL);
        c.gridy = 0;

        chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooser.setDialogTitle("Select a file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        openFileLabel = new JLabel("Please select a properly-formatted CSV file containing Student Data");
        openFileButton = new JButton("Select File");
        openFileButton.addActionListener(e -> {
            if(studentDataFile != null){
                dormDataFile = openFile();
                clearDataInputScreen();
            }else{
                studentDataFile = openFile();
                openFileLabel.setText("Now, please select a properly-formatted CSV file containing Dorm Data");
                p.revalidate();
            }
        });
        p.add(openFileLabel,c);
        c.gridy = 1;
        p.add(s1,c);
        c.gridy=2;
        p.add(openFileButton,c);
        c.gridy = -2;
    }







    private void initializeHousingScreen(){
        Core cr = new Core();
        Object[] studOb = cr.getSTUDENTS().toArray();
        String[] studStr = new String[studOb.length];
        int i = 0;
        for (Object o : studOb) {
            try {
                Student s = (Student) o;
                studStr[i] = s.toString();
            } catch (Exception e) {
                StudentPair s = (StudentPair) o;
                studStr[i] = s.toString();
            }
            i++;
        }

        studList1 = new JList(studStr);
        dormList1 = new JList(cr.getDORMS().toArray());

        studList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Core x = new Core();
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if (evt.getClickCount() == 2) {
                        studentDataScreen(x.getSTUDENTS().get(index));
                }
            }
        });
        dormList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if (evt.getClickCount() == 2) {
                    dormDataScreen((Dorm) list.getModel().getElementAt(index));
                }
            }
        });
        studentScrollList = new JScrollPane(studList1);
        dormScrollList = new JScrollPane(dormList1);


        dormScrollList.setPreferredSize(new Dimension(200,300));
        studentScrollList.setPreferredSize(new Dimension(200,300));
        studentScrollList.setFont(new Font("Arial",Font.BOLD,180));
        dormScrollList.setFont(new Font("Arial",Font.BOLD,180));

        c.gridy = 0;

        studList1Label = new JLabel("List of Students");
        dormList1Label = new JLabel("List of Dorms");
        s2 = new JSeparator(SwingConstants.HORIZONTAL);

        //p.add(s2,c);
        c.gridy = 0;
        c.gridx = 0;
        p.add(studList1Label,c);
        c.gridx++;
        p.add(dormList1Label,c);
        c.gridy = 2;
        c.gridx = 0;
        p.add(studentScrollList,c);
        c.gridx = 1;
        p.add(dormScrollList,c);
        p.revalidate();
    }









    private void dormDataScreen(Dorm o){
        System.out.println("in dorm");
        p.removeAll();
        p.repaint();
        p.revalidate();
        JList roomList = new JList(o.getAllRooms().toArray());
        roomList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if (evt.getClickCount() == 2) {
                    roomDataScreen((Room) list.getModel().getElementAt(index));
                }
            }
        });

        returnToHousingButton = new JButton("Return to Housing");
        returnToHousingButton.addActionListener(e -> {
            p.removeAll();
            p.repaint();
            p.revalidate();
            initializeHousingScreen();
        });
        roomDataScrollList = new JScrollPane(roomList);
        roomDataScrollList.setPreferredSize(new Dimension(200,300));
        roomDataScrollList.setFont(new Font("Arial",Font.BOLD,180));
        roomListLabel = new JLabel("List of Rooms");
        JSeparator s3 = new JSeparator(SwingConstants.HORIZONTAL);
        c.gridy = 0;
        c.gridx = 0;
        p.add(returnToHousingButton,c);
        c.gridy = 1;
        p.add(roomListLabel,c);
        c.gridy = 2;
        p.add(s3,c);
        c.gridy = 3;
        p.add(roomDataScrollList,c);
        p.revalidate();

    }







    private void studentDataScreen(Student o){
        p.removeAll();
        p.repaint();
        returnToHousingButton = new JButton("Return to Housing");
        returnToHousingButton.addActionListener(e -> {
            p.removeAll();
            p.repaint();
            p.revalidate();
            initializeHousingScreen();
        });
        nameLabel = new JLabel("Student ID: "+o.toString());
        dormLabel = new JLabel("Dorm: "+o.getCurDorm().toString());
        roomLabel = new JLabel("Room: "+o.getCurRoom().toString());
        genderLabel = new JLabel("Gender: "+o.getGender());
        gradeLabel = new JLabel("Grade: "+Integer.toString(o.getGrade()));
        s3 = new JSeparator(SwingConstants.HORIZONTAL);
        c.gridy = 0;
        c.gridx = 0;
        p.add(returnToHousingButton,c);
        c.gridy = 1;
        p.add(nameLabel,c);
        c.gridy = 2;
        p.add(dormLabel,c);
        c.gridy = 3;
        p.add(roomLabel,c);
        c.gridy = 4;
        p.add(genderLabel,c);
        c.gridy = 5;
        p.add(gradeLabel,c);
        p.revalidate();
    }

    private void studentDataScreen(StudentPair o){
        p.removeAll();
        p.repaint();
        System.out.println("gg");
        returnToHousingButton = new JButton("Return to Housing");
        returnToHousingButton.addActionListener(e -> {
            p.removeAll();
            p.repaint();
            p.revalidate();
            initializeHousingScreen();
        });
        nameLabel = new JLabel("Student IDs: "+o.getNames());
        dormLabel = new JLabel("Dorm: "+o.getCurDorm().toString());
        roomLabel = new JLabel("Room: "+o.getCurRoom().toString());
        genderLabel = new JLabel("Gender: "+o.getGender());
        gradeLabel = new JLabel("Grade: "+Integer.toString(o.getGrade()));
        s3 = new JSeparator(SwingConstants.HORIZONTAL);
        c.gridy = 0;
        c.gridx = 0;
        p.add(returnToHousingButton,c);
        c.gridy = 1;
        p.add(nameLabel,c);
        c.gridy = 2;
        p.add(dormLabel,c);
        c.gridy = 3;
        p.add(roomLabel,c);
        c.gridy = 4;
        p.add(genderLabel,c);
        c.gridy = 5;
        p.add(gradeLabel,c);
        p.revalidate();

    }


    private void roomDataScreen(Room o){
        System.out.println("i");
        p.removeAll();
        p.repaint();
        JList residentList = new JList(o.getResidents().toArray());
        residentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if (evt.getClickCount() == 2) {
                    try {
                        studentDataScreen((Student) list.getModel().getElementAt(index));
                    } catch (Exception e) {
                        studentDataScreen((StudentPair) list.getModel().getElementAt(index));
                    }
                }
            }
        });
        s3 = new JSeparator(SwingConstants.HORIZONTAL);
        returnToHousingButton = new JButton("Return to Housing");
        returnToHousingButton.addActionListener(e -> {
            p.removeAll();
            p.repaint();
            p.revalidate();
            initializeHousingScreen();
        });
        roomDataScrollList = new JScrollPane(residentList);
        roomDataScrollList.setPreferredSize(new Dimension(200,300));
        roomDataScrollList.setFont(new Font("Arial",Font.BOLD,180));
        roomListLabel = new JLabel("List of Residents");

        c.gridy = 0;
        c.gridx = 0;
        p.add(returnToHousingButton,c);
        c.gridy = 1;
        p.add(roomListLabel,c);
        c.gridy = 2;
        p.add(s3,c);
        c.gridy = 3;
        p.add(roomDataScrollList,c);
        p.revalidate();

    }










    private void clearDataInputScreen() {
        p.removeAll();
        p.revalidate();
        p.repaint();
        initializeHousingScreen();
    }










    GUI() { //do not rename or everything will catastrophically break thank you very much//gbl is layout manager for JPanel, much better than traditional layout
        FlatDarkLaf.setup();
        p.setBackground(new Color(44,44,60,255));


        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        c.gridy = 0;
        setTitle("Student Housing Panel");
        setSize(800,500);               //basic panel setup
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initializeDataInputScreenComponents();
        initializeHousingScreen();

        //dataInputPanel.add(scrollableList, c);
        add(p,BorderLayout.CENTER);
        setVisible(true);

    }









    private File openFile() {
        int returnVal = chooser.showOpenDialog(GUI.this);
        //dataInputPanel.add(chooser,c);
        //dataInputPanel.revalidate();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //dataInputPanel.remove(chooser);
            //dataInputPanel.revalidate();
            return chooser.getSelectedFile();
        } else {
            //dataInputPanel.remove(chooser);
            //dataInputPanel.revalidate();
            return null;
        }
    }


}