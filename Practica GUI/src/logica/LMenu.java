package logica;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import bean.BMenu;

public class LMenu extends BMenu
{
	
	public ArrayList<BMenu> listarMenu(int nivel) {
		String wcadena="";
		int    cuantos=0;

		ArrayList<BMenu> listaMenu = new ArrayList();
		        try 
		        {
		        File existeArchivo = new File("./datos/datosMenu.dat");
		        if (existeArchivo.exists()) 
		        {
		                RandomAccessFile archivo = new RandomAccessFile("./datos/datosMenu.dat","r");
		                archivo.seek(0);
		                while(archivo.getFilePointer() < archivo.length())
		                {
		                BMenu datosMenu = new BMenu();
		                datosMenu.setCodigo_menu(archivo.readInt()); 
		                datosMenu.setNombre_menu(archivo.readUTF());
		                datosMenu.setDependencia(archivo.readInt());
		                datosMenu.setFormulario(archivo.readUTF());
		                datosMenu.setEstado(archivo.readUTF());
		                datosMenu.setOrden(archivo.readInt());
		                
		                if(datosMenu.getDependencia() == nivel)
		                {
		                listaMenu.add(datosMenu);
		                }
		                cuantos++;
		           }
		           if(cuantos == 0) {
		                 consecutivoMenu();
		           }
		           archivo.close();
		 }else
		  {
		     consecutivoMenu();
		  }
		        }catch(IOException e){
		              System.out.print("aquí " + e.getCause());
		              consecutivoMenu();
		         }
		       return listaMenu;   
		}
	
	public ArrayList<BMenu> listarMenuTodos(){
		ArrayList<BMenu> listaMenu = new ArrayList();
		        try 
		        {
		        File existeArchivo = new File("./datos/datosMenu.dat");
		        if (existeArchivo.exists()) 
		        {
		        RandomAccessFile archivo = new RandomAccessFile("./datos/datosMenu.dat","r");
		        archivo.seek(0);
		                while(archivo.getFilePointer() < archivo.length())
		                {
		                
		                BMenu datosMenu = new BMenu();
		                datosMenu.setCodigo_menu(archivo.readInt()); 
		                datosMenu.setNombre_menu(archivo.readUTF());
		                datosMenu.setDependencia(archivo.readInt());
		                datosMenu.setFormulario(archivo.readUTF());
		                datosMenu.setEstado(archivo.readUTF());
		                datosMenu.setOrden(archivo.readInt());
		                
		               listaMenu.add(datosMenu);
		                }
		                archivo.close();
		        }else
		         {
		        consecutivoMenu();
		         }
		        }catch(IOException e) 
		         {
		        System.out.print("aquí " + e.getCause());
		        consecutivoMenu();
		         }
		       return listaMenu; 
		}
	
	
	private int consecutivoMenu() {

        int ultimo = 0;

        try {
            RandomAccessFile archivo1 = new RandomAccessFile("./datos/datosMenu.dat", "rw");
            ultimo = (int)archivo1.length();

            if(ultimo == 0) {

                archivo1.seek(archivo1.length());
                archivo1.writeInt(1);
                archivo1.writeUTF("Estructura Menú");
                archivo1.writeInt(0);
                archivo1.writeUTF("");
                archivo1.writeUTF("A");
                archivo1.writeInt(1);

                archivo1.seek(archivo1.length());
                archivo1.writeInt(2);
                archivo1.writeUTF("Básicas");
                archivo1.writeInt(1);
                archivo1.writeUTF("");
                archivo1.writeUTF("A");
                archivo1.writeInt(1);

                archivo1.seek(archivo1.length());
                archivo1.writeInt(3);
                archivo1.writeUTF("Menú");
                archivo1.writeInt(2);
                archivo1.writeUTF("PanelMenu");
                archivo1.writeUTF("A");
                archivo1.writeInt(1);
                
                
                archivo1.seek(archivo1.length());
                archivo1.writeInt(4);
                archivo1.writeUTF("Menú Reservas");
                archivo1.writeInt(0);
                archivo1.writeUTF("");
                archivo1.writeUTF("A");
                archivo1.writeInt(2);

                archivo1.seek(archivo1.length());
                archivo1.writeInt(5);
                archivo1.writeUTF("Reservar");
                archivo1.writeInt(4);
                archivo1.writeUTF("PanelReserva");
                archivo1.writeUTF("A");
                archivo1.writeInt(1);

                archivo1.seek(archivo1.length());
                archivo1.writeInt(6);
                archivo1.writeUTF("Mostrar Reservas");
                archivo1.writeInt(4);
                archivo1.writeUTF("PanelMostrarReservas");
                archivo1.writeUTF("A");
                archivo1.writeInt(2);
                archivo1.close();
            }
            else {
            RandomAccessFile archivo = new RandomAccessFile("./datos/datosMenu.dat", "rw");
            archivo.seek(0);
                while(archivo.getFilePointer() < archivo.length()) {
                    ultimo++;
                }
            archivo.close();
            }
        }catch(IOException e){
            System.out.println(e);
        }
        return ultimo;
    }
	
	public void ingresar(LMenu menu) {

        try
        {
            RandomAccessFile archivo = new RandomAccessFile("./datos/datosMenu.dat","rw");
            archivo.seek(archivo.length());
            archivo.writeInt(menu.getCodigo_menu());
            archivo.writeUTF(menu.getNombre_menu());
            archivo.writeInt(menu.getDependencia());
            archivo.writeUTF(menu.getFormulario());
            archivo.writeUTF(menu.getEstado());
            archivo.writeInt(menu.getOrden());
            archivo.close();
        }catch(IOException e) {System.out.print(e);}
    }

}
