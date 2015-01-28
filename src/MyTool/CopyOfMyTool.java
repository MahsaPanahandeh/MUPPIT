package MyTool;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.Scanner; 








import org.eclipse.epsilon.common.util.StringUtil;

import javax.swing.JFileChooser;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.epl.EplModule;//
import org.eclipse.epsilon.eol.execute.context.IEolContext;//
import org.eclipse.epsilon.eol.userinput.IUserInput;//

import MyTool.epl.EplCodes;

public class CopyOfMyTool {
	
	private JFrame mainFrame;
	private JFrame mainFrame2;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel2;
	   private JLabel modelLabel;
	   private JLabel metamodelLabel;
	   private JLabel inputmodelLabel;
	   private JLabel inputMetamodelLabel;
	   private JPanel controlPanelup;
	   private JPanel controlPanelcenter;
	   private JPanel controlPaneldown;
	   private JPanel controlPanel;
	   private JPanel mainPanel;
	   
	 
	   private String modelPath;
	   private String metaModelPath;
	   private String inputModelPath;
	   private String inputMetamodelPath;
	   
	   
	 
	   public static void main(String[] args)throws Exception{
		   

		      CopyOfMyTool  swingControlDemo = new CopyOfMyTool();      
		     swingControlDemo.selectComboboxDemo();
		      
		     
		   }
	 
		
		////////////////////////////////////////////////////////////////////////
	   
	  
	   
	   private  void  selectComboboxDemo(){    
		   //open jframe
		   mainFrame2 = new JFrame("CeDePAP");
		      mainFrame2.setSize(400,400);
		      mainFrame2.setLayout(new GridLayout(3, 1));
		      mainFrame2.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
		         }        
		      });    
		      controlPanel2 = new JPanel();
		      controlPanel2.setLayout(new FlowLayout());
		      mainFrame2.add(controlPanel2);
//-----------------------------------		      
		      headerLabel = new JLabel("", JLabel.CENTER);        
		     headerLabel.setText("List of Model Transformation Patterns:"); 
		     controlPanel2.add(headerLabel);
		      final DefaultComboBoxModel patternsName = new DefaultComboBoxModel();

		      patternsName.addElement("Phased construction");
		      patternsName.addElement("Filtering");
		      patternsName.addElement("Object indexing");
		      patternsName.addElement("Multiple matching");
		      patternsName.addElement("Usage of Iteration");
		      patternsName.addElement("Short Circuit Boolean");
		      patternsName.addElement("Auxiliary models");

		      final JComboBox patternCombo = new JComboBox(patternsName); 
		      patternCombo.setSelectedIndex(0);

		      JScrollPane patternListScrollPane = new JScrollPane(patternCombo);    

		      controlPanel2.add(patternCombo);
		      ///////////////////////////////////////////////////////
		      JButton selectButton = new JButton("Select");
		      controlPanel2.add(selectButton);
		      	//action on patterns
		      selectButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) { 
		        	 
		        	 if(patternCombo.getItemAt(patternCombo.getSelectedIndex())=="Phased construction")
		        	 {
		        		 mainFrame = new JFrame("CeDePAP");
		   		      mainFrame.setSize(550,150);
		   		      mainFrame.setLayout(new GridLayout(1,1));
		   		      mainFrame.addWindowListener(new WindowAdapter() {
		   		         public void windowClosing(WindowEvent windowEvent){
		   		            System.exit(0);
		   		         }        
		   		      });    
		   		      //This will center the JFrame in the middle of the screen 
		   		     // mainFrame.setLocationRelativeTo(null);
		   		      
		   		     
		   		       mainPanel = new JPanel(new BorderLayout());
		   		       controlPanel = new JPanel();
		   		      controlPanelup = new JPanel();
		   		      controlPanelcenter = new JPanel();
		   		      controlPaneldown = new JPanel();
		   		      
		   		  
		   		      controlPanelup.setLayout(new FlowLayout(FlowLayout.LEADING));
		   		      controlPanelcenter.setLayout(new FlowLayout(FlowLayout.LEADING));
		   		      controlPaneldown.setLayout(new FlowLayout(FlowLayout.LEADING));
		   		      mainFrame.add(mainPanel);
		   		      
		   		     	      
		   		      
		   		     
		   		  	      
		   		   //  ---------------------------------------------------------------------------
		   		     //for metamodel
		   		      metamodelLabel = new JLabel("");
		   		      metamodelLabel.setText("Select The MetaModel of Transformation Model:");
		   		
		   		      
		   		      JButton b1Button = new JButton("Browse File");
		   		      b1Button.addActionListener(new ActionListener() {
		   			         public void actionPerformed(ActionEvent e) {
		   			        	 JFileChooser chooser1 = new JFileChooser();
		   			     		if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		   			     	         metaModelPath= chooser1.getSelectedFile().toString();//this is destination of our file+its name
		   			     	        //statusLabel.setText(str);
		   			     	        //System.out.print(str);
		   			     	      } 
		   			     		else {
		   			     	        System.out.println("No Selection ");
		   			     	      }
		   			         }
		   			         
		   			         });
		   		     //---------------------------------------------------- 
		   		      //for model
		   		      modelLabel = new JLabel("");
		   		      modelLabel.setText("Select Transformation Model:"); 
		   		   
		   		      
		   		      JButton b2Button = new JButton("Browse File");
		   		      b2Button.addActionListener(new ActionListener() {
		   			         public void actionPerformed(ActionEvent e) {
		   			        	 JFileChooser chooser2 = new JFileChooser();
		   			     		if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		   			     	         modelPath= chooser2.getSelectedFile().toString();//this is destination of our file+its name
			   			     	      
		   			     	        //System.out.print(str);
		   			     	      } 
		   			     		else {
		   			     	        System.out.println("No Selection ");
		   			     	      }
		   			         }
		   			         
		   			         });
		   		      controlPanelup.add(metamodelLabel);
				      controlPanelup.add(b1Button);
				      
				      controlPanelcenter.add(modelLabel);
				      controlPanelcenter.add(b2Button);
				      
				      mainPanel.add(controlPanelup, BorderLayout.NORTH);
				      mainPanel.add(controlPanelcenter, BorderLayout.CENTER);
				      ///////////////////////////////////////////////////////////////
				      JButton nextButton = new JButton("Next");
				      controlPanel.add(nextButton);
				      mainPanel.add(controlPanel, BorderLayout.EAST);
				      nextButton.addActionListener(new ActionListener() {
					         public void actionPerformed(ActionEvent e) {
					        	 try {
					        			// EolModule module = new EolModule();
					        			// module.parse("System.user.prompt('1+1=?').println();");
					        			// module.execute();
					        		 
					        			 new EplCodes("model/mapping.model","model/mappings2.ecore","epl/pattern1.epl").execute();
										//eplcodes.execute();
					        			 
					        		 	}
					        		 catch (Exception e1) 
					        		 {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									 }
					        	 try{
					        		 new EplCodes("model/mapping.model","model/mappings2.ecore","epl/pattern.epl").execute();
					        	 }
					        	 catch (Exception e1) 
				        		 {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								 }
					        	 
					         }
					         
					         });
				     
				      mainFrame.setVisible(true);   
		        	 }
		         }
		      });
		      mainFrame2.setVisible(true);
 
		     
		         }
		      
	   
	   /////////////************???????????
	 
	
	
}

