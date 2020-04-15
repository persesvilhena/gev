package br.com.projeto.gui;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.UsuarioBean;
import br.com.projeto.dao.CidadeDao;
import br.com.projeto.dao.UsuarioDao;
import br.com.projeto.validador.Validador;

@SuppressWarnings("serial")
public class UsuarioGui extends JFrame {

	private JPanel jContentPane = null;
	private JPanel PainelBotoes = null;
	private JButton btnRegistrar = null;
	private JButton btnListar = null;
	private JButton btnSair = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JPanel painelConsultar = null;
	private JLabel jlCodigo = null;
	private JLabel jlNome = null;
	private JLabel jlLogin = null;
	private JLabel jlSenha = null;
	private JLabel jlTipo = null;
	private JLabel jlData = null;
	private JLabel jlCpf = null;
	private JLabel jlCidade = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private JTextField txtLogin = null;
	private JPasswordField txtSenha = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipo = null;
	private JFormattedTextField txtData = null;
	private JFormattedTextField txtCpf = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCidade = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JTextField txtNomeConsulta = null;
	private JLabel jlNomeConsulta = null;
	private JScrollPane jScrollPane = null;
	private JTable tabelaConsulta = null;
	private List<CidadeBean> listaCidades = new ArrayList<CidadeBean>();
	private List<Integer> listaCodigosCidades = new ArrayList<Integer>();
	private DefaultTableModel tabelaModeloUsuario;
	private List<UsuarioBean> listausuario = new ArrayList<UsuarioBean>();
	@SuppressWarnings("unused")
	private MaskFormatter formatadorDat;
	@SuppressWarnings("unused")
	private MaskFormatter formatadorCPF;
	/**
	 * This method initializes PainelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelBotoes() {
		if (PainelBotoes == null) {
			PainelBotoes = new JPanel();
			PainelBotoes.setLayout(null);
			PainelBotoes.setBounds(new java.awt.Rectangle(45,16,631,53));
			PainelBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1,1,1,1,java.awt.Color.black));
			PainelBotoes.add(getBtnRegistrar(), null);
			PainelBotoes.add(getBtnListar(), null);
			PainelBotoes.add(getBtnSair(), null);
		}
		return PainelBotoes;
	}

	/**
	 * This method initializes btnRegistrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton();
			btnRegistrar.setBounds(new java.awt.Rectangle(8,11,103,30));
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
			btnListar.setBounds(new java.awt.Rectangle(255,11,103,30));
			btnListar.setText("Listar");
			btnListar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
			btnSair.setBounds(new java.awt.Rectangle(499,11,103,30));
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
			painelTabs.setBounds(new java.awt.Rectangle(45,94,647,357));
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
			jlCidade = new JLabel();
			jlCidade.setBounds(new java.awt.Rectangle(17,249,73,25));
			jlCidade.setText("Cidade:");
			jlCpf = new JLabel();
			jlCpf.setBounds(new java.awt.Rectangle(17,212,72,27));
			jlCpf.setText("Cpf:");
			jlData = new JLabel();
			jlData.setBounds(new java.awt.Rectangle(16,180,72,25));
			jlData.setText("Data Nasc:");
			jlTipo = new JLabel();
			jlTipo.setBounds(new java.awt.Rectangle(17,149,72,26));
			jlTipo.setText("Tipo:");
			jlSenha = new JLabel();
			jlSenha.setBounds(new java.awt.Rectangle(16,117,74,24));
			jlSenha.setText("Senha:");
			jlLogin = new JLabel();
			jlLogin.setBounds(new java.awt.Rectangle(16,82,74,29));
			jlLogin.setText("Login:");
			jlNome = new JLabel();
			jlNome.setBounds(new java.awt.Rectangle(17,45,74,24));
			jlNome.setText("Nome:");
			jlCodigo = new JLabel();
			jlCodigo.setBounds(new java.awt.Rectangle(17,8,75,26));
			jlCodigo.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.add(jlCodigo, null);
			painelCadastrar.add(jlNome, null);
			painelCadastrar.add(jlLogin, null);
			painelCadastrar.add(jlSenha, null);
			painelCadastrar.add(jlTipo, null);
			painelCadastrar.add(jlData, null);
			painelCadastrar.add(jlCpf, null);
			painelCadastrar.add(jlCidade, null);
			painelCadastrar.add(getTxtCodigo(), null);
			painelCadastrar.add(getTxtNome(), null);
			painelCadastrar.add(getTxtLogin(), null);
			painelCadastrar.add(getTxtSenha(), null);
			painelCadastrar.add(getCboTipo(), null);
			painelCadastrar.add(getTxtData(), null);
			painelCadastrar.add(getTxtCpf(), null);
			painelCadastrar.add(getCboCidade(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnSalvar(), null);
		}
		return painelCadastrar;
	}

	/**
	 * This method initializes painelConsultar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelConsultar() {
		if (painelConsultar == null) {
			jlNomeConsulta = new JLabel();
			jlNomeConsulta.setBounds(new java.awt.Rectangle(14,15,129,25));
			jlNomeConsulta.setText("Consultar por Nome:");
			painelConsultar = new JPanel();
			painelConsultar.setLayout(null);
			painelConsultar.add(getTxtNomeConsulta(), null);
			painelConsultar.add(jlNomeConsulta, null);
			painelConsultar.add(getJScrollPane(), null);
		}
		return painelConsultar;
	}

	/**
	 * This method initializes txtCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setBounds(new java.awt.Rectangle(149,10,446,27));
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
			txtNome.setBounds(new java.awt.Rectangle(148,46,446,24));
		}
		return txtNome;
	}

	/**
	 * This method initializes txtLogin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(new java.awt.Rectangle(148,82,446,24));
		}
		return txtLogin;
	}

	/**
	 * This method initializes txtSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setBounds(new java.awt.Rectangle(148,114,446,25));
		}
		return txtSenha;
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
			cboTipo.setBounds(new java.awt.Rectangle(148,146,446,25));
		}
		return cboTipo;
	}

	/**
	 * This method initializes txtData	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtData() {
		if (txtData == null) {
			txtData = new JFormattedTextField(Mascara("##/##/####"));
			txtData.setBounds(new java.awt.Rectangle(148,178,446,25));
		}
		return txtData;
	}

	/**
	 * This method initializes txtCpf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(Mascara("###.###.###-##"));
			txtCpf.setBounds(new java.awt.Rectangle(148,215,446,24));
		}
		return txtCpf;
	}

	/**
	 * This method initializes cboCidade	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox getCboCidade() {
		if (cboCidade == null) {
			cboCidade = new JComboBox();
			cboCidade.setBounds(new java.awt.Rectangle(148,249,446,23));
		}
		return cboCidade;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setText("Salvar");
			btnSalvar.setBounds(new java.awt.Rectangle(6,295,126,31));
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
			btnAlterar.setText("Alterar");
			btnAlterar.setBounds(new java.awt.Rectangle(165,295,126,31));
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
			btnExcluir.setText("Excluir");
			btnExcluir.setBounds(new java.awt.Rectangle(333,295,126,31));
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
			btnLimpar.setText("Limpar");
			btnLimpar.setBounds(new java.awt.Rectangle(499,295,126,31));
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					evento_btnLimpar();
				}
			});
		}
		return btnLimpar;
	}

	/**
	 * This method initializes txtNomeConsulta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNomeConsulta() {
		if (txtNomeConsulta == null) {
			txtNomeConsulta = new JTextField();
			txtNomeConsulta.setBounds(new java.awt.Rectangle(151,15,464,24));
			txtNomeConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					evento_campo_consulta_nome();
				}
			});
		}
		return txtNomeConsulta;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(14,44,601,267));
			jScrollPane.setViewportView(getTabelaConsulta());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tabelaConsulta	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaConsulta() {
		if (tabelaConsulta == null) {
			tabelaConsulta = new JTable();
			tabelaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					evento_tabela_preenche_campos();
				}
			});
		}
		return tabelaConsulta;
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
	public UsuarioGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(740, 493);
		this.setContentPane(getJContentPane());
		this.setTitle("Manter Usuario");
		preencherComboTipo();
		preencherComboCidade();
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


	
	private void defineLarguraColunas() {
		TableColumn tc = null;
		// codigo
				tc = tabelaConsulta.getColumnModel().getColumn(0);
				tc.setPreferredWidth(55);
				tc.setMaxWidth(55);
				tc.setMinWidth(55);
		// Nome
				tc = tabelaConsulta.getColumnModel().getColumn(1);
				tc.setPreferredWidth(110);
				tc.setMaxWidth(110);
				tc.setMinWidth(110);
		// login
				tc = tabelaConsulta.getColumnModel().getColumn(2);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(70);
				tc.setMinWidth(70);
		// senha
				tc = tabelaConsulta.getColumnModel().getColumn(3);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(70);
				tc.setMinWidth(70);
		// tipo de acesso
				tc = tabelaConsulta.getColumnModel().getColumn(4);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Cidade
				tc = tabelaConsulta.getColumnModel().getColumn(5);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Data Nascimento
				tc = tabelaConsulta.getColumnModel().getColumn(6);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// CPF
				tc = tabelaConsulta.getColumnModel().getColumn(7);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		tabelaConsulta.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}


	
	private void defineModeloTabela() {
		tabelaModeloUsuario = new DefaultTableModel();
		tabelaConsulta.setModel(tabelaModeloUsuario);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Nome");
		titulo.add("Login");
		titulo.add("Senha");
		titulo.add("Tipo de Acesso");
		titulo.add("Cidade");
		titulo.add("Nascimento");
		titulo.add("CPF");
		tabelaModeloUsuario.setColumnIdentifiers(titulo);
	}

	
	public void evento_campo_consulta_nome(){
		LimparTabela();
		preencherTabela(txtNomeConsulta.getText());
		txtNomeConsulta.requestFocusInWindow();
	}
	private void preencherTabela(String nome) {
		listausuario.removeAll(listausuario);
		
		try {
			UsuarioDao a = new UsuarioDao();
			listausuario = a.consultarUsuarios(nome); 
			for (UsuarioBean usuario : listausuario) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(usuario.getCodUsu())); //0
				linha.add(usuario.getNomeUsu()); //1
				linha.add(usuario.getLoginUsu());//2
				linha.add(usuario.getSenha()); //3
				linha.add(usuario.getTipoAcesso());//4
				linha.add(usuario.getCidadeUsu().getNomCid());
				Date dataNasc = usuario.getData();
				String strData = Validador.formatadorDatas.format(dataNasc);
				linha.add(strData);
				linha.add(usuario.getCpf());
				tabelaModeloUsuario.addRow(linha);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro Interno", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}

	
	public void LimparTabela(){
		int tamanho = tabelaModeloUsuario.getRowCount();
		for (int i = 0; i < tamanho; i++){
			tabelaModeloUsuario.removeRow(0);
		}
	}
	
	
	public void evento_tabela_preenche_campos(){
		preencherComboTipo();
		preencherCampos();
		painelTabs.setSelectedIndex(0);
	}
	public void preencherCampos(){
		int linhaSelecionada = tabelaConsulta.getSelectedRow();
		txtCodigo.setText((String)String.valueOf(tabelaModeloUsuario.getValueAt(linhaSelecionada, 0)));          
		txtNome.setText((String)String.valueOf(tabelaModeloUsuario.getValueAt(linhaSelecionada, 1)));          
		txtLogin.setText((String)String.valueOf(tabelaModeloUsuario.getValueAt(linhaSelecionada, 2)));          
		txtSenha.setText((String)String.valueOf(tabelaModeloUsuario.getValueAt(linhaSelecionada, 3)));          
		cboTipo.setSelectedItem((String) tabelaModeloUsuario.getValueAt(linhaSelecionada, 4));
	    cboCidade.setSelectedItem((String) tabelaModeloUsuario.getValueAt(linhaSelecionada, 5));
		txtData.setText((String)tabelaModeloUsuario.getValueAt(linhaSelecionada, 6));
		txtCpf.setText((String)tabelaModeloUsuario.getValueAt(linhaSelecionada, 7));
	 	}

	
	public void	evento_btnExcluir() {
		try {
			UsuarioDao excluir = new UsuarioDao();
			excluir.excluirUsuario(Integer.parseInt(txtCodigo.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

	
	@SuppressWarnings("deprecation")
	public void	evento_btnAlterar(){
		try {
			UsuarioBean usu = new UsuarioBean();
			usu.setCodUsu(Integer.parseInt(txtCodigo.getText()));
			usu.setNomeUsu(txtNome.getText());
			usu.setLoginUsu(txtLogin.getText());
			usu.setSenha(txtSenha.getText());
			usu.setTipoAcesso((String)cboTipo.getSelectedItem());
			if (cboCidade.getSelectedIndex() != 0) {
				CidadeBean objCidade = new CidadeBean();
				objCidade.setCodCid(listaCodigosCidades.get(cboCidade.getSelectedIndex()));
				objCidade.setNomCid((String) cboCidade.getItemAt(cboCidade.getSelectedIndex()));				
				usu.setCidadeUsu(objCidade);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCidade.requestFocusInWindow();
				return;
			}
			//campo data
			if (Validador.data(txtData.getText())) {
				try {
					usu.setData(Validador.formatadorDatas.parse(txtData.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtData.requestFocusInWindow();
				return;
			}
			usu.setCpf(txtCpf.getText());
			UsuarioDao alterar = new UsuarioDao();
			alterar.alterarUsuario(usu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void	evento_btnSalvar(){
		try {
			UsuarioBean usu = new UsuarioBean();
			usu.setNomeUsu(txtNome.getText());
			usu.setLoginUsu(txtLogin.getText());
			usu.setSenha(txtSenha.getText());
			usu.setTipoAcesso((String)cboTipo.getSelectedItem());
			//campo cidade
			if (cboCidade.getSelectedIndex() != 0) {
				CidadeBean objCidade = new CidadeBean();
				objCidade.setCodCid(listaCodigosCidades.get(cboCidade.getSelectedIndex()));
				objCidade.setNomCid((String) cboCidade.getItemAt(cboCidade.getSelectedIndex()));				
				usu.setCidadeUsu(objCidade);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCidade.requestFocusInWindow();
				return;
			}
			//campo data
			if (Validador.data(txtData.getText())) {
				try {
					usu.setData(Validador.formatadorDatas.parse(txtData.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtData.requestFocusInWindow();
				return;
			}
			usu.setCpf(txtCpf.getText());
			UsuarioDao salvar = new UsuarioDao();
			salvar.cadastrarUsuario(usu);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	public void evento_btnLimpar(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		cboTipo.setSelectedIndex(0);
		cboCidade.setSelectedIndex(0);
		txtData.setText("");
		txtCpf.setText("");
	}
	
	
	@SuppressWarnings("unchecked")
	public void preencherComboCidade(){
		cboCidade.addItem("");
		listaCodigosCidades.add(-1);
		try {
			
			//consulta cidades
			CidadeDao a = new CidadeDao();
			listaCidades = a.consultarCidades();
			//para cada cidade consultada
			for (CidadeBean objCidade : listaCidades){
			  //adiciona a cidade no combo box
			cboCidade.addItem(objCidade.getNomCid());
			listaCodigosCidades.add(objCidade.getCodCid());
			}
		} catch (Exception e) {
		e.printStackTrace();		
	}	
		
}
	@SuppressWarnings("unchecked")
	public void preencherComboTipo(){
		cboTipo.removeAllItems();
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPainelBotoes(), null);
			jContentPane.add(getPainelTabs(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
