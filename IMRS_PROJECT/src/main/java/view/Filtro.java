package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import enums.CommitType;




public class Filtro extends JFrame {

    private JPanel contentPane;
    private final ButtonGroup btgMetrica = new ButtonGroup();
    private JTextField txtfCommitName;
    private JLabel lblImrsProject;
    private JPanel panelMetrica;
    private JLabel lblMetrica;
    private JRadioButton rdbtnAcoplamentoAferente;
    private JRadioButton rdbtnAcoplamentoEferente;
    private JPanel panelRange;
    private JLabel lblRange;
    private JComboBox comboBox;
    private JPanel panelSpecificCommit;
    private JLabel lblHashDoCommit;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Filtro frame = new Filtro();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Filtro() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 775, 450);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblImrsProject = new JLabel("IMRS_PROJECT");
	lblImrsProject.setHorizontalAlignment(SwingConstants.CENTER);
	lblImrsProject.setFont(new Font("Bell MT", Font.BOLD, 40));
	lblImrsProject.setBounds(221, 16, 315, 56);
	contentPane.add(lblImrsProject);
	
	panelMetrica = new JPanel();
	panelMetrica.setBounds(0, 88, 376, 150);
	contentPane.add(panelMetrica);
	panelMetrica.setLayout(null);
	
	lblMetrica = new JLabel("M\u00E9trica:");
	lblMetrica.setBounds(36, 16, 74, 27);
	panelMetrica.add(lblMetrica);
	lblMetrica.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	
	
	rdbtnAcoplamentoAferente = new JRadioButton("Acoplamento Aferente");
	btgMetrica.add(rdbtnAcoplamentoAferente);
	rdbtnAcoplamentoAferente.setBounds(46, 51, 187, 29);
	panelMetrica.add(rdbtnAcoplamentoAferente);
	rdbtnAcoplamentoAferente.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	
	rdbtnAcoplamentoEferente = new JRadioButton("Acoplamento Eferente");
	btgMetrica.add(rdbtnAcoplamentoEferente);
	rdbtnAcoplamentoEferente.setBounds(46, 81, 187, 29);
	panelMetrica.add(rdbtnAcoplamentoEferente);
	rdbtnAcoplamentoEferente.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	
	panelRange = new JPanel();
	panelRange.setBounds(377, 88, 376, 56);
	contentPane.add(panelRange);
	panelRange.setLayout(null);
	
	lblRange = new JLabel("Range:");
	lblRange.setBounds(16, 15, 69, 25);
	panelRange.add(lblRange);
	lblRange.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	
	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(CommitType.values()));
	comboBox.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent arg0) {
		if(comboBox.getSelectedItem() == CommitType.getByCodigo(1)){
		    panelSpecificCommit.setVisible(Boolean.FALSE);
		}
		if(comboBox.getSelectedItem() == CommitType.getByCodigo(2)){
		    panelSpecificCommit.setVisible(Boolean.TRUE);
		}
		
	    }
	});
	comboBox.setBounds(87, 16, 239, 26);
	panelRange.add(comboBox);
	
	panelSpecificCommit = new JPanel();
	panelSpecificCommit.setVisible(Boolean.FALSE);
	panelSpecificCommit.setBounds(377, 144, 376, 94);
	contentPane.add(panelSpecificCommit);
	panelSpecificCommit.setLayout(null);
	
	lblHashDoCommit = new JLabel("Commit:");
	lblHashDoCommit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	lblHashDoCommit.setBounds(15, 16, 131, 20);
	panelSpecificCommit.add(lblHashDoCommit);
	
	txtfCommitName = new JTextField();
	txtfCommitName.setBounds(94, 13, 235, 26);
	panelSpecificCommit.add(txtfCommitName);
	txtfCommitName.setColumns(10);
	
	btnNewButton = new JButton("Minerar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnNewButton.setBounds(301, 307, 150, 40);
	contentPane.add(btnNewButton);
    }
}
