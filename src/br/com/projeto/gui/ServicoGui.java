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

//import br.com.projeto.bean.CidadeBean;
import br.com.projeto.bean.ClienteBean;
import br.com.projeto.bean.ServicoBean;
//import br.com.projeto.bean.UsuarioBean;
import br.com.projeto.dao.ServicoDao;
import br.com.projeto.dao.ClienteDao;
import br.com.projeto.validador.Validador;

@SuppressWarnings("serial")
public class ServicoGui extends JFrame {

	private JPanel jContentPane = null;
	private JPanel painelBotoes = null;
	private JButton btnRegistrar = null;
	private JButton btnListar = null;
	private JButton btnSair = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JLabel jlCodigo = null;
	private JTextField txtCodigo = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCliente = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JPanel painelConsultar = null;
	private JLabel jlNomeConsultar = null;
	private JTextField txtNomeConsultar = null;
	private JScrollPane jScrollPane = null;
	private JTable tabelaconsultar = null;
	private List<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
	private List<Integer> listaCodigosCidades = new ArrayList<Integer>();
	private DefaultTableModel tabelaModeloServico;
	private List<ServicoBean> listaservico = new ArrayList<ServicoBean>();
	private JLabel jlData = null;
	private JFormattedTextField txtData = null;
	private JLabel jlDescricao = null;
	private JLabel jlTotal = null;
	private JTextField txtDescricao = null;
	private JTextField txtTotal = null;
	private JLabel jlCliente = null;
	/**
	 * This method initializes painelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelBotoes() {
		if (painelBotoes == null) {
			painelBotoes = new JPanel();
			painelBotoes.setLayout(null);
			painelBotoes.setBounds(new java.awt.Rectangle(19,14,569,62));
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
			btnRegistrar.setBounds(new java.awt.Rectangle(28,10,148,39));
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
			btnListar.setBounds(new java.awt.Rectangle(204,10,147,39));
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
			btnSair.setBounds(new java.awt.Rectangle(379,10,159,39));
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
			jlCliente = new JLabel();
			jlCliente.setBounds(new java.awt.Rectangle(14,41,70,35));
			jlCliente.setText("Cliente:");
			jlTotal = new JLabel();
			jlTotal.setBounds(new java.awt.Rectangle(14,172,70,35));
			jlTotal.setText("Total:");
			jlDescricao = new JLabel();
			jlDescricao.setBounds(new java.awt.Rectangle(14,81,70,35));
			jlDescricao.setText("Descrição:");
			jlData = new JLabel();
			jlData.setBounds(new java.awt.Rectangle(14,209,70,35));
			jlData.setText("Data:");
			jlCodigo = new JLabel();
			jlCodigo.setBounds(new java.awt.Rectangle(14,5,70,35));
			jlCodigo.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.add(jlCodigo, null);
			painelCadastrar.add(getTxtCodigo(), null);
			painelCadastrar.add(getCboCliente(), null);
			painelCadastrar.add(getBtnSalvar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
			painelCadastrar.add(jlData, null);
			painelCadastrar.add(getTxtData(), null);
			painelCadastrar.add(jlDescricao, null);
			painelCadastrar.add(jlTotal, null);
			painelCadastrar.add(getTxtDescricao(), null);
			painelCadastrar.add(getTxtTotal(), null);
			painelCadastrar.add(jlCliente, null);
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
			txtCodigo.setBounds(new java.awt.Rectangle(90,5,450,35));
		}
		return txtCodigo;
	}

	/**
	 * This method initializes cboCliente	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox getCboCliente() {
		if (cboCliente == null) {
			cboCliente = new JComboBox();
			cboCliente.setBounds(new java.awt.Rectangle(90,43,450,35));
		}
		return cboCliente;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setBounds(new java.awt.Rectangle(11,252,130,40));
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
			btnAlterar.setBounds(new java.awt.Rectangle(152,252,124,40));
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
			btnExcluir.setBounds(new java.awt.Rectangle(287,252,149,40));
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
			btnLimpar.setBounds(new java.awt.Rectangle(447,252,141,40));
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
			jScrollPane.setBounds(new java.awt.Rectangle(14,56,574,217));
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
	 * This method initializes txtData	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JFormattedTextField getTxtData() {
		if (txtData == null) {
			txtData = new JFormattedTextField(Mascara("##/##/####"));
			txtData.setBounds(new java.awt.Rectangle(90,210,75,35));
		}
		return txtData;
	}

	/**
	 * This method initializes txtDescricao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDescricao() {
		if (txtDescricao == null) {
			txtDescricao = new JTextField();
			txtDescricao.setBounds(new java.awt.Rectangle(90,82,492,86));
		}
		return txtDescricao;
	}

	/**
	 * This method initializes txtTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setBounds(new java.awt.Rectangle(90,172,452,35));
		}
		return txtTotal;
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
	public ServicoGui() {
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
		this.setTitle("Serviços");
		preencherComboCliente();
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
		txtCodigo.setText((String)String.valueOf(tabelaModeloServico.getValueAt(linhaSelecionada, 0)));
		cboCliente.setSelectedItem((String) tabelaModeloServico.getValueAt(linhaSelecionada, 1));
	    txtDescricao.setText((String)String.valueOf(tabelaModeloServico.getValueAt(linhaSelecionada, 2))); 
	    txtTotal.setText((String)String.valueOf(tabelaModeloServico.getValueAt(linhaSelecionada, 3))); 
		txtData.setText((String)tabelaModeloServico.getValueAt(linhaSelecionada, 4));
	 	}
	
	public void evento_campo_consulta_nome(){
		limparTabela();
		preencherTabela(txtNomeConsultar.getText());
		txtNomeConsultar.requestFocusInWindow();
	}
	public void limparTabela(){
	       int tamanho = tabelaModeloServico.getRowCount();
	        
	        for (int i = 0; i < tamanho; i++) {
	        	tabelaModeloServico.removeRow(0);
	        }
	 
	}
	
	
	public void	evento_btnLimpar(){
		txtCodigo.setText("");
		cboCliente.setSelectedIndex(0);
		txtDescricao.setText("");
		txtTotal.setText("");
		txtData.setText("");
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
			ServicoBean ser= new ServicoBean();
			ser.setCodser(Integer.parseInt(txtCodigo.getText()));
			ser.setDesser(txtDescricao.getText());
			ser.setTotser(Double.parseDouble(txtTotal.getText()));
			if (cboCliente.getSelectedIndex() != 0) {
				ClienteBean objCidade = new ClienteBean();
				objCidade.setCodigo(listaCodigosCidades.get(cboCliente.getSelectedIndex()));
				objCidade.setNome((String) cboCliente.getItemAt(cboCliente.getSelectedIndex()));				
				ser.setCodcli(objCidade);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCliente.requestFocusInWindow();
				return;
			}
			if (Validador.data(txtData.getText())) {
				try {
					ser.setDatser(Validador.formatadorDatas.parse(txtData.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtData.requestFocusInWindow();
				return;
			}
			ServicoDao alterar = new ServicoDao();
			alterar.alterarServico(ser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void preencherTabela(String Descricao) {
		listaservico.removeAll(listaservico);
		
		try {
			ServicoDao a = new ServicoDao();
			listaservico = a.consultarServico(Descricao); 
			for (ServicoBean servico : listaservico) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(servico.getCodser())); //0
				linha.add(servico.getCodcli().getNome());
				linha.add(servico.getDesser());
				linha.add(String.valueOf(servico.getTotser()));
				Date dataNasc = servico.getDatser();
				String strData = Validador.formatadorDatas.format(dataNasc);
				linha.add(strData);
				tabelaModeloServico.addRow(linha);
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
				tc.setPreferredWidth(250);
				tc.setMaxWidth(250);
				tc.setMinWidth(250);
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
				
				tabelaconsultar.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}

	
	private void defineModeloTabela() {
		tabelaModeloServico = new DefaultTableModel();
		tabelaconsultar.setModel(tabelaModeloServico);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Cliente");
		titulo.add("Descricao");
		titulo.add("Total");
		titulo.add("Data");
		tabelaModeloServico.setColumnIdentifiers(titulo);
	}
	
	public void	evento_btnSalvar(){
		try {
			ServicoBean ser= new ServicoBean();
			ser.setDesser(txtDescricao.getText());
			ser.setTotser(Double.parseDouble(txtTotal.getText()));
			if (cboCliente.getSelectedIndex() != 0) {
				ClienteBean objCliente = new ClienteBean();
				objCliente.setCodigo(listaCodigosCidades.get(cboCliente.getSelectedIndex()));
				objCliente.setNome((String) cboCliente.getItemAt(cboCliente.getSelectedIndex()));				
				ser.setCodcli(objCliente);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma cidade", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				cboCliente.requestFocusInWindow();
				return;
			}
			//campo data
			if (Validador.data(txtData.getText())) {
				try {
					ser.setDatser(Validador.formatadorDatas.parse(txtData.getText()));
				} catch (ParseException f) {
					f.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data Inválida", "Data Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtData.requestFocusInWindow();
				return;
			}
			ServicoDao salvar = new ServicoDao();
			salvar.cadastrarServico(ser);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	
	@SuppressWarnings("unchecked")
	private void preencherComboCliente(){
		cboCliente.addItem("");
		listaCodigosCidades.add(-1);
		try {
			
			// consulta cidades
			ClienteDao a = new ClienteDao();
			listaClientes = a.consultarClientes();
			// para cada cidade consultada
			for (ClienteBean objCliente : listaClientes) {
				// adiciona a cidade no combo box
				cboCliente.addItem(objCliente.getNome());
				listaCodigosCidades.add(objCliente.getCodigo());
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
