package swing;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entidades.Usuario;
import metodos.NotFoundException;
import metodos.UsuarioDAOH2Impl;
import servicio.ClaseServicio;
import servicio.Sesion;

public class PanelInicioDeSesion extends JPanel implements ActionListener{
	
	private JTextField txtUsuario;
	private JPasswordField txtContra;
	private JButton botonEntrar;
	private JButton botonSalir;
	private String usuarioIngresado;
	private String passwordIngresado;
	private int cont;

	public PanelInicioDeSesion() {
		armarInit();
	}
		public void armarInit() {
		    this.setLayout(new FlowLayout());
			JLabel usuariolbl = new JLabel("Apellido: ");
			JLabel contraseñalbl = new JLabel("Contraseña: ");
			botonEntrar = new JButton("Entrar");
			botonSalir = new JButton("Salir");
			this.txtUsuario = new JTextField(30);
			this.txtContra = new JPasswordField(30);
			this.add(usuariolbl);
			this.add(txtUsuario);
			this.add(contraseñalbl);
			this.add(txtContra);
			this.add(botonEntrar);
			this.add(botonSalir);
			botonEntrar.addActionListener(this);
			botonSalir.addActionListener(this);
	}
		private void mostrarPanelError() {
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
		public void mostrarIngreso(Usuario usuarioBase) { // Función para determinar el ingreso o no
			cont = 0;
			try  {
			JOptionPane.showMessageDialog(this, "Bienvenido al sistema, usuario " + usuarioBase.getNombre() + " " + usuarioBase.getApellido() + ". DNI: " + usuarioBase.getDNI(),
					"Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE);
			} catch (NullPointerException np){ // Si no se encontró el usuario, el puntero seguirá nulo
				mostrarPanelError();
				cont = cont + 1;
			}
			if(cont == 0) {
				Sesion.iniciarSesion(usuarioBase);
				MenuConductor mp = new MenuConductor();
				mp.armarMenuConductor(usuarioBase);
			}
		}
		
		public void mostrarIngresoAdmin(Usuario usuarioBase) { // Función para determinar el ingreso o no
			cont = 0;
			try  {
			JOptionPane.showMessageDialog(this, "Bienvenido al sistema, técnico " + usuarioBase.getNombre() + " " + usuarioBase.getApellido() + ".",
					"Ingreso exitoso como admin", JOptionPane.INFORMATION_MESSAGE);
			} catch (NullPointerException np){ // Si no se encontró el usuario, el puntero seguirá nulo
				mostrarPanelError();
				cont = cont + 1;
			}
			if(cont == 0) {
				Sesion.iniciarSesion(usuarioBase);
				MenuAdmin mp = new MenuAdmin();
				mp.armarMenuAdmin();
			}
		}
			
		
	            public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botonEntrar) {
				
				usuarioIngresado = this.txtUsuario.getText(); 
				passwordIngresado = this.txtContra.getText();
				
				ClaseServicio c = new ClaseServicio();
				try {
					c.SConsultaPassword(usuarioIngresado, passwordIngresado);
				} catch (NotFoundException e1) {
					e1.printStackTrace();
				}
				Window b = SwingUtilities.getWindowAncestor(PanelInicioDeSesion.this);
			       b.setVisible(false);
	            }

			if(e.getSource() == botonSalir) {
				Window b = SwingUtilities.getWindowAncestor(PanelInicioDeSesion.this);
			       b.setVisible(false);
				
			}
		}
		
		{
			
			
		}
}

