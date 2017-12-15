package yolocorp.estock.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreAffichage extends JFrame implements ActionListener {

	private JButton btOK;
	
	public FenetreAffichage(String[] produits) {

		setTitle("Affichage");
		setBounds(500, 500, 450, 250);
		JPanel panHaut = new JPanel();
		JPanel panBas = new JPanel();
		panHaut.setLayout(new BorderLayout());
		panBas.setLayout(new FlowLayout());
		
		btOK = new JButton("Quitter");
		
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		String stringProduits = "";
		for(String produit: produits) {
			stringProduits += produit + "\n";
		}
		JTextArea jtaSortie = new JTextArea(stringProduits,10,5);
		panHaut.add(jtaSortie);
		
		panBas.add(btOK);

		contentPane.add(panHaut,"North");
		contentPane.add(panBas, "South");
		btOK.addActionListener(this);

		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

}
