package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.BMenu;
import bean.BReservas;
import logica.LMenu;
import logica.LReservas;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class PanelMostrarReservas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelMostrarReservas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(0, 206, 209));
		add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LISTA DE RESERVAS");
		lblNewLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		panelNorte.add(lblNewLabel);
		
		JPanel panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentroOeste = new JPanel();
		panelCentro.add(panelCentroOeste, BorderLayout.WEST);
		
		JPanel panelCentroEste = new JPanel();
		panelCentro.add(panelCentroEste, BorderLayout.EAST);
		
		JPanel panelCentroNorte = new JPanel();
		panelCentro.add(panelCentroNorte, BorderLayout.NORTH);
		
		JPanel panelCentroSur = new JPanel();
		panelCentro.add(panelCentroSur, BorderLayout.SOUTH);
		
		JPanel panelCentroCentro = new JPanel();
		panelCentro.add(panelCentroCentro, BorderLayout.CENTER);
				
		
		 
		  
		ArrayList<BReservas> reservas = new ArrayList<BReservas>();
		LReservas reserva = new LReservas();
		reservas = reserva.listarReserva();

		JTable tabla;
		DefaultTableModel modelo;
		Object[][] datos = new Object[reservas.size()][8];
		

		String[] nombreColumnas1 = {"Nombre","Nro Personas","Ciudad","Hora","Fecha","Correo", "Cédula", "Celular"};

		for(int i=0; i< reservas.size();i++)
		{
			datos[i][0] = reservas.get(i).getNombre();
			datos[i][1] = reservas.get(i).getNroPersonas();
			datos[i][2] = reservas.get(i).getCiudad();
			datos[i][3] = reservas.get(i).getHora();
			datos[i][4] = reservas.get(i).getFecha();
			datos[i][5] = reservas.get(i).getCorreo();
			datos[i][6] = reservas.get(i).getCedula();
			datos[i][7] = reservas.get(i).getCel();
		}
		modelo=new DefaultTableModel(datos,nombreColumnas1);
		    tabla=new JTable(modelo);
		    tabla.setBackground(new Color(127, 255, 212));
		    tabla.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		    JOptionPane.showMessageDialog(null, "Dio click");
		    }
		    });
		    panelCentroCentro.setLayout(new BorderLayout(0, 0));
		    
		    JScrollPane aa = new JScrollPane();
		    aa.setViewportView(tabla);
		    
		    panelCentroCentro.add(aa);
		  
	}

}
