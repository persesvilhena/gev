package br.com.projeto.gui;

//import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.ClienteBean;
//import br.com.projeto.bean.UsuarioBean;
import br.com.projeto.dao.CidadeDao;
import br.com.projeto.dao.ClienteDao;
//import br.com.projeto.dao.UsuarioDao;
import br.com.projeto.validador.Validador;

@SuppressWarnings("serial")
public class ClienteGui extends JFrame {

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
	private JLabel jlNumero = null;
	private JLabel jlBairro = null;
	private JLabel jlCep = null;
	private JLabel jlCidade = null;
	private JLabel jlEstado = null;
	private JLabel jlTelefone = null;
	private JLabel jlEmail = null;
	private JLabel jlCpf = null;
	private JLabel jlRg = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private JTextField txtEndereco = null;
	private JTextField txtNumero = null;
	private JTextField txtBairro = null;
	private JFormattedTextField txtCep = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCidade = null;
	private JTextField txtEstado = null;
	private JFormattedTextField txtTelefone = null;
	private JTextField txtEmail = null;
	private JFormattedTextField txtCpf = null;
	private JFormattedTextField txtRg = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JPanel painelConsultar = null;
	private JLabel jlNomeConsultar = null;
	private JTextField txtNomeConsultar = null;
	private JScrollPane jScrollPane = null;
	private JTable tabelaconsultar = null;
	private List<CidadeBean> listaCidades = new ArrayList<CidadeBean>();
	private List<Integer> listaCodigosCidades = new ArrayList<Integer>();
	private DefaultTableModel tabelaModeloCliente;
	private List<ClienteBean> listacliente = new ArrayList<ClienteBean>();
	private JLabel jlNascimento = null;
	private JFormattedTextField txtNascimento = null;
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
			btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					painelTabs.setSelectedIndex(0);
				}
			});
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
			painelTabs.setBounds(new java.awt.Rectangle(0,83,604,325));
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
			jlNascimento = new JLabel();
			jlNascimento.setBounds(new java.awt.Rectangle(277,201,76,16));
			jlNascimento.setText("Nascimento:");
			jlRg = new JLabel();
			jlRg.setBounds(new java.awt.Rectangle(155,201,25,16));
			jlRg.setText("RG:");
			jlCpf = new JLabel();
			jlCpf.setBounds(new java.awt.Rectangle(28,201,29,16));
			jlCpf.setText("Cpf:");
			jlEmail = new JLabel();
			jlEmail.setBounds(new java.awt.Rectangle(185,171,38,16));
			jlEmail.setText("Email:");
			jlTelefone = new JLabel();
			jlTelefone.setBounds(new java.awt.Rectangle(28,170,54,16));
			jlTelefone.setText("Telefone:");
			jlEstado = new JLabel();
			jlEstado.setBounds(new java.awt.Rectangle(204,137,53,16));
			jlEstado.setText("Estado:");
			jlCidade = new JLabel();
			jlCidade.setBounds(new java.awt.Rectangle(28,139,46,16));
			jlCidade.setText("Cidade:");
			jlCep = new JLabel();
			jlCep.setBounds(new java.awt.Rectangle(287,109,38,16));
			jlCep.setText("Cep:");
			jlBairro = new JLabel();
			jlBairro.setBounds(new java.awt.Rectangle(28,108,38,16));
			jlBairro.setText("Bairro:");
			jlNumero = new JLabel();
			jlNumero.setBounds(new java.awt.Rectangle(344,77,38,16));
			jlNumero.setText("Nº:");
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
			painelCadastrar.add(jlNumero, null);
			painelCadastrar.add(jlBairro, null);
			painelCadastrar.add(jlCep, null);
			painelCadastrar.add(jlCidade, null);
			painelCadastrar.add(jlEstado, null);
			painelCadastrar.add(jlTelefone, null);
			painelCadastrar.add(jlEmail, null);
			painelCadastrar.add(jlCpf, null);
			painelCadastrar.add(jlRg, null);
			painelCadastrar.add(getTxtCodigo(), null);
			painelCadastrar.add(getTxtNome(), null);
			painelCadastrar.add(getTxtEndereco(), null);
			painelCadastrar.add(getTxtNumero(), null);
			painelCadastrar.add(getTxtBairro(), null);
			painelCadastrar.add(getTxtCep(), null);
			painelCadastrar.add(getCboCidade(), null);
			painelCadastrar.add(getTxtEstado(), null);
			painelCadastrar.add(getTxtTelefone(), null);
			painelCadastrar.add(getTxtEmail(), null);
			painelCadastrar.add(getTxtCpf(), null);
			painelCadastrar.add(getTxtRg(), null);
			painelCadastrar.add(getBtnSalvar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
			painelCadastrar.add(jlNascimento, null);
			painelCadastrar.add(getTxtNascimento(), null);
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
	 * This method initializes txtNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setBounds(new java.awt.Rectangle(385,77,44,20));
		}
		return txtNumero;
	}

	/**
	 * This method initializes txtBairro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JTextField();
			txtBairro.setBounds(new java.awt.Rectangle(77,108,201,20));
		}
		return txtBairro;
	}

	/**
	 * This method initializes txtCep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtCep() {
		if (txtCep == null) {
			txtCep = new JFormattedTextField(Mascara("##.###-###"));
			txtCep.setBounds(new java.awt.Rectangle(337,108,92,20));
		}
		return txtCep;
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
			cboCidade.setBounds(new java.awt.Rectangle(82,139,120,16));
		}
		return cboCidade;
	}

	/**
	 * This method initializes txtEstado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEstado() {
		if (txtEstado == null) {
			txtEstado = new JTextField();
			txtEstado.setBounds(new java.awt.Rectangle(262,139,167,20));
		}
		return txtEstado;
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
			txtEmail.setBounds(new java.awt.Rectangle(227,170,202,20));
		}
		return txtEmail;
	}

	/**
	 * This method initializes txtCpf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(Mascara("###.###.###-##"));
			txtCpf.setBounds(new java.awt.Rectangle(54,199,95,20));
		}
		return txtCpf;
	}

	/**
	 * This method initializes txtRg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtRg() {
		if (txtRg == null) {
			txtRg = new JFormattedTextField(Mascara("##-##.###.###"));
			txtRg.setBounds(new java.awt.Rectangle(183,199,92,20));
		}
		return txtRg;
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
	 * This method initializes txtNascimento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtNascimento() {
		if (txtNascimento == null) {
			txtNascimento = new JFormattedTextField(Mascara("##/##/####"));
			txtNascimento.setBounds(new java.awt.Rectangle(351,200,75,20));
		}
		return txtNascimento;
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
	public ClienteGui() {
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
		this.setTitle("Cliente");
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
	
	public void	evento_tabela_preenche_campos(){
		preencherCampos();
		painelTabs.setSelectedIndex(0);
	}
	
	public void preencherCampos(){
		int linhaSelecionada = tabelaconsultar.getSelectedRow();
		txtCodigo.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 0)));          
		txtNome.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 1)));          
		txtEndereco.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 2)));          
		txtNumero.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 3)));          
		txtBairro.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 4))); 
		txtCep.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 5))); 
	    cboCidade.setSelectedItem((String) tabelaModeloCliente.getValueAt(linhaSelecionada, 6));
	    txtEstado.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 7))); 
	    txtTelefone.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 8))); 
	    txtEmail.setText((String)String.valueOf(tabelaModeloCliente.getValueAt(linhaSelecionada, 9))); 
		txtCpf.setText((String)tabelaModeloCliente.getValueAt(linhaSelecionada, 7));
		txtNascimento.setText((String)tabelaModeloCliente.getValueAt(linhaSelecionada, 6));
	 	}
	
	public void evento_campo_consulta_nome(){
		limparTabela();
		preencherTabela(txtNomeConsultar.getText());
		txtNomeConsultar.requestFocusInWindow();
	}
	public void limparTabela(){
	       int tamanho = tabelaModeloCliente.getRowCount();
	        
	        for (int i = 0; i < tamanho; i++) {
	        	tabelaModeloCliente.removeRow(0);
	        }
	 
	}
	
	
	public void	evento_btnLimpar(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		cboCidade.setSelectedIndex(0);
		txtEstado.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtCpf.setText("");
		txtRg.setText("");
		txtNascimento.setText("");
	}
	
	public void	evento_btnExcluir() {
		try {
			ClienteDao excluir = new ClienteDao();
			excluir.excluirCliente(Integer.parseInt(txtCodigo.getText()));
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
			ClienteBean cli= new ClienteBean();
			cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
			cli.setNome(txtNome.getText());
			cli.setEndereco(txtEndereco.getText());
			cli.setNumero(txtNumero.getText());
			cli.setBairro(txtBairro.getText());
			cli.setCep(txtCep.getText());
			if (cboCidade.getSelectedIndex() != 0) {
				CidadeBean objCidade = new CidadeBean();
				objCidade.setCodCid(listaCodigosCidades.get(cboCidade.getSelectedIndex()));
				objCidade.setNomCid((String) cboCidade.getItemAt(cboCidade.getSelectedIndex()));				
				cli.setCidade(objCidade);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCidade.requestFocusInWindow();
				return;
			}
			cli.setEstado(txtEstado.getText());
			cli.setTelefone(txtTelefone.getText());
			cli.setEmail(txtEmail.getText());
			cli.setCpf(txtCpf.getText());
			cli.setRg(txtRg.getText());
			if (Validador.data(txtNascimento.getText())) {
				try {
					cli.setNascimento(Validador.formatadorDatas.parse(txtNascimento.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtNascimento.requestFocusInWindow();
				return;
			}
			ClienteDao alterar = new ClienteDao();
			alterar.alterarCliente(cli);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void preencherTabela(String nome) {
		listacliente.removeAll(listacliente);
		
		try {
			ClienteDao a = new ClienteDao();
			listacliente = a.consultarCliente(nome); 
			for (ClienteBean cliente : listacliente) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(cliente.getCodigo())); //0
				linha.add(cliente.getNome()); //1
				linha.add(cliente.getEndereco());//2
				linha.add(cliente.getNumero()); //3
				linha.add(cliente.getBairro());//4
				linha.add(cliente.getCep());
				linha.add(cliente.getCidade().getNomCid());
				linha.add(cliente.getEstado());
				linha.add(cliente.getTelefone());
				linha.add(cliente.getEmail());
				linha.add(cliente.getCpf());
				linha.add(cliente.getRg());
				Date dataNasc = cliente.getNascimento();
				String strData = Validador.formatadorDatas.format(dataNasc);
				linha.add(strData);
				tabelaModeloCliente.addRow(linha);
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
		// Estado
				tc = tabelaconsultar.getColumnModel().getColumn(7);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Telefone
				tc = tabelaconsultar.getColumnModel().getColumn(8);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Email
				tc = tabelaconsultar.getColumnModel().getColumn(9);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
		// Cpf
				tc = tabelaconsultar.getColumnModel().getColumn(10);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);		
		// RG
				tc = tabelaconsultar.getColumnModel().getColumn(11);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);	
		// Nascimento
				tc = tabelaconsultar.getColumnModel().getColumn(11);
				tc.setPreferredWidth(70);
				tc.setMaxWidth(100);
				tc.setMinWidth(70);
				
				tabelaconsultar.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}

	
	private void defineModeloTabela() {
		tabelaModeloCliente = new DefaultTableModel();
		tabelaconsultar.setModel(tabelaModeloCliente);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Nome");
		titulo.add("Endereço");
		titulo.add("Numero");
		titulo.add("Bairro");
		titulo.add("Cep");
		titulo.add("Cidade");
		titulo.add("Estado");
		titulo.add("Telefone");
		titulo.add("Email");
		titulo.add("CPF");
		titulo.add("RG");
		titulo.add("Nascimento");
		tabelaModeloCliente.setColumnIdentifiers(titulo);
	}
	
	public void	evento_btnSalvar(){
		try {
			ClienteBean cli= new ClienteBean();
			cli.setNome(txtNome.getText());
			cli.setEndereco(txtEndereco.getText());
			cli.setNumero(txtNumero.getText());
			cli.setBairro(txtBairro.getText());
			cli.setCep(txtCep.getText());
			if (cboCidade.getSelectedIndex() != 0) {
				CidadeBean objCidade = new CidadeBean();
				objCidade.setCodCid(listaCodigosCidades.get(cboCidade.getSelectedIndex()));
				objCidade.setNomCid((String) cboCidade.getItemAt(cboCidade.getSelectedIndex()));				
				cli.setCidade(objCidade);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCidade.requestFocusInWindow();
				return;
			}
			cli.setEstado(txtEstado.getText());
			cli.setTelefone(txtTelefone.getText());
			cli.setEmail(txtEmail.getText());
			cli.setCpf(txtCpf.getText());
			cli.setRg(txtRg.getText());
			//campo data
			if (Validador.data(txtNascimento.getText())) {
				try {
					cli.setNascimento(Validador.formatadorDatas.parse(txtNascimento.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtNascimento.requestFocusInWindow();
				return;
			}
			ClienteDao salvar = new ClienteDao();
			salvar.cadastrarCliente(cli);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	
	@SuppressWarnings("unchecked")
	private void preencherComboCidade(){
		cboCidade.addItem("");
		listaCodigosCidades.add(-1);
		try {
			
			// consulta cidades
			CidadeDao a = new CidadeDao();
			listaCidades = a.consultarCidades();
			// para cada cidade consultada
			for (CidadeBean objCidade : listaCidades) {
				// adiciona a cidade no combo box
				cboCidade.addItem(objCidade.getNomCid());
				listaCodigosCidades.add(objCidade.getCodCid());
			}
		} catch (Exception e) {
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
