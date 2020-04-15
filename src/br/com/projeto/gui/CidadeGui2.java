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


import br.com.projeto.bean.CidCidadeBean;
import br.com.projeto.dao.CidCidadeDao;


@SuppressWarnings("serial")
public class CidadeGui2 extends JFrame {

	private JPanel jContentPane = null;
	private JPanel jPanelBotoes = null;
	private JButton btnRegistrar = null;
	private JButton btnListar = null;
	private JButton btnSair = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JPanel painelConsultar = null;
	private JLabel jlCodigo = null;
	private JLabel jlNome = null;
	private JLabel jlUf = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private JTextField txtUf = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JLabel jlConsultar = null;
	private JTextField txtNomeConsultar = null;
	private JScrollPane jspainelConsultar = null;
	private JTable tabelaconsultar = null;
	private List<CidCidadeBean> listacidade = new ArrayList<CidCidadeBean>();
	private DefaultTableModel tabelaModeloCidade;
	/**
	 * This is the default constructor
	 */
	public CidadeGui2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(505, 381);
		this.setContentPane(getJContentPane());
		this.setTitle("Cidades");
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
		txtUf.setText((String)tabelaModeloCidade.getValueAt(linhaSelecionada, 2));
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
			CidCidadeDao excluir = new CidCidadeDao();
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
			CidCidadeBean cid= new CidCidadeBean();
			cid.setCodCid(Integer.parseInt(txtCodigo.getText()));
			cid.setNomCid(txtNome.getText());
			cid.setUfCid(txtUf.getText());
			CidCidadeDao alterar = new CidCidadeDao();
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
			CidCidadeDao a = new CidCidadeDao();
			listacidade = a.consultarCidade(nome); 
			for (CidCidadeBean cidade : listacidade) {
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
			CidCidadeBean cid= new CidCidadeBean();
			cid.setNomCid(txtNome.getText());
			cid.setUfCid(txtUf.getText());
			CidCidadeDao salvar = new CidCidadeDao();
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
			jPanelBotoes.setBounds(new java.awt.Rectangle(11,7,468,69));
			jPanelBotoes.add(getBtnRegistrar(), null);
			jPanelBotoes.add(getBtnListar(), null);
			jPanelBotoes.add(getBtnSair(), null);
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
			btnRegistrar.setBounds(new java.awt.Rectangle(7,12,138,48));
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
			btnListar.setBounds(new java.awt.Rectangle(152,12,153,48));
			btnListar.setText("Listar");
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
			btnSair.setBounds(new java.awt.Rectangle(312,12,149,48));
			btnSair.setText("Sair");
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
			painelTabs.setBounds(new java.awt.Rectangle(1,79,486,263));
			painelTabs.setName("");
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
			jlUf = new JLabel();
			jlUf.setBounds(new java.awt.Rectangle(15,101,89,35));
			jlUf.setText("Uf:");
			jlNome = new JLabel();
			jlNome.setBounds(new java.awt.Rectangle(15,59,89,35));
			jlNome.setText("Nome:");
			jlCodigo = new JLabel();
			jlCodigo.setBounds(new java.awt.Rectangle(15,15,89,35));
			jlCodigo.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.add(jlCodigo, null);
			painelCadastrar.add(jlNome, null);
			painelCadastrar.add(jlUf, null);
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
			jlConsultar = new JLabel();
			jlConsultar.setBounds(new java.awt.Rectangle(12,12,89,35));
			jlConsultar.setText("Nome:");
			painelConsultar = new JPanel();
			painelConsultar.setLayout(null);
			painelConsultar.add(jlConsultar, null);
			painelConsultar.add(getTxtNomeConsultar(), null);
			painelConsultar.add(getJspainelConsultar(), null);
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
			txtCodigo.setBounds(new java.awt.Rectangle(112,16,356,33));
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
			txtNome.setBounds(new java.awt.Rectangle(112,59,356,35));
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
			txtUf.setBounds(new java.awt.Rectangle(112,102,356,35));
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
			btnSalvar.setBounds(new java.awt.Rectangle(18,169,97,56));
			btnSalvar.setText("Salvar");
			btnSalvar.setName("");
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
			btnAlterar.setBounds(new java.awt.Rectangle(133,169,97,56));
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
			btnExcluir.setBounds(new java.awt.Rectangle(248,169,97,56));
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
			btnLimpar.setBounds(new java.awt.Rectangle(363,169,97,56));
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
			txtNomeConsultar.setBounds(new java.awt.Rectangle(116,12,352,35));
		}
		return txtNomeConsultar;
	}

	/**
	 * This method initializes jspainelConsultar	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJspainelConsultar() {
		if (jspainelConsultar == null) {
			jspainelConsultar = new JScrollPane();
			jspainelConsultar.setBounds(new java.awt.Rectangle(2,57,478,177));
			jspainelConsultar.setViewportView(getTabelaConsultar());
		}
		return jspainelConsultar;
	}

	/**
	 * This method initializes tabelaConsultar	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaConsultar() {
		if (tabelaconsultar == null) {
			tabelaconsultar = new JTable();
		}
		return tabelaconsultar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
