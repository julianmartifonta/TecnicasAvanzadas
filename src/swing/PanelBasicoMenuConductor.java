package swing;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelBasicoMenuConductor extends JPanel implements ActionListener {
		
		private JButton boton1;
		private JButton boton2;
		private JButton boton3;
		
		public PanelBasicoMenuConductor() {
			armar();
		}
		
		public void armar() {
			this.setLayout(new FlowLayout());
			JLabel Infolbl = new JLabel("Seleccione la opción que desee: ");
			boton1 = new JButton("Obtener turno");
			boton2 = new JButton("Mis turnos");
			boton3 = new JButton("Salir");
			this.add(Infolbl);
			this.add(boton1);
			this.add(boton2);
			this.add(boton3);
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			boton3.addActionListener(this);
			
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == boton1) {
				Altas t = new Altas();
				t.armarAltasTurno();
			}/*
			if(e.getSource() == boton2) {
				ConsultaTurno c = new ConsultaTurno();
				c.armarBajas();
			}*/
			if(e.getSource() == boton3) {
				Window b = SwingUtilities.getWindowAncestor(PanelBasicoMenuConductor.this);
			       b.setVisible(false);
			       }
			
		}
		
}
