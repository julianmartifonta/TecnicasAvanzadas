package swing;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class PanelBasicoAltasTurno extends JPanel implements ActionListener{

	// Declara todos los elementos a usar
	private JButton botonCargar;
	private JButton botonVolver;
	private JDatePickerImpl datePicker;
	private JTextField fechaTF;
	private JTextField horaTF;
	private JTextField minutosTF;
    private JComboBox<String> sedeComboBox;
    private JComboBox<String> vehiculoComboBox;
	private String fechaIngresada;
	private int horaIngresada;
	private int minutosIngresados;
	
	// Llama a la función armar (abajo)
	public PanelBasicoAltasTurno() {
		armarPBAT();
	}
	
	private void mostrarPanelErrorMinutos() {
		JOptionPane.showMessageDialog(this, "Elija una hora real. Además, todos los turnos son cada media hora. Por favor, elija un turno para una hora en punto o y media.",
				"Hora incorrecta", JOptionPane.ERROR_MESSAGE);
	}

	// Construye el panel de altas
	private void armarPBAT() {
		this.setLayout(new FlowLayout());		// Crea layout
		this.setSize(2000,2000);   // Define tamaño
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.dia", "Dia");
		p.put("text.mes", "Mes");
		p.put("text.anio", "Año");
		JDatePanelImpl panel = new JDatePanelImpl(model,p);
		datePicker = new JDatePickerImpl(panel,null);
		JLabel fechalbl = new JLabel("Fecha del turno (en formato YYYY-MM-DD)");
		JLabel horalbl = new JLabel("Hora del turno: ");
		JLabel minutoslbl = new JLabel(":");
		this.sedeComboBox = new JComboBox<>();
	    this.vehiculoComboBox = new JComboBox<>();
		this.botonCargar = new JButton("Cargar turno"); // Creamos los botones
		this.botonVolver = new JButton("Volver");
		this.fechaTF = new JTextField(8);
		this.horaTF = new JTextField(2);
		this.minutosTF = new JTextField(2);
		this.add(datePicker);
		this.add(fechalbl);
		this.add(fechaTF);
		this.add(horalbl);
		this.add(horaTF);
		this.add(minutoslbl);
		this.add(minutosTF);
		this.add(new JLabel("Sede: "));
        this.add(sedeComboBox);
        this.add(new JLabel("Vehículo: "));
        this.add(vehiculoComboBox);
		this.add(botonCargar);
		this.add(botonVolver);
		botonCargar.addActionListener(this);
		botonVolver.addActionListener(this);
		
		ClaseServicio servicio = new ClaseServicio();
        List<String> sedes = servicio.obtenerSedesDisponibles();
        List<String> vehiculos = servicio.obtenerVehiculosUsuario(Sesion.obtenerUsuarioActual());
        
        for (String sede : sedes) {
            sedeComboBox.addItem(sede);
        }
        
        for (String vehiculo : vehiculos) {
            vehiculoComboBox.addItem(vehiculo);
        }
	}
	
	public void mostrarPanelError() {
		JOptionPane.showMessageDialog(this, "Ya existe un turno agendado",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	// java67.com
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonCargar) { 
			
			Usuario usuarioSolicitante = Sesion.obtenerUsuarioActual();
			String sedeSeleccionada = (String) sedeComboBox.getSelectedItem();
	        String vehiculoSeleccionado = (String) vehiculoComboBox.getSelectedItem();
	        fechaIngresada = this.fechaTF.getText();
			horaIngresada = (Integer.parseInt(this.horaTF.getText()));
			minutosIngresados = (Integer.parseInt(this.minutosTF.getText()));

			if(minutosIngresados != 00 && minutosIngresados != 30 || horaIngresada < 0 || horaIngresada > 23){
				mostrarPanelErrorMinutos();
			} else {
			ClaseServicio c = new ClaseServicio();
			c.SAltasTurnoFinal(usuarioSolicitante, fechaIngresada, horaIngresada, minutosIngresados, sedeSeleccionada, vehiculoSeleccionado);
			}
		}
		if(e.getSource() == botonVolver) {
			
			Window b = SwingUtilities.getWindowAncestor(PanelBasicoAltasTurno.this);
		       b.setVisible(false);
		}
	}
	
}
