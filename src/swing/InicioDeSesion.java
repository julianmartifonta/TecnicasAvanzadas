package swing;

import javax.swing.*;

public class InicioDeSesion {

	void armarInit() {
		JFrame marco = new JFrame();
		PanelInicioDeSesion pis = new PanelInicioDeSesion();
		marco.getContentPane().add(pis);
		
		marco.pack();
		marco.setVisible(true);
		marco.setSize(900,200); // Tamaño del panel
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		
	}
	
}
