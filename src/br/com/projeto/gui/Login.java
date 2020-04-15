package br.com.projeto.gui;

//import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.sql.SQLException;

import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
//import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.com.projeto.bean.UsuarioAutentica;
import br.com.projeto.bean.UsuarioBean;
import br.com.projeto.dao.UsuarioDao;

import javax.swing.ImageIcon;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel jContentPane = null;
	private JLabel jlLogin = null;
	private JLabel jlSenha = null;
	private JLabel jlTipo = null;
	private JPasswordField txtSenha = null;
	private JTextField txtLogin = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipo = null;
	private JButton btnAcesssar = null;
	private LookAndFeelInfo[] looks;
	/**
	 * This method initializes txtSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setBounds(new java.awt.Rectangle(76,60,197,32));
		}
		return txtSenha;
	}

	/**
	 * This method initializes txtLogin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(new java.awt.Rectangle(75,17,320,32));
		}
		return txtLogin;
	}

	/**
	 * This method initializes cboTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox getCboTipo() {
		if (cboTipo == null) {
			cboTipo = new JComboBox();
			cboTipo.setBounds(new java.awt.Rectangle(76,105,132,32));
		}
		return cboTipo;
	}

	/**
	 * This method initializes btnAcesssar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAcesssar() {
		if (btnAcesssar == null) {
			btnAcesssar = new JButton();
			btnAcesssar.setBounds(new java.awt.Rectangle(123,167,167,32));
			btnAcesssar.setIcon(new ImageIcon(getClass().getResource("/br/com/projeto/imagens/acesso.png")));
			btnAcesssar.setText("Acessar");
			btnAcesssar.addActionListener(new java.awt.event.ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(java.awt.event.ActionEvent e) {

					try {
						UsuarioDao chamar = new UsuarioDao();
						String tipo = (String)cboTipo.getSelectedItem();
						UsuarioBean objUsuario;
						objUsuario = chamar.consultarUsuarioPorLogin(txtLogin.getText(), txtSenha.getText(),tipo);
					if (objUsuario !=null){
						JOptionPane.showConfirmDialog(null, "Login realizado com sucesso");
						UsuarioAutentica.setUsuarioLogado(objUsuario);
						dispose();
						
						MenuPrincipal janela = new MenuPrincipal();//Cria objeto Menu
						janela.setVisible(true);//Abre a janela Menu
						janela.setLocationRelativeTo(null);
					}else{
						JOptionPane.showMessageDialog(null, "Erro ao logar.");
		
					}
					
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			});
		}
		return btnAcesssar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public Login() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(441, 270);
		this.setContentPane(getJContentPane());
		this.setTitle("Login Sistema");
		lookAndFeel(1);
		preenchercombo();
	}
	  private void lookAndFeel(int index) {
	    	// obtem looks disponiveis
	        looks = javax.swing.UIManager.getInstalledLookAndFeels();
	        
	        try {
	        	// seleciona o look na posicao index do vetor
	            javax.swing.UIManager.setLookAndFeel(looks[index].getClassName());
	            // aplica o look aos componentes
	            javax.swing.SwingUtilities.updateComponentTreeUI(this);
	        } catch (Exception e) {
	        	JOptionPane.showInputDialog(null, "Erro Interno!", "Erro", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	    }
	
	@SuppressWarnings("unchecked")
	public void preenchercombo(){
		cboTipo.addItem("");
		cboTipo.addItem("USU");
		cboTipo.addItem("ADM");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jlTipo = new JLabel();
			jlTipo.setBounds(new java.awt.Rectangle(16,105,49,32));
			jlTipo.setIcon(new ImageIcon(getClass().getResource("/br/com/projeto/imagens/tipo.png")));
			jlTipo.setText("Tipo:");
			jlSenha = new JLabel();
			jlSenha.setBounds(new java.awt.Rectangle(15,60,63,32));
			jlSenha.setIcon(new ImageIcon(getClass().getResource("/br/com/projeto/imagens/Keys-icon.png")));
			jlSenha.setText("Senha:");
			jlLogin = new JLabel();
			jlLogin.setBounds(new java.awt.Rectangle(16,17,59,32));
			jlLogin.setIcon(new ImageIcon(getClass().getResource("/br/com/projeto/imagens/AA.png")));
			jlLogin.setText("Login:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jlLogin, null);
			jContentPane.add(jlSenha, null);
			jContentPane.add(jlTipo, null);
			jContentPane.add(getTxtSenha(), null);
			jContentPane.add(getTxtLogin(), null);
			jContentPane.add(getCboTipo(), null);
			jContentPane.add(getBtnAcesssar(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
