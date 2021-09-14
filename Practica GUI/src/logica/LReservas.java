package logica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.BReservas;

public class LReservas extends BReservas{

	public LReservas() {}
	
	public LReservas(String nombre, int nroPersonas, String ciudad, String hora, String fecha, String correo, String cedula, String cel) {
		super.setNombre(nombre);
		super.setNroPersonas(nroPersonas);
		super.setCiudad(ciudad);
		super.setHora(hora);
		super.setFecha(fecha);
		super.setCorreo(correo);
		super.setCedula(cedula);
		super.setCel(cel);
	}
	
	public void ingresarReserva(BReservas reserva) {
		
		try
		{
			RandomAccessFile archivo = new RandomAccessFile("./datos/datosReservas.dat","rw");
			archivo.seek(archivo.length());
			archivo.writeUTF(reserva.getNombre());
			archivo.writeInt(reserva.getNroPersonas());
			archivo.writeUTF(reserva.getCiudad());
			archivo.writeUTF(reserva.getHora());
			archivo.writeUTF(reserva.getFecha());
			archivo.writeUTF(reserva.getCorreo());
			archivo.writeUTF(reserva.getCedula());
			archivo.writeUTF(reserva.getCel());
			archivo.close();
			JOptionPane.showMessageDialog(null, "Reserva Exitosa");
		}catch(IOException e) {System.out.print(e);}	
	}
	
	public ArrayList<BReservas> listarReserva(){
		ArrayList<BReservas> listaReservas = new ArrayList();
		        try 
		        {
			        File existeArchivo = new File("./datos/datosReservas.dat");
			        if (existeArchivo.exists()) 
			        {
				        RandomAccessFile archivo = new RandomAccessFile("./datos/datosReservas.dat","r");
				        archivo.seek(0);
		                while(archivo.getFilePointer() < archivo.length())
		                {
		                
			                BReservas datosReserva = new BReservas();
			                
			                datosReserva.setNombre(archivo.readUTF());
			    			datosReserva.setNroPersonas(archivo.readInt());
			    			datosReserva.setCiudad(archivo.readUTF());
			    			datosReserva.setHora(archivo.readUTF());
			    			datosReserva.setFecha(archivo.readUTF());
			    			datosReserva.setCorreo(archivo.readUTF());
			    			datosReserva.setCedula(archivo.readUTF());
			    			datosReserva.setCel(archivo.readUTF());
		                
			    			listaReservas.add(datosReserva);
		                }
			            archivo.close();
			        }
		        }catch(IOException e) { }
		      return listaReservas; 
		}
	
	
	
}
