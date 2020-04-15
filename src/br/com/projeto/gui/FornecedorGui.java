package br.com.projeto.gui;

//import java.awt.BorderLayout;
import java.sql.SQLException;
//import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import br.com.projeto.bean.CidadeBean;
//import br.com.projeto.bean.ClienteBean;
import br.com.projeto.bean.FornecedorBean;
//import br.com.projeto.bean.UsuarioBean;
//import br.com.projeto.dao.CidadeDao;
//import br.com.projeto.dao.ClienteDao;
import br.com.projeto.dao.FornecedorDao;
//import br.com.projeto.dao.UsuarioDao;
//import br.com.projeto.validador.Validador;

@SuppressWarnings("serial")
public class FornecedorGui extends JFrame {

	private JPanel jContentPane = null;
	private JPanel painelBotoes = null;
	private JButton btnRegistrar = null;
	private JButton btnListar = null;
	private JButton btnSair = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JLabel jlCodigo = null;
	private JLabel jlNome = null;
	private JLabel jlEndereco = null;
	private JLabel jlTelefone = null;
	private JLabel jlEmail = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private JTextField txtEndereco = null;
	private JFormattedTextField txtTelefone = null;
	private JTextField txtEmail = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JPanel painelConsultar = null;
	private JLabel jlNomeConsultar = null;
	private JTextField txtNomeConsultar = null;
	private JScrollPane jScrollPane = null;
	private JTable tabelaconsultar = null;
	@SuppressWarnings("unused")
	private List<CidadeBean> listaCidades = new ArrayList<CidadeBean>();
	@SuppressWarnings("unused")
	private List<Integer> listaCodigosCidades = new ArrayList<Integer>();
	private DefaultTableModel tabelaModeloFornecedor;
	private List<FornecedorBean> listafornecedor = new ArrayList<FornecedorBean>();
	private JLabel jlCnpj = null;
	private JLabel jlObs = null;
	private JTextField txtCnpj = null;
	private JTextField txtObs = null;
	/**
	 * This method initializes painelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelBotoes() {
		if (painelBotoes == null) {
			painelBotoes = new JPanel();
			painelBotoes.setLayout(null);
			painelBotoes.setBounds(new java.awt.Rectangle(68,30,441,37));
			painelBotoes.add(getBtnRegistrar(), null);
			painelBotoes.add(getBtnListar(), null);
			painelBotoes.add(getBtnSair(), null);
		}
		return painelBotoes;
	}

	/**
	 * This method initializes btnRegistrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton();
			btnRegistrar.setBounds(new java.awt.Rectangle(39,11,95,17));
			btnRegistrar.setActionCommand("Registrar");
			btnRegistrar.setText("Registrar");
		}
		return btnRegistrar;
	}

	/**
	 * This method initializes btnListar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton();
			btnListar.setBounds(new java.awt.Rectangle(173,11,95,17));
			btnListar.setText("Listar");
			btnListar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					painelTabs.setSelectedIndex(1);
				}
			});
		}
		return btnListar;
	}

	/**
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new java.awt.Rectangle(307,11,95,17));
			btnSair.setText("Sair");
			btnSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return btnSair;
	}

	/**
	 * This method initializes painelTabs	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getPainelTabs() {
		if (painelTabs == null) {
			painelTabs = new JTabbedPane();
			painelTabs.setBounds(new java.awt.Rectangle(70,83,441,312));
			painelTabs.addTab("Cadastrar", null, getPainelCadastrar(), null);
			painelTabs.addTab("Consultar", null, getPainelConsultar(), null);
		}
		return painelTabs;
	}

	/**
	 * This method initializes painelCadastrar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelCadastrar() {
		if (painelCadastrar == null) {
			jlObs = new JLabel();
			jlObs.setBounds(new java.awt.Rectangle(30,199,84,23));
			jlObs.setText("Observação:");
			jlCnpj = new JLabel();
			jlCnpj.setBounds(new java.awt.Rectangle(30,135,54,21));
			jlCnpj.setText("Cnpj:");
			jlEmail = new JLabel();
			jlEmail.setBounds(new java.awt.Rectangle(28,103,38,16));
			jlEmail.setText("Email:");
			jlTelefone = new JLabel();
			jlTelefone.setBounds(new java.awt.Rectangle(28,170,54,16));
			jlTelefone.setText("Telefone:");
			jlEndereco = new JLabel();
			jlEndereco.setBounds(new java.awt.Rectangle(28,77,61,16));
			jlEndereco.setText("Endereço:");
			jlNome = new JLabel();
			jlNome.setBounds(new java.awt.Rectangle(28,46,38,16));
			jlNome.setText("Nome:");
			jlCodigo = new JLabel();
			jlCodigo.setBounds(new java.awt.Rectangle(28,15,52,16));
			jlCodigo.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.add(jlCodigo, null);
			painelCadastrar.add(jlNome, null);
			painelCadastrar.add(jlEndereco, null);
			painelCadastrar.add(jlTelefone, null);
			painelCadastrar.add(jlEmail, null);
			painelCadastrar.add(getTxtCodigo(), null);
			painelCadastrar.add(getTxtNome(), null);
			painelCadastrar.add(getTxtEndereco(), null);
			painelCadastrar.add(getTxtTelefone(), null);
			painelCadastrar.add(getTxtEmail(), null);
			painelCadastrar.add(getBtnSalvar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
			painelCadastrar.add(jlCnpj, null);
			painelCadastrar.add(jlObs, null);
			painelCadastrar.add(getTxtCnpj(), null);
			painelCadastrar.add(getTxtObs(), null);
		}
		return painelCadastrar;
	}

	/**
	 * This method initializes txtCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setBounds(new java.awt.Rectangle(93,17,88,20));
		}
		return txtCodigo;
	}

	/**
	 * This method initializes txtNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new java.awt.Rectangle(73,46,356,20));
		}
		return txtNome;
	}

	/**
	 * This method initializes txtEndereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEndereco() {
		if (txtEndereco == null) {
			txtEndereco = new JTextField();
			txtEndereco.setBounds(new java.awt.Rectangle(99,77,237,20));
		}
		return txtEndereco;
	}

	/**
	 * This method initializes txtTelefone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtTelefone() {
		if (txtTelefone == null) {
			txtTelefone = new JFormattedTextField(Mascara("(##)####-####"));
			txtTelefone.setBounds(new java.awt.Rectangle(86,170,89,20));
		}
		return txtTelefone;
	}

	/**
	 * This method initializes txtEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(new java.awt.Rectangle(75,103,202,20));
		}
		return txtEmail;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setBounds(new java.awt.Rectangle(27,257,78,16));
			btnSalvar.setText("Salvar");
			btnSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					evento_btnSalvar();
				}
			});
		}
		return btnSalvar;
	}

	/**
	 * This method initializes btnAlterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton();
			btnAlterar.setBounds(new java.awt.Rectangle(128,257,78,16));
			btnAlterar.setText("Alterar");
			btnAlterar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					evento_btnAlterar();
				}
			});
		}
		return btnAlterar;
	}

	/**
	 * This method initializes btnExcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton();
			btnExcluir.setBounds(new java.awt.Rectangle(229,257,78,16));
			btnExcluir.setText("Excluir");
			btnExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					evento_btnExcluir();
				}
			});
		}
		return btnExcluir;
	}

	/**
	 * This method initializes btnLimpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new java.awt.Rectangle(330,257,78,16));
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					evento_btnLimpar();
				}
			});
		}
		return btnLimpar;
	}

	/**
	 * This method initializes painelConsultar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelConsultar() {
		if (painelConsultar == null) {
			jlNomeConsultar = new JLabel();
			jlNomeConsultar.setBounds(new java.awt.Rectangle(27,21,125,16));
			jlNomeConsultar.setText("Consultar Por Nome:");
			painelConsultar = new JPanel();
			painelConsultar.setLayout(null);
			painelConsultar.add(jlNomeConsultar, null);
			painelConsultar.add(getTxtNomeConsultar(), null);
			painelConsultar.add(getJScrollPane(), null);
		}
		return painelConsultar;
	}

	/**
	 * This method initializes txtNomeConsultar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNomeConsultar() {
		if (txtNomeConsultar == null) {
			txtNomeConsultar = new JTextField();
			txtNomeConsultar.setBounds(new java.awt.Rectangle(159,20,240,20));
			txtNomeConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					evento_campo_consulta_nome();
				}
			});
		}
		return txtNomeConsultar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(14,56,403,217));
			jScrollPane.setViewportView(getTabelaconsultar());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tabelaconsultar	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaconsultar() {
		if (tabelaconsultar == null) {
			tabelaconsultar = new JTable();
			tabelaconsultar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					evento_tabela_preenche_campos();
				}
			});
		}
		return tabelaconsultar;
	}

	/**
	 * This method initializes txtCnpj	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCnpj() {
		if (txtCnpj == null) {
			txtCnpj = new JTextField();
			txtCnpj.setBounds(new java.awt.Rectangle(95,135,233,22));
		}
		return txtCnpj;
	}

	/**
	 * This method initializes txtObs	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtObs() {
		if (txtObs == null) {
			txtObs = new JTextField();
			txtObs.setBounds(new java.awt.Rectangle(122,200,247,22));
		}
		return txtObs;
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
	public FornecedorGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(621, 446);
		this.setContentPane(getJContentPane());
		this.setTitle("Fornecedor");
		defineModeloTabela();
		defineLarguraColunas();
		preencherTabela("");
	}
	
	public MaskFormatter Mascara(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask(Mascara); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter('_'); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}
	
	public void	evento_tabela_preenche_campos(){
		preencherCampos();
		painelTabs.setSelectedIndex(0);
	}
	
	public void preencherCampos(){
		int linhaSelecionada = tabelaconsultar.getSelectedRow();
		txtCodigo.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 0)));          
		txtNome.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 1)));          
		txtEndereco.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 2)));          
		txtEmail.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 3)));          
		txtTelefone.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 4))); 
		txtCnpj.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 5))); 
	    txtObs.setText((String)String.valueOf(tabelaModeloFornecedor.getValueAt(linhaSelecionada, 6))); 
	 	}
	
	public void evento_campo_consulta_nome(){
		limparTabela();
		preencherTabela(txtNomeConsultar.getText());
		txtNomeConsultar.requestFocusInWindow();
	}
	public void limparTabela(){
	       int tamanho = tabelaModeloFornecedor.getRowCount();
	        
	        for (int i = 0; i < tamanho; i++) {
	        	tabelaModeloFornecedor.removeRow(0);
	        }
	 
	}
	
	
	public void	evento_btnLimpar(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtCnpj.setText("");
		txtObs.setText("");
	}
	
	public void	evento_btnExcluir() {
		try {
			FornecedorDao excluir = new FornecedorDao();
			excluir.excluirFornecedor(Integer.parseInt(txtCodigo.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

	
	public void	evento_btnAlterar(){
		try {
			FornecedorBean forn= new FornecedorBean();
			forn.setCodigo(Integer.parseInt(txtCodigo.getText()));
			forn.setNome(txtNome.getText());
			forn.setEndereco(txtEndereco.getText());
			forn.setEmail(txtEmail.getText());
			forn.setTelefone(txtTelefone.getText());
			forn.setCnpj(txtCnpj.getText());
			forn.setObs(txtObs.getText());
			
			FornecedorDao alterar = new FornecedorDao();
			alterar.alterarFornecedor(forn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void preencherTabela(String nome) {
		listafornecedor.removeAll(listafornecedor);
		
		try {
			FornecedorDao a = new FornecedorDao();
			listafornecedor = a.consultarFornecedor(nome); 
			for (FornecedorBean fornecedor : listafornecedor) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(fornecedor.getCodigo())); //0
				linha.add(fornecedor.getNome()); //1
				linha.add(fornecedor.getEndereco());//2
				linha.add(fornecedor.getEmail()); //3
				linha.add(fornecedor.getTelefone());//4
				linha.add(fornecedor.getCnpj());
				linha.add(fornecedor.getObs());
				tabelaModeloFornecedor.addRow(linha);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro Interno", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}

	
	private void defineLarguraColunas() {
		TableColumn tc = null;
		// codigo
				tc = tabelaconsultar.getColumnModel().getColumn(0);
				tc.setPreferredWidth(55);
				tc.setMaxWidth(55);
				tc.setMinWidth(55);
		// Nome
				tc = tabelaconsultar.getColumnModel().getColumn(1);
				tc.setPreferredWidth(110);
				tc.setMaxWidth(110);
				tc.setMinWidth(110);
		// Endereço
				tc = tabelaconsultar.getColumnModel().getColumn(2);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(70);
				tc.setMinWidth(70);
		// Numero
				tc = tabelaconsultar.getColumnModel().getColumn(3);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(70);
				tc.setMinWidth(70);
		// Bairro
				tc = tabelaconsultar.getColumnModel().getColumn(4);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Cep
				tc = tabelaconsultar.getColumnModel().getColumn(5);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Cidade
				tc = tabelaconsultar.getColumnModel().getColumn(6);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);

				tabelaconsultar.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}

	
	private void defineModeloTabela() {
		tabelaModeloFornecedor = new DefaultTableModel();
		tabelaconsultar.setModel(tabelaModeloFornecedor);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Nome");
		titulo.add("Endereço");
		titulo.add("Email");
		titulo.add("Telefone");
		titulo.add("Cnpj");
		titulo.add("Obs");
		tabelaModeloFornecedor.setColumnIdentifiers(titulo);
	}
	
	public void	evento_btnSalvar(){
		try {
			FornecedorBean forn= new FornecedorBean();
			forn.setNome(txtNome.getText());
			forn.setEndereco(txtEndereco.getText());
			forn.setEmail(txtEmail.getText());
			forn.setTelefone(txtTelefone.getText());
			forn.setCnpj(txtCnpj.getText());
			forn.setObs(txtObs.getText());
			FornecedorDao salvar = new FornecedorDao();
			salvar.cadastrarFornecedor(forn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	


	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPainelBotoes(), null);
			jContentPane.add(getPainelTabs(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
