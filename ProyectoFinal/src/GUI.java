import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
	private int pedirIndex;
	private int flag;
	
	
	public GUI(Jugador player, Localizacion[] location) {
		frame = new JFrame();
		String lugar = "Estas en: ";
		String conexiones = "<br>Conectado con: ";
		String gente = "<br>Estas con:<br>";
		String tienes = "<br>Tienes: ";
		String objetivos = "<br>Objetivos: " + player.getLocalizacionObjetivo() + " - " + player.getObjetoObjetivo().getNombre();
		String objetosSala = "<br>Objetos sala: ";
		try {
		objetosSala = "<br>Objetos sala: " + player.getLocalizacionActual().getObjetoPresente().getNombre();
		}catch(Exception e) {}
		lugarIndex = 0;
		pedirIndex = 0;
		
		lugar = lugar + player.getLocalizacionActual().getNombre();
		
		if(player.getObjetoActual() != null) {
			tienes = tienes + player.getObjetoActual().getNombre();
		}
		
		for(int i = 0; i < player.getLocalizacionActual().getNumConexiones(); i++) {
			conexiones = conexiones + " " + player.getLocalizacionActual().getConexiones(i);
		} 
		
		if(player.getLocalizacionActual().getNumPersonajePresente() != 0) {
			for(int i = 0; i < player.getLocalizacionActual().getNumPersonajePresente(); i++) {
				if (player.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre().equals("Jugador"))
                    continue;
				if(player.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual() != null)
					gente = gente + " " + player.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre() + " - " + player.getLocalizacionActual().getPersonajesPresentes().get(i).getObjetoActual().getNombre() + "<br>";	
				else
					gente = gente + " " + player.getLocalizacionActual().getPersonajesPresentes().get(i).getNombre() + "<br>";
			}
		}
		
		String full ="<html><body>" + lugar + conexiones + gente + tienes + objetivos + objetosSala +"</body></html>";
		
		//Incompleto prepararlo para que sea modular
		JButton button2 = new JButton(new AbstractAction("Pedir") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				JFrame frame2 = new JFrame();
				
				JButton b = new JButton(new AbstractAction("Volver") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame2.dispose();
						frame.setVisible(true);
					}
					
				});
					
				JButton b1 = new JButton(new AbstractAction("<") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(pedirIndex > 0) {
							pedirIndex = pedirIndex - 1;
						}
						if(!player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre().equals("Jugador"))
							label.setText(player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre());
						else
							pedirIndex = pedirIndex + 1;
					}
				});
				JButton b2 = new JButton(new AbstractAction(">") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(pedirIndex < player.getLocalizacionActual().getPersonajesPresentes().size() - 1) {
							pedirIndex = pedirIndex + 1;
						}
						if(!player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre().equals("Jugador"))
							label.setText(player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre());
						else
							pedirIndex = pedirIndex - 1;
					}
				});
				JButton b3 = new JButton(new AbstractAction("Pedir") {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						player.pedirObjeto(player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex));
						flag = 1;
						frame2.dispose();
						frame.dispose();
					}
				});
				b1.setFocusable(false);
				b2.setFocusable(false);
				b3.setFocusable(false);
				
				
				if(!player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre().equals("Jugador"))
					label = new JLabel(player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex).getNombre());
				else if(player.getLocalizacionActual().getNumPersonajePresente() > 1)
					label = new JLabel(player.getLocalizacionActual().getPersonajesPresentes().get(pedirIndex + 1).getNombre());
				else
					label = new JLabel("");
				
				Font font = new Font("",Font.PLAIN,17);
				label.setFont(font);
				
				panel1 = new JPanel();
				panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
				panel1.setLayout(new GridLayout(0, 1));
				panel1.add(label);
				
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(2, 2));
				panel.add(b1);
				panel.add(b2);	
				panel.add(b);
				panel.add(b3);

				frame2.add(panel1, BorderLayout.PAGE_START);
				frame2.add(panel, BorderLayout.CENTER);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setTitle("Buscar Objetos");
				frame2.setSize(600, 600);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame2.setLocation(dim.width/2-frame2.getSize().width/2, dim.height/2-frame2.getSize().height/2);
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
						player.moverJugador(connectedLocations[lugarIndex]);
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
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame2.setLocation(dim.width/2-frame2.getSize().width/2, dim.height/2-frame2.getSize().height/2);
				frame2.setVisible(true);
			}
			
		});
		
		JButton button4 = new JButton(new AbstractAction("Coger") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.CogerObjeto();
				frame.dispose();
				flag = 1;
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
		
		Font font = new Font("",Font.PLAIN,17);
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
		panel.add(button4);
		
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Buscar Objetos");
		frame.setSize(600, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
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