package br.com.projeto.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import br.com.projeto.bean.CidadeBean;
import br.com.projeto.dao.CidadeDao;



@SuppressWarnings("serial")
public class CidadeGui extends JFrame {

	private JPanel jContentPane = null;
	private JPanel jPanelBotoes = null;
	private JButton btnRegistrar = null;
	private JButton btnSair = null;
	private JButton btnListar = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JPanel painelConsultar = null;
	private JLabel labelCodigo = null;
	private JLabel labelNome = null;
	private JLabel labelUf = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private JTextField txtUf = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JLabel NomeConsultar = null;
	private JTextField txtNomeConsultar = null;
	private JScrollPane painelconsultar = null;
	private JTable tabelaconsultar = null;
	private DefaultTableModel tabelaModeloCidade;
	private List<CidadeBean> listacidade = new ArrayList<CidadeBean>();
	/**
	 * This is the default constructor
	 */
	public CidadeGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(508, 360);
		this.setContentPane(getJContentPane());
		this.setTitle("Cidade");
		defineModeloTabela();
		defineLarguraColunas();
		preencherTabela("");
	}


public void	evento_tabela_preenche_campos(){
		preencherCampos();
		painelTabs.setSelectedIndex(0);
	}
	
	public void preencherCampos(){
		int linhaSelecionada = tabelaconsultar.getSelectedRow();
		txtCodigo.setText((String)String.valueOf(tabelaModeloCidade.getValueAt(linhaSelecionada, 0)));          
		txtNome.setText((String)String.valueOf(tabelaModeloCidade.getValueAt(linhaSelecionada, 1)));          
		txtUf.setText((String)String.valueOf(tabelaModeloCidade.getValueAt(linhaSelecionada, 2)));          
	 	}
	
	public void evento_campo_consulta_nome(){
		limparTabela();
		preencherTabela(txtNomeConsultar.getText());
		txtNomeConsultar.requestFocusInWindow();
	}
	public void limparTabela(){
	       int tamanho = tabelaModeloCidade.getRowCount();
	        
	        for (int i = 0; i < tamanho; i++) {
	        	tabelaModeloCidade.removeRow(0);
	        }
	 
	}
	
	
	public void	evento_btnLimpar(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtUf.setText("");
	}
	
	public void	evento_btnExcluir() {
		try {
			CidadeDao excluir = new CidadeDao();
			excluir.excluirCidade(Integer.parseInt(txtCodigo.getText()));
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
			CidadeBean cid= new CidadeBean();
			cid.setCodCid(Integer.parseInt(txtCodigo.getText()));
			cid.setNomCid(txtNome.getText());
			cid.setUfCid(txtUf.getText());
			CidadeDao alterar = new CidadeDao();
			alterar.alterarCidade(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void preencherTabela(String nome) {
		listacidade.removeAll(listacidade);
		
		try {
			CidadeDao a = new CidadeDao();
			listacidade = a.conconsultarCidade(nome); 
			for (CidadeBean cidade : listacidade) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(cidade.getCodCid())); //0
				linha.add(cidade.getNomCid()); //1
				linha.add(cidade.getUfCid());//2
				tabelaModeloCidade.addRow(linha);
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
				tabelaconsultar.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}

	
	private void defineModeloTabela() {
		tabelaModeloCidade = new DefaultTableModel();
		tabelaconsultar.setModel(tabelaModeloCidade);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Nome");
		titulo.add("Uf");
		tabelaModeloCidade.setColumnIdentifiers(titulo);
	}
	
	public void	evento_btnSalvar(){
		try {
			CidadeBean cid= new CidadeBean();
			cid.setNomCid(txtNome.getText());
			cid.setUfCid(txtUf.getText());
			CidadeDao salvar = new CidadeDao();
			salvar.cadastrarCidade(cid);
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
			jContentPane.add(getJPanelBotoes(), null);
			jContentPane.add(getPainelTabs(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(null);
			jPanelBotoes.setBounds(new java.awt.Rectangle(22,8,447,65));
			jPanelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			jPanelBotoes.add(getBtnRegistrar(), null);
			jPanelBotoes.add(getBtnSair(), null);
			jPanelBotoes.add(getBtnListar(), null);
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes btnRegistrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton();
			btnRegistrar.setBounds(new java.awt.Rectangle(15,12,129,39));
			btnRegistrar.setText("Registrar");
		}
		return btnRegistrar;
	}

	/**
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new java.awt.Rectangle(303,12,129,39));
			btnSair.setText("Sair");
		}
		return btnSair;
	}

	/**
	 * This method initializes btnListar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton();
			btnListar.setBounds(new java.awt.Rectangle(159,12,129,39));
			btnListar.setText("Listar");
		}
		return btnListar;
	}

	/**
	 * This method initializes painelTabs	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getPainelTabs() {
		if (painelTabs == null) {
			painelTabs = new JTabbedPane();
			painelTabs.setBounds(new java.awt.Rectangle(23,78,447,237));
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
			labelUf = new JLabel();
			labelUf.setBounds(new java.awt.Rectangle(16,90,120,21));
			labelUf.setText("Uf:");
			labelNome = new JLabel();
			labelNome.setBounds(new java.awt.Rectangle(16,57,120,21));
			labelNome.setText("Nome:");
			labelCodigo = new JLabel();
			labelCodigo.setBounds(new java.awt.Rectangle(16,23,120,21));
			labelCodigo.setToolTipText("");
			labelCodigo.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.add(labelCodigo, null);
			painelCadastrar.add(labelNome, null);
			painelCadastrar.add(labelUf, null);
			painelCadastrar.add(getTxtCodigo(), null);
			painelCadastrar.add(getTxtNome(), null);
			painelCadastrar.add(getTxtUf(), null);
			painelCadastrar.add(getBtnSalvar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
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
			NomeConsultar = new JLabel();
			NomeConsultar.setBounds(new java.awt.Rectangle(13,10,143,23));
			NomeConsultar.setText("Nome Consultar:");
			painelConsultar = new JPanel();
			painelConsultar.setLayout(null);
			painelConsultar.add(NomeConsultar, null);
			painelConsultar.add(getTxtNomeConsultar(), null);
			painelConsultar.add(getPainelconsultar(), null);
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
			txtCodigo.setBounds(new java.awt.Rectangle(150,25,222,21));
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
			txtNome.setBounds(new java.awt.Rectangle(150,55,222,21));
		}
		return txtNome;
	}

	/**
	 * This method initializes txtUf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUf() {
		if (txtUf == null) {
			txtUf = new JTextField();
			txtUf.setBounds(new java.awt.Rectangle(150,88,222,21));
		}
		return txtUf;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setBounds(new java.awt.Rectangle(9,159,101,45));
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
			btnAlterar.setBounds(new java.awt.Rectangle(119,159,98,45));
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
			btnExcluir.setBounds(new java.awt.Rectangle(226,159,97,45));
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
			btnLimpar.setBounds(new java.awt.Rectangle(332,159,97,45));
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
	 * This method initializes txtNomeConsultar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNomeConsultar() {
		if (txtNomeConsultar == null) {
			txtNomeConsultar = new JTextField();
			txtNomeConsultar.setBounds(new java.awt.Rectangle(162,10,263,23));
			txtNomeConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					evento_campo_consulta_nome();
				}
			});
		}
		return txtNomeConsultar;
	}

	/**
	 * This method initializes painelconsultar	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getPainelconsultar() {
		if (painelconsultar == null) {
			painelconsultar = new JScrollPane();
			painelconsultar.setBounds(new java.awt.Rectangle(14,41,416,158));
			painelconsultar.setViewportView(getTabelaconsultar());
		}
		return painelconsultar;
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

}  //  @jve:decl-index=0:visual-constraint="10,10"
