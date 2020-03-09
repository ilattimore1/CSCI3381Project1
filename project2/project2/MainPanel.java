package project2;

import java.awt.*;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit.PasteAction;

import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileSystemView;

public class MainPanel extends JPanel {
	   private ReboundPanel imagePanel;
	   private JMenuBar menuBar;
	   private JMenu menu;
	   private JMenuItem i1, i2;
	   private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	   private PatientCollection myPats;
	   private JLabel patientData;	   
	   private final ButtonGroup buttonGroup = new ButtonGroup();
	   private String result;
	   private JScrollPane scrollPane;
	   
	   //Sets up MainPanel
	   public MainPanel()
	   {
		   setBackground(new Color(255, 248, 220));
		   setPreferredSize(new Dimension(1000, 1000));
		   setLayout(null);
		   
		   //initializes myPats from file
		   myPats = new PatientCollection("./data.csv");

		   //adds image to panel
	      imagePanel = new ReboundPanel(WIDTH/2,HEIGHT);
	      imagePanel.setBounds(692, -35, 374, 781);
	      add(imagePanel);
	      imagePanel.setLayout(null);
	      
	      //Set up menubar
	      menuBar = new JMenuBar();
	      menuBar.setFont(new Font("Monaco", Font.PLAIN, 17));
	      menuBar.setToolTipText("File");
	      menuBar.setBounds(0, 0, 720, 22);
	      //adds menu to panel
	      add(menuBar);
	      
	      //adds menu items to menu
          menu=new JMenu("File");  
          i1=new JMenuItem("Add Patient from file");  
          i2=new JMenuItem("Save");  
          menuBar.add(menu);
          menu.add(i1); menu.add(i2);  
          
	      //add patient from file
          i1.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
            	  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        		  int returnValue = jfc.showOpenDialog(null);  
        		  if (returnValue == JFileChooser.APPROVE_OPTION) {
            			File selectedFile = jfc.getSelectedFile();
            			myPats.addPatientsFromFile(""+selectedFile);
        		  }
        	  }
          });
          
          //save file
          i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPats.doWrite("./data.csv");
			}
		});
          
          //label to select patient by id
          lblNewLabel = new JLabel("Select Patient ID:");
          lblNewLabel.setFont(new Font("Phosphate", Font.PLAIN, 26));
          lblNewLabel.setBounds(6, 90, 246, 56);
          //adds label
          add(lblNewLabel);
          
          //add patientData to show patient data to user
          Patient aPat = myPats.getPatient("1");
          patientData = new JLabel(aPat.toString());
          patientData.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
          patientData.setBounds(178, 272, 532, 34);
          //patient data to combo box
          add(patientData);
          
          //combo box to show list of ids
          JComboBox comboBox = new JComboBox();
          comboBox.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
          		Patient aPat = myPats.getPatient((String) comboBox.getSelectedItem());
          		patientData.setText(aPat.toString());
          	}
          });
          
          ArrayList<String> ids = myPats.getIds();
          comboBox.setModel(new DefaultComboBoxModel(ids.toArray()));
          comboBox.setBounds(236, 87, 179, 68);
          add(comboBox);
          
          //add label show patient data to user
          lblNewLabel_1 = new JLabel("Patient:");
          lblNewLabel_1.setFont(new Font("Phosphate", Font.PLAIN, 25));
          lblNewLabel_1.setBounds(71, 276, 120, 24);
          add(lblNewLabel_1);
          
          //label to set results for patient
          lblNewLabel_1 = new JLabel("Results");
	      lblNewLabel_1.setFont(new Font("SignPainter", Font.BOLD, 60));
	      lblNewLabel_1.setBounds(90, 550, 149, 48);
	      imagePanel.add(lblNewLabel_1);
          
	      //radio button for CR
	      JRadioButton rdbtnNewRadioButton = new JRadioButton("CR");
	      rdbtnNewRadioButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		result = "CR";
	      	}
	      });
	      buttonGroup.add(rdbtnNewRadioButton);
	      rdbtnNewRadioButton.setBounds(190, 610, 141, 23);
	      imagePanel.add(rdbtnNewRadioButton);
          
          //radio button for DP
	      JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("DP");
	      rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		result = "DP";
	      	}
	      });
	      buttonGroup.add(rdbtnNewRadioButton_1);
	      rdbtnNewRadioButton_1.setBounds(190, 637, 141, 23);
	      imagePanel.add(rdbtnNewRadioButton_1);
	      
	      //button to set results
	      JButton btnNewButton = new JButton("Set Results");
	      btnNewButton.setFont(new Font("Phosphate", Font.PLAIN, 16));
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
          		String id = (String) comboBox.getSelectedItem();
	      		myPats.setResultForPatient(id, result);
	      	}
	      });
	      btnNewButton.setBounds(25, 620, 130, 40);
	      imagePanel.add(btnNewButton);
	      
	      //remove patients from selected patient in combo box
	      JButton btnNewButton_1 = new JButton("Remove Patient");
	      btnNewButton_1.setFont(new Font("Phosphate", Font.PLAIN, 17));
	      btnNewButton_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
          		String id = (String) comboBox.getSelectedItem();
          		myPats.removePatient(id);
	      	}
	      });
	      btnNewButton_1.setBounds(275, 333, 154, 50);
	      add(btnNewButton_1);
		  
	      //label list of patients
		  lblNewLabel_2 = new JLabel("List of Patients");
		  lblNewLabel_2.setFont(new Font("SignPainter", Font.PLAIN, 25));
		  lblNewLabel_2.setBounds(293, 443, 129, 34);
		  add(lblNewLabel_2);
		  
		  //add scroll pane
		  scrollPane = new JScrollPane();
		  scrollPane.setBounds(178, 488, 372, 197);
		  add(scrollPane);
		  
		  //Text area of patients
		  JTextArea textArea = new JTextArea(myPats.toString());
		  scrollPane.setViewportView(textArea);

	   }
}
