package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.BMenu;
import logica.LMenu;
import java.awt.Font;
import java.awt.Color;

public class PanelMenu extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(0, 206, 209));
		add(panelNorte, BorderLayout.NORTH);
		
		JLabel lbl_Titulo = new JLabel("INFORMACI\u00D3N MEN\u00DA");
		lbl_Titulo.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		panelNorte.add(lbl_Titulo);
		
		JPanel panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentroNorte = new JPanel();
		panelCentro.add(panelCentroNorte, BorderLayout.NORTH);
		panelCentroNorte.setLayout(new BorderLayout(0, 0));
		
		JButton btn_Insertar = new JButton("Insertar");
		btn_Insertar.setBackground(Color.ORANGE);
		btn_Insertar.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane
			}
		});
		panelCentroNorte.add(btn_Insertar, BorderLayout.EAST);
		
		JLabel lbl_Separacion = new JLabel("    ");
		panelCentroNorte.add(lbl_Separacion, BorderLayout.SOUTH);
		
		JPanel panelCentroOeste = new JPanel();
		panelCentro.add(panelCentroOeste, BorderLayout.WEST);
		
		JPanel panelCentroSur = new JPanel();
		panelCentro.add(panelCentroSur, BorderLayout.SOUTH);
		
		JPanel panelCentroEste = new JPanel();
		panelCentro.add(panelCentroEste, BorderLayout.EAST);
		
		JPanel panelCentroCentro = new JPanel();
		panelCentro.add(panelCentroCentro, BorderLayout.CENTER);
		
		ArrayList<BMenu> menu = new ArrayList<BMenu>();
		LMenu opcionesMenu = new LMenu();
		menu = opcionesMenu.listarMenuTodos();

		JTable tabla;
		DefaultTableModel modelo;
		Object[][] datos=new Object[menu.size()][6];
		

		String[] nombreColumnas1 = {"Código","Nombre","Nivel","Formulario","Estado","Orden"};

		for(int i=0; i< menu.size();i++)
		{
		datos[i][0] = menu.get(i).getCodigo_menu();
		datos[i][1] = menu.get(i).getNombre_menu();
		datos[i][2] = menu.get(i).getDependencia();
		datos[i][3] = menu.get(i).getFormulario();
		datos[i][4] = menu.get(i).getEstado();
		datos[i][5] = menu.get(i).getOrden();
		}
		modelo=new DefaultTableModel(datos,nombreColumnas1);
		    tabla=new JTable(modelo);
		    tabla.setBackground(new Color(173, 255, 47));
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
