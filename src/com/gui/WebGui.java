package com.gui;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static net.mindview.util.SwingConsole.*;
import com.web.WebContent1;

public class WebGui extends JFrame implements ActionListener,ItemListener{
	
	private JLabel labelDisplay;
	private JTextArea textAreaDisplay;
	private JTextField textFieldTip1;
	private JTextField textFieldTip2;
	private JComboBox comboPro;
	private JComboBox comboMonth;
	private JPanel panelAll;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JButton btnOK;
	private CustomImaPanel imgPanelLeft;
	private CustomImaPanel imgPanelRight;
	ExecutorService exec = Executors.newCachedThreadPool();
	public WebGui(){
		
		super("���Ŵ��˵�չ���ȡ����");
		ImageIcon icon = new ImageIcon("D:\\2.jpg");
		Image image = icon.getImage();
		
		this.setSize(800,600);
		this.setLocation(300,50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		int width =390;
		int height =590;
		String imgPath1="/image/1.jpg";
		String imgPath2="/image/2.jpg";
		panelLeft = new CustomImaPanel(width, height, imgPath1);
		panelRight = new CustomImaPanel(width, height, imgPath2);
	//	this.setIconImage(image);
	//	panelLeft = new JPanel(new GridLayout());
	//	panelRight = new JPanel(new GridBagLayout());
		panelRight.setLayout(new GridBagLayout());
		textAreaDisplay = new JTextArea();
		textAreaDisplay.setText("�װ��ģ�����ѡ��չ��ʡ�ݡ��ı�չ��ʡ�ݻἶ��Ӱ��\n�·�ѡ�������˵���Ŷ�ף�\n�����ʼ���ֱ�ӿ�ʼ�������ĵȴ�ֱ����ʾ�ɹ���");
		
	//	labelDisplay = new JLabel("�װ��ģ�����ѡ��չ��ʡ�ݡ�\n�ı�չ��ʡ�ݻἶ��Ӱ���·�ѡ�������˵���Ŷ�ף�");
	//	labelDisplay.setIcon(icon);
	//	panelLeft.add(imgPanelLeft);
	//	panelRight.add(imgPanelRight,-1);
		//labelDisplay.setText("�װ��ģ�����ѡ��չ��ʡ�ݡ�\n�ı�չ��ʡ�ݻἶ��Ӱ���·�ѡ�������˵���Ŷ�ף�");
		panelLeft.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill= GridBagConstraints.HORIZONTAL;
		gc.gridx=0;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.PAGE_START;
		panelLeft.add(textAreaDisplay,gc);
		this.add(panelLeft);
		this.add(panelRight);
		
		
		textFieldTip1 = new JTextField("��ѡ���չʡ�У�");
		textFieldTip2 = new JTextField("��ѡ���չ�·ݣ�");
		textFieldTip1.setEditable(false);
		textFieldTip2.setEditable(false);

		Object pros[] = {"����չ��","�Ϻ�չ��","����չ��"};
		Object month[] = {"1��չ��","2��չ��","3��չ��","4��չ��","5��չ��","6��չ��","7��չ��","8��չ��","9��չ��","10��չ��","11��չ��","12��չ��"};
		
		comboPro = new JComboBox(pros);
		comboMonth = new JComboBox(month);
		comboPro.addItemListener(this);
		comboMonth.addItemListener(this);
		
		btnOK = new JButton("��ʼ");
		btnOK.addActionListener(this);
		btnOK.setPreferredSize(new Dimension(20,20));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.1;
		c.insets=new Insets(10, 0, 0, 0);
		c.gridheight=1;
		c.gridwidth=2;
		panelRight.add(textFieldTip1,c);

		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
	
		c.gridheight=1;
		c.gridwidth=2;
		panelRight.add(comboPro,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		
		c.gridheight=1;
		c.gridwidth=2;
		panelRight.add(textFieldTip2,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		
		c.gridheight=1;
		c.gridwidth=2;
		panelRight.add(comboMonth,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		
		c.gridheight=1;
		c.gridwidth=2;
		//c.anchor=GridBagConstraints.PAGE_END;
		panelRight.add(btnOK,c);
		
		this.setVisible(true);
	}
	private void formComponentResized(ComponentEvent e){
		this.remove(imgPanelLeft);
	}
	public JTextArea getTextAreaDisplay() {
		return textAreaDisplay;
	}

	public void setTextAreaDisplay(JTextArea textAreaDisplay) {
		this.textAreaDisplay = textAreaDisplay;
	}

	public JTextField getTextFieldTip1() {
		return textFieldTip1;
	}

	public void setTextFieldTip1(JTextField textFieldTip1) {
		this.textFieldTip1 = textFieldTip1;
	}

	public JTextField getTextFieldTip2() {
		return textFieldTip2;
	}

	public void setTextFieldTip2(JTextField textFieldTip2) {
		this.textFieldTip2 = textFieldTip2;
	}

	public JComboBox getComboPro() {
		return comboPro;
	}

	public void setComboPro(JComboBox comboPro) {
		this.comboPro = comboPro;
	}

	public JComboBox getComboMonth() {
		return comboMonth;
	}

	public void setComboMonth(JComboBox comboMonth) {
		this.comboMonth = comboMonth;
	}

	public JPanel getPanelAll() {
		return panelAll;
	}

	public void setPanelAll(JPanel panelAll) {
		this.panelAll = panelAll;
	}

	public JPanel getPanelLeft() {
		return panelLeft;
	}

	public void setPanelLeft(JPanel panelLeft) {
		this.panelLeft = panelLeft;
	}

	public JPanel getPanelRight() {
		return panelRight;
	}

	public void setPanelRight(JPanel panelRight) {
		this.panelRight = panelRight;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public void actionPerformed (ActionEvent e){
		if(e.getSource()==btnOK){
			if(JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ����")==0)
			{
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						textAreaDisplay.setText("��ʼ��Ŷ�ף������ĵȴ������ȱ����Ȱɣ��¸£�");
					}
				});
				
				
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				try {
					
					exec.execute(new Runnable(){
						public void run(){
							String province =comboPro.getSelectedItem().toString();
							String month=comboMonth.getSelectedItem().toString();
							File file = new File("D:/file/text.xls");
							String htmlurl="http://www.eshow365.com/";
							WebContent1 wc = new WebContent1(null, htmlurl);
							try {
								wc.getContentGui(province, month,file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								SwingUtilities.invokeLater(new Runnable(){
									public void run(){
										textAreaDisplay.setText("�����쳣�ˣ��ף���������޷���ɣ�");
									}
								});
								return;
							}
							try {
								TimeUnit.SECONDS.sleep(5);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								
							}
							
							SwingUtilities.invokeLater(new Runnable(){
								public void run(){
									textAreaDisplay.setText("�ɹ��ˣ�ôô����һ����");
								}
							});
						}
					});
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	
	}
	public void itemStateChanged (ItemEvent e){
		if(e.getSource()==comboPro){
			if(comboPro.getSelectedIndex()==0){
				comboMonth.removeAllItems();
				String monthName = "";
				for(int i = 1;i<=12;i++){
					monthName =i+"��չ��";
					comboMonth.addItem(monthName);
				}
			}
			else if(comboPro.getSelectedIndex()==1){
				comboMonth.removeAllItems();
				String monthName = "";
				for(int i = 1;i<=12;i++){
					monthName ="�Ϻ�"+i+"��չ��";
					comboMonth.addItem(monthName);
				}
				
			}
			else {
				comboMonth.removeAllItems();
				String monthName = "";
				for(int i = 1;i<=12;i++){
					monthName =i+"��չ��";
					comboMonth.addItem(monthName);
				}
			}
		}
	}
	
	public static void main(String arges[]){
		run(new WebGui());
	}
	
}
