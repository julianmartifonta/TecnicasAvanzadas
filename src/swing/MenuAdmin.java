package swing;

import javax.swing.*;

import entidades.Usuario;

public class MenuAdmin {

	public void armarMenuAdmin() {
		JFrame marco = new JFrame();
		PanelBasicoMenuAdmin mv3 = new PanelBasicoMenuAdmin();
		marco.getContentPane().add(mv3);
		
		marco.pack();
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		
	}
	
}

