// package lab3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class JGalo extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3780928537820216588L;
	private JPanel jPanel = null;
	private JToggleButton bt[];
	JGaloInterface jogo ; 

	public JGalo(JGaloInterface myGreatGame) {
		super("Jogo da Galinha");
		jogo = myGreatGame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
        setLocation(100,100);
        jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3,3));
		bt = new JToggleButton[9];
		for (int i=0; i<9; i++) {
			bt[i] = new JToggleButton();
			bt[i].setFont(new Font("Tahoma", Font.BOLD, 50));
			bt[i].setForeground(Color.BLUE);
			bt[i].addActionListener(this);
			jPanel.add(bt[i]);				
		}
		  
		this.setContentPane(jPanel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("JToggleButton")){
			((JToggleButton)e.getSource()).setText(String.valueOf(jogo.getActualPlayer()));
			((JToggleButton)e.getSource()).setEnabled(false);
		}
		for (int i=0; i<9; i++)
			if (e.getSource()==bt[i]) {
				jogo.setJogada(i/3+1,i%3+1);
			}

		if (jogo.isFinished()){
			char result = jogo.checkResult();
			if (result == ' ')
				JOptionPane.showMessageDialog(getContentPane(), "Empate!");
			else
				JOptionPane.showMessageDialog(getContentPane(), "Venceu o jogador " + result);
			System.exit(0);
		}
	}

	public static void main(String args[]) {

		if (args.length == 0) {
            new JGalo(new JGaloLogic());
        }
        else if (args.length == 1) {
            char player = args[0].charAt(0);

            if ( player == 'X' || player == 'O') {
                new JGalo(new JGaloLogic(player));
            }
            else {
                System.out.println("Invalid input. Please select either 'X' or 'O'");
            }

        } 
		else {
            System.out.println("Invalid number of arguments!");
        }
    }
} 


// regras do jogo do galo:
// 2 jogadores e 9 posiçoes possiveis (3x3)
// só pode usar X ou O cada um deles
// quando um dos jogadores joga numa posicao já n é possivel voltar a jogar nela
// ganha quem tiver 3 simbolos seguidos na horizontal, vertical ou diagonal
