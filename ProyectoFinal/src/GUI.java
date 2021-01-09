import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI implements ActionListener{
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JPanel panel1;
	private int lugarIndex;
	private int flag;
	
	
	public GUI(Jugador player, Localizacion[] location) {
		frame = new JFrame();
		String lugar = "Estas en: ";
		String conexiones = "<br>Conectado con: ";
		String gente = "<br>Estas con: ";
		String tienes = "<br>Tienes: ";
		String objetivos = "<br>Objetivos: " + player.getLocalizacionObjetivo() + " - " + player.getObjetoObjetivo().getNombre();
		lugarIndex = 0;
		
		lugar = lugar + player.getLocalizacionActual().getNombre();
		
		if(player.getObjetoActual() != null) {
			tienes = player.getObjetoActual().getNombre();
		}
		
		for(int i = 0; i < player.getLocalizacionActual().getNumConexiones(); i++) {
			conexiones = conexiones + " " + player.getLocalizacionActual().getConexiones(i);
		} 
		
		if(player.getLocalizacionActual().getNumPersonajePresente() != 0) {
			for(int i = 0; i < player.getLocalizacionActual().getNumPersonajePresente(); i++) {
				gente = gente + " " + player.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre();	
			}
		}
		
		String full ="<html><body>" + lugar + conexiones + gente + tienes + objetivos + "</body></html>";
		
		//Incompleto prepararlo para que sea modular
		JButton button2 = new JButton(new AbstractAction("Pedir") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				JFrame frame2 = new JFrame();
				
				String[] name = new String[player.getLocalizacionActual().getNumPersonajePresente()];
				
				for(int c = 0; c < player.getLocalizacionActual().getNumPersonajePresente(); c++) {
					name[c] = player.getLocalizacionActual().getPersonajesPresentes().get(c).getNombre();
				}
				
				JButton b = new JButton(new AbstractAction("Volver") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame2.dispose();
						frame.setVisible(true);
					}
					
				});
					
				//poner trycatch si es necesario
				JButton b1 = new JButton(new AbstractAction("") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						player.pedirObjeto(player.getLocalizacionActual().getPersonajesPresentes().get(0));
						flag = 1;
						frame2.dispose();
					}
				});
				JButton b2 = new JButton(new AbstractAction("") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						player.pedirObjeto(player.getLocalizacionActual().getPersonajesPresentes().get(1));
						flag = 1;
						frame2.dispose();
					}
				});
				JButton b3 = new JButton(new AbstractAction("") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						player.pedirObjeto(player.getLocalizacionActual().getPersonajesPresentes().get(2));
						flag = 1;
						frame2.dispose();
					}
				});
				b1.setFocusable(false);
				b2.setFocusable(false);
				b3.setFocusable(false);
				
				label = new JLabel(full);
				
				Font font = new Font("",Font.PLAIN,30);
				label.setFont(font);
				
				panel1 = new JPanel();
				panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
				panel1.setLayout(new GridLayout(0, 1));
				panel1.add(label);
				
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(2, 2));
				panel.add(b);
				try {
					if(name[0] != null) {
						b1.setText(name[0]);
						panel.add(b1);
					}
				}catch(Exception e) {}
				
				try {
					if(name[1] != null) {
						b2.setText(name[1]);
						panel.add(b2);
					}
				}catch(Exception e) {}
				
				try {
					if(name[2] != null) {
						b3.setText(name[2]);
						panel.add(b3);
					}
				}catch(Exception e) {}
				
				frame2.add(panel1, BorderLayout.PAGE_START);
				frame2.add(panel, BorderLayout.CENTER);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setTitle("Buscar Objetos");
				frame2.setSize(600, 600);
				frame2.setVisible(true);
			}
			
		});
		
		JButton button3 = new JButton(new AbstractAction("Moverse") {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				JFrame frame2 = new JFrame();
				String[] name = new String[player.getLocalizacionActual().getNumConexiones()];
				
				Localizacion[] connectedLocations = new Localizacion[player.getLocalizacionActual().getNumConexiones()];
				
				for(int x = 0; x < player.getLocalizacionActual().getNumConexiones(); x++) {
					for(int z = 0; z < location.length; z++) {
						if(location[z].getNombre().equals(player.getLocalizacionActual().getConexiones(x))) {
							connectedLocations[x] = location[z];
						}
					}
				}
				
				for(int c = 0; c < player.getLocalizacionActual().getNumConexiones(); c++) {
					name[c] = player.getLocalizacionActual().getConexiones(c);
				}
				
				JButton b1 = new JButton(new AbstractAction(">") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(lugarIndex < connectedLocations.length - 1) {
							lugarIndex = lugarIndex + 1;
						}
						label.setText(connectedLocations[lugarIndex].getNombre());
					}
					
				});
				
				JButton b2 = new JButton(new AbstractAction("<") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(lugarIndex > 0) {
							lugarIndex = lugarIndex - 1;
						}
						label.setText(connectedLocations[lugarIndex].getNombre());
					}
					
				});
				
				JButton b3 = new JButton(new AbstractAction("Mover") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						player.mover(location[1]);
						System.out.printf("\n\ninside %s\n", player.getLocalizacionActual().getNombre());
						flag = 1;
						frame2.dispose();
						frame.dispose();
					}
					
				});
				
				JButton b = new JButton(new AbstractAction("Volver") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame2.dispose();
						frame.setVisible(true);
					}
					
				});
				label = new JLabel(connectedLocations[lugarIndex].getNombre());
				
				Font font = new Font("",Font.PLAIN,30);
				label.setFont(font);
				
				panel1 = new JPanel();
				panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
				panel1.setLayout(new GridLayout(0, 1));
				panel1.add(label);
				
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(2, 2));
				panel.add(b2);
				panel.add(b1);
				panel.add(b);
				panel.add(b3);
				
				frame2.add(panel1, BorderLayout.PAGE_START);
				frame2.add(panel, BorderLayout.CENTER);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setTitle("Buscar Objetos");
				frame2.setSize(600, 600);
				frame2.setVisible(true);
			}
			
		});
		
		JButton button = new JButton(new AbstractAction("Skip") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				flag = 1;
				}
			
		});
		
		button.setFocusable(false);
		label = new JLabel(full);
		
		Font font = new Font("",Font.PLAIN,30);
		label.setFont(font);
		
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		panel1.setLayout(new GridLayout(0, 1));
		panel1.add(label);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(2, 2));
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Buscar Objetos");
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public int getFlag() {
		return this.flag;
	}
	public void setFlag(int numero) {
		this.flag = numero;
	}

}