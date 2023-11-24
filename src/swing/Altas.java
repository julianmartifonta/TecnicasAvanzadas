package swing;

import javax.swing.*;

public class Altas {

	void armarAltasTurno() {
		JFrame marco = new JFrame();
		PanelBasicoAltasTurno hpa = new PanelBasicoAltasTurno();
		marco.getContentPane().add(hpa);
		marco.revalidate();
		marco.pack();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		
	}
	
	void armarEvaluacion() {
		JFrame marco = new JFrame();
		PanelBasicoEvaluacion hpe = new PanelBasicoEvaluacion();
		marco.getContentPane().add(hpe);
		marco.revalidate();
		marco.pack();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}
