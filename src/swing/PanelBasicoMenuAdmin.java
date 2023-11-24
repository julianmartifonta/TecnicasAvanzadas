package swing;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelBasicoMenuAdmin extends JPanel implements ActionListener {
		
		private JButton boton1;
		private JButton boton2;
		private JButton boton3;
		private JButton boton4;
		
		public PanelBasicoMenuAdmin() {
			armar();
		}
		
		public void armar() {
			this.setLayout(new FlowLayout());
			JLabel Infolbl = new JLabel("Seleccione la opción que desee: ");
			boton1 = new JButton("Obtener turno");
			boton2 = new JButton("Mis turnos");
			boton3 = new JButton("Evaluar");
			boton4 = new JButton("Salir");
			this.add(Infolbl);
			this.add(boton1);
			this.add(boton2);
			this.add(boton3);
			this.add(boton4);
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			boton3.addActionListener(this);
			boton4.addActionListener(this);
			
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == boton1) {
				Altas t = new Altas();
				t.armarAltasTurno();
			}
			/*if(e.getSource() == boton2) {
				ConsultaTurno c = new ConsultaTurno();
				c.armarBajas();
			}*/
			if(e.getSource() == boton3) {
				Altas a = new Altas();
				a.armarEvaluacion();
			}
			if(e.getSource() == boton4) {
				Window b = SwingUtilities.getWindowAncestor(PanelBasicoMenuAdmin.this);
			       b.setVisible(false);
			       }
			
		}
		
}
