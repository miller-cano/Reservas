package vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

import logica.LReservas;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelReserva extends JPanel {
	private JTextField txt_Fecha;
	private JTextField txt_Nombre;
	private JTextField txt_Apellido;
	private JTextField txt_Cedula;
	private JTextField txt_Email;
	private JTextField txt_Celular;
	private JTextField txt_Ciudad;
	private JTextField txt_Hora;
	private JTextField txt_NroPersonas;

	/**
	 * Create the panel.
	 */
	public PanelReserva() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(0, 206, 209));
		add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("FORMULARIO RESERVA");
		lblNewLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		panelNorte.add(lblNewLabel);
		
		JPanel panelOeste = new JPanel();
		add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		add(panelEste, BorderLayout.EAST);
		
		JPanel panelSur = new JPanel();
		add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		panelCentro.add(separator_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(new Color(0, 0, 0));
		separator_5.setForeground(new Color(0, 0, 0));
		panelCentro.add(separator_5);
		
		JLabel lblNewLabel_11 = new JLabel("DATOS RESERVA:");
		panelCentro.add(lblNewLabel_11);
		
		JLabel lblNewLabel_15 = new JLabel("     ");
		panelCentro.add(lblNewLabel_15);
		
		JLabel lbl_Ciudad = new JLabel("Ciudad:");
		lbl_Ciudad.setAlignmentY(Component.TOP_ALIGNMENT);
		panelCentro.add(lbl_Ciudad);
		
		txt_Ciudad = new JTextField();
		panelCentro.add(txt_Ciudad);
		txt_Ciudad.setColumns(10);
		
		JLabel lbl_Fecha = new JLabel("Fecha (dd/mm/aaaa):");
		panelCentro.add(lbl_Fecha);
		
		txt_Fecha = new JTextField();
		panelCentro.add(txt_Fecha);
		txt_Fecha.setColumns(10);
		
		JLabel lbl_Hora = new JLabel("Hora (hh:mm):");
		panelCentro.add(lbl_Hora);
		
		txt_Hora = new JTextField();
		panelCentro.add(txt_Hora);
		txt_Hora.setColumns(10);
		
		JLabel lbl_NroPersonas = new JLabel("N\u00FAmero de personas:");
		panelCentro.add(lbl_NroPersonas);
		
		txt_NroPersonas = new JTextField();
		panelCentro.add(txt_NroPersonas);
		txt_NroPersonas.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBackground(new Color(0, 0, 0));
		panelCentro.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBackground(new Color(0, 0, 0));
		panelCentro.add(separator_4);
		
		JLabel lblNewLabel_5 = new JLabel("DATOS PERSONALES:");
		panelCentro.add(lblNewLabel_5);
		
		JLabel lblNewLabel_20 = new JLabel("     ");
		panelCentro.add(lblNewLabel_20);
		
		JLabel lbl_Nombre = new JLabel("Nombre:");
		panelCentro.add(lbl_Nombre);
		
		txt_Nombre = new JTextField();
		panelCentro.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		
		JLabel lbl_Apellido = new JLabel("Apellido:");
		panelCentro.add(lbl_Apellido);
		
		txt_Apellido = new JTextField();
		panelCentro.add(txt_Apellido);
		txt_Apellido.setColumns(10);
		
		JLabel lbl_Cedula = new JLabel("C\u00E9dula:");
		panelCentro.add(lbl_Cedula);
		
		txt_Cedula = new JTextField();
		panelCentro.add(txt_Cedula);
		txt_Cedula.setColumns(10);
		
		JLabel lbl_Email = new JLabel("E-mail:");
		panelCentro.add(lbl_Email);
		
		txt_Email = new JTextField();
		panelCentro.add(txt_Email);
		txt_Email.setColumns(10);
		
		JLabel lbl_Celular = new JLabel("Celular:");
		panelCentro.add(lbl_Celular);
		
		txt_Celular = new JTextField();
		panelCentro.add(txt_Celular);
		txt_Celular.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(new Color(0, 0, 0));
		panelCentro.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		panelCentro.add(separator);
		
		JLabel lblNewLabel_12 = new JLabel("     ");
		panelCentro.add(lblNewLabel_12);
		
		JButton btn_Reservar = new JButton("RESERVAR");
		btn_Reservar.setBackground(Color.ORANGE);
		btn_Reservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nroPersonas = 0;	
				String nombre = "", ciudad = "", hora = "", fecha = "", correo = "", cedula = "", cel = "";
				nroPersonas = Integer.parseInt(txt_NroPersonas.getText());
				nombre = txt_Nombre.getText() + " " + txt_Apellido.getText();
				ciudad = txt_Ciudad.getText();
				hora = txt_Hora.getText();
				fecha = txt_Fecha.getText();
				correo = txt_Email.getText();
				cedula = txt_Cedula.getText();
				cel = txt_Celular.getText();
				LReservas reserva = new LReservas(nombre, nroPersonas, ciudad, hora, fecha, correo, cedula, cel);
				reserva.ingresarReserva(reserva);
				txt_NroPersonas.setText("");
				txt_Nombre.setText("");
				txt_Apellido.setText("");
				txt_Ciudad.setText("");
				txt_Hora.setText("");
				txt_Fecha.setText("");
				txt_Email.setText("");
				txt_Cedula.setText("");
				txt_Celular.setText("");
			}
		});
		panelCentro.add(btn_Reservar);

	}

}
