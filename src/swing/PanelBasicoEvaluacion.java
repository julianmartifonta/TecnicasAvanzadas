package swing;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;

import entidades.Usuario;
import entidades.Vehiculo;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import metodos.UsuarioDAOH2Impl;
import servicio.ClaseServicio;
import servicio.Sesion;

public class PanelBasicoEvaluacion extends JPanel implements ActionListener{

	// Declara todos los elementos a usar
	private JButton botonCargar;
	private JButton botonVolver;
	private JTextField motorTF;
	private JTextField frenosTF;
	private JTextField transmisionTF;
	private JTextField lucesTF;
	private JTextField emisionesTF;
	private JTextField seguridadTF;
	private int puntajemotor;
	private int puntajefrenos;
	private int puntajetransmision;
	private int puntajeluces;
	private int puntajeemisiones;
	private int puntajeseguridad;
	private String vehiculoActual;
	
	// Llama a la función armar (abajo)
	public PanelBasicoEvaluacion() {
		armarPBE();
	}
	
	private void mostrarPanelErrorMinutos() {
		JOptionPane.showMessageDialog(this, "Elija una hora real. Además, todos los turnos son cada media hora. Por favor, elija un turno para una hora en punto o y media.",
				"Hora incorrecta", JOptionPane.ERROR_MESSAGE);
	}

	// Construye el panel de altas
	private void armarPBE() {
		this.setLayout(new FlowLayout());		// Crea layout
		this.setSize(2000,2000);   // Define tamaño
		ClaseServicio c = new ClaseServicio();
		JLabel fechalbl = new JLabel("Ingrese los puntajes correspondientes a medida que la evaluación trascurra:");
		vehiculoActual = c.obtenerUltimoVehiculo();
		JLabel vehiculoActualLabel = new JLabel("Vehículo actual: " + vehiculoActual);
		JLabel motorlbl = new JLabel("Motor: ");
		JLabel frenoslbl = new JLabel("Frenos: ");
		JLabel transmisionlbl = new JLabel("Transmisión: ");
		JLabel luceslbl = new JLabel("Luces: ");
		JLabel emisioneslbl = new JLabel("Emisiones: ");
		JLabel seguridadlbl = new JLabel("Seguridad: ");
		this.botonCargar = new JButton("Cargar resultado"); // Creamos los botones
		this.botonVolver = new JButton("Volver");
		this.motorTF = new JTextField(2);
		this.frenosTF = new JTextField(2);
		this.transmisionTF = new JTextField(2);
		this.lucesTF = new JTextField(2);
		this.emisionesTF = new JTextField(2);
		this.seguridadTF = new JTextField(2);
		this.add(fechalbl);
		this.add(vehiculoActualLabel);
		this.add(motorlbl);
		this.add(motorTF);
		this.add(frenoslbl);
		this.add(frenosTF);
		this.add(transmisionlbl);
		this.add(transmisionTF);
		this.add(luceslbl);
		this.add(lucesTF);
		this.add(emisioneslbl);
		this.add(emisionesTF);
		this.add(seguridadlbl);
		this.add(seguridadTF);
		this.add(botonCargar);
		this.add(botonVolver);
		botonCargar.addActionListener(this);
		botonVolver.addActionListener(this);
		
	}
	
	public void mostrarPanelError() {
		JOptionPane.showMessageDialog(this, "Ya existe un turno agendado",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonCargar) {
			puntajemotor = (Integer.parseInt(this.motorTF.getText()));
			puntajefrenos = (Integer.parseInt(this.frenosTF.getText()));
			puntajetransmision = (Integer.parseInt(this.transmisionTF.getText()));
			puntajeluces = (Integer.parseInt(this.lucesTF.getText()));
			puntajeemisiones = (Integer.parseInt(this.emisionesTF.getText()));
			puntajeseguridad = (Integer.parseInt(this.seguridadTF.getText()));
			List<Integer> puntajes = new ArrayList<>();
	        puntajes.add(puntajemotor);
	        puntajes.add(puntajefrenos);
	        puntajes.add(puntajetransmision);
	        puntajes.add(puntajeluces);
	        puntajes.add(puntajeemisiones);
	        puntajes.add(puntajeseguridad);
			ClaseServicio c = new ClaseServicio();
			c.SAltasEval(vehiculoActual, puntajes);
		}
		if(e.getSource() == botonVolver) {
			
			Window b = SwingUtilities.getWindowAncestor(PanelBasicoEvaluacion.this);
		       b.setVisible(false);
		}
	}
	
}
