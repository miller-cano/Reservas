package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeModel;

import bean.BMenu;
import logica.LMenu;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Font;

public class PanelInicio extends JPanel {
	private JTextField txt_Usuario;
	private JTextField txt_Contraseña;

	public PanelInicio() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelInicioNorte = new JPanel();
		panelInicioNorte.setBackground(new Color(95, 158, 160));
		add(panelInicioNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE RESERVAS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 20));
		panelInicioNorte.add(lblNewLabel);
		
		JPanel panelInicioOeste = new JPanel();
		panelInicioOeste.setBackground(Color.GRAY);
		add(panelInicioOeste, BorderLayout.WEST);
		panelInicioOeste.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInicioOesteNorte = new JPanel();
		panelInicioOesteNorte.setBackground(Color.LIGHT_GRAY);
		panelInicioOeste.add(panelInicioOesteNorte, BorderLayout.NORTH);
		panelInicioOesteNorte.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lbl_Usuario = new JLabel("Usuario:");
		panelInicioOesteNorte.add(lbl_Usuario);
		
		txt_Usuario = new JTextField();
		panelInicioOesteNorte.add(txt_Usuario);
		txt_Usuario.setColumns(10);
		
		JLabel lbl_Vacio = new JLabel("");
		panelInicioOesteNorte.add(lbl_Vacio);
		
		JLabel lbl_Contraseña = new JLabel("Contrase\u00F1a:");
		panelInicioOesteNorte.add(lbl_Contraseña);
		
		txt_Contraseña = new JTextField();
		panelInicioOesteNorte.add(txt_Contraseña);
		txt_Contraseña.setColumns(10);
		
		JButton btn_Ingresar = new JButton("Ingresar");
		panelInicioOesteNorte.add(btn_Ingresar);
		
		JPanel panelInicioOesteOeste = new JPanel();
		panelInicioOesteOeste.setBackground(SystemColor.activeCaptionBorder);
		panelInicioOeste.add(panelInicioOesteOeste, BorderLayout.WEST);
		
		JLabel lbl_Espacios1 = new JLabel("     ");
		panelInicioOesteOeste.add(lbl_Espacios1);
		
		JPanel panelInicioOesteEste = new JPanel();
		panelInicioOesteEste.setBackground(SystemColor.activeCaptionBorder);
		panelInicioOeste.add(panelInicioOesteEste, BorderLayout.EAST);
		
		JLabel lbl_Espacios2 = new JLabel("     ");
		panelInicioOesteEste.add(lbl_Espacios2);
		
		JPanel panelInicioOesteSur = new JPanel();
		panelInicioOesteSur.setBackground(SystemColor.activeCaptionBorder);
		panelInicioOeste.add(panelInicioOesteSur, BorderLayout.SOUTH);
		
		JPanel panelInicioOesteCentro = new JPanel();
		panelInicioOesteCentro.setBackground(SystemColor.activeCaption);
		panelInicioOeste.add(panelInicioOesteCentro, BorderLayout.CENTER);
		
		
		
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Reservas");
		DefaultTreeModel modelo = new DefaultTreeModel(raiz);

		JTree tree_Menu = new JTree();
		tree_Menu.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() 
		{
		        public void valueChanged(javax.swing.event.TreeSelectionEvent evt) 
		        {
		        	jTree1ValueChanged(evt);
		        }
		});

		tree_Menu.setModel(modelo);
		
		ArrayList<BMenu> menu = new ArrayList<BMenu>();
        LMenu opcionesMenu = new LMenu();
        menu = opcionesMenu.listarMenu(0);

        for(int i = 0; i< menu.size();i++) {

            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(menu.get(i).getNombre_menu());
            modelo.insertNodeInto(nodo, raiz, 0);

            ArrayList<BMenu> submenu = new ArrayList<BMenu>();
            submenu = opcionesMenu.listarMenu(menu.get(i).getCodigo_menu());

            for(int j = 0; j<submenu.size();j++) {

                DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode(submenu.get(j).getNombre_menu());
                modelo.insertNodeInto(nodo1, nodo, 0);

                ArrayList<BMenu> itemMenu = new ArrayList<BMenu>();
                itemMenu = opcionesMenu.listarMenu(submenu.get(j).getCodigo_menu());

                for(int k = 0; k<itemMenu.size();k++) {

                    DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode(itemMenu.get(k).getNombre_menu());
                    modelo.insertNodeInto(nodo2, nodo1, 0);
                }
            }
        }
        
        tree_Menu.expandRow(0);
        tree_Menu.expandRow(1);
        tree_Menu.expandRow(2);
        tree_Menu.expandRow(3);
        tree_Menu.expandRow(4);
        tree_Menu.expandRow(5);

		panelInicioOesteCentro.add(tree_Menu);
		
		JPanel panelInicioEste = new JPanel();
		add(panelInicioEste, BorderLayout.EAST);
		
		JPanel panelInicioSur = new JPanel();
		add(panelInicioSur, BorderLayout.SOUTH);
		
		JPanel panelInicioCentro = new JPanel();
		add(panelInicioCentro, BorderLayout.CENTER);
	}
	
	public void jTree1ValueChanged( TreeSelectionEvent tse) {
	    String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
	    
	    if( node.equals("Menú") ) {    
	    	PanelMenu panelMenu = new PanelMenu();
	        add(panelMenu, BorderLayout.CENTER);
	    } 
	    	else if( node.equals("Reservar") ) {
	    		PanelReserva panelReserva = new PanelReserva();
	    		add(panelReserva, BorderLayout.CENTER);
	    	}
	    		else if(node.equals("Mostrar Reservas")) {
	    			PanelMostrarReservas panelMostrar = new PanelMostrarReservas();
		    		add(panelMostrar, BorderLayout.CENTER);
	    		}    
	}
}
