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



import br.com.projeto.bean.ProdutoBean;
import br.com.projeto.dao.ProdutoDao;


@SuppressWarnings("serial")
public class ProdutoGui extends JFrame {

	private JPanel jContentPane = null;
	private JPanel jPanelMenu = null;
	private JButton registrar = null;
	private JButton btnListar = null;
	private JButton btnSair = null;
	private JTabbedPane painelTabs = null;
	private JPanel painelCadastrar = null;
	private JLabel jLabel = null;
	private JLabel Nom = null;
	private JLabel Des = null;
	private JLabel Cus = null;
	private JLabel Ven = null;
	private JLabel Est = null;
	private JTextField codigo = null;
	private JTextField txtNome = null;
	private JTextField txtDescricao = null;
	private JTextField txtVenda = null;
	private JTextField txtEstoque = null;
	private JPanel painelConsultar = null;
	private JButton btnSalvar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnLimpar = null;
	private JTextField txtCusto = null;
	private JLabel NomeConsultar = null;
	private JTextField txtNomeConsultar = null;
	private DefaultTableModel tabelaModeloProduto;
	private List<ProdutoBean> listaproduto = new ArrayList<ProdutoBean>();
	private JScrollPane painelconsultar = null;
	private JTable tabelaconsultar = null;
	@SuppressWarnings("unused")
	private List<Integer> listaCodigosProdutos = new ArrayList<Integer>();
	/**
	 * This is the default constructor
	 */
	public ProdutoGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(658, 438);
		this.setContentPane(getJContentPane());
		this.setTitle("Produto");
		defineModeloTabela();
		defineLarguraColunas();
		preencherTabela("");
	}
	public void	evento_tabela_preenche_campos(){
		preencherCampos();
		painelTabs.setSelectedIndex(0);
	}
	private void defineModeloTabela() {
		tabelaModeloProduto = new DefaultTableModel();
		tabelaconsultar.setModel(tabelaModeloProduto);
		Vector<String> titulo = new Vector<String>();
		titulo.add("Código");
		titulo.add("Nome");
		titulo.add("Descricao");
		titulo.add("Custo");
		titulo.add("Venda");
		titulo.add("Estoque");
		tabelaModeloProduto.setColumnIdentifiers(titulo);
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
				
				tabelaconsultar.getTableHeader().setReorderingAllowed(false);
		//nao deixa mudar coluna de lugar
		}
	public void preencherCampos(){
		int linhaSelecionada = tabelaconsultar.getSelectedRow();
		codigo.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 0)));          
		txtNome.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 1)));          
		txtDescricao.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 2)));          
		txtCusto.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 3)));          
		txtVenda.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 4))); 
		txtEstoque.setText((String)String.valueOf(tabelaModeloProduto.getValueAt(linhaSelecionada, 5)));
	 	}
	private void preencherTabela(String nome) {
		listaproduto.removeAll(listaproduto);
		
		try {
			ProdutoDao a = new ProdutoDao();
			listaproduto = a.consultarProduto(nome); 
			for (ProdutoBean produto : listaproduto) {
				Vector<String> linha = new Vector<String>(); 
				linha.add(String.valueOf(produto.getCodPro())); //0
				linha.add(produto.getNomPro()); //1
				linha.add(produto.getDesPro());//2
				linha.add(String.valueOf(produto.getCusPro())); //3
				linha.add(String.valueOf(produto.getVenPro()));//4
				linha.add(String.valueOf(produto.getEstPro()));
				tabelaModeloProduto.addRow(linha);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro Interno", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}
	public void limparTabela(){
	       int tamanho = tabelaModeloProduto.getRowCount();
	        
	        for (int i = 0; i < tamanho; i++) {
	        	tabelaModeloProduto.removeRow(0);
	        }
	 
	}
	public void evento_campo_consulta_nome(){
		limparTabela();
		preencherTabela(txtNomeConsultar.getText());
		txtNomeConsultar.requestFocusInWindow();
	}

	public void	evento_btnLimpar(){
		codigo.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
		txtCusto.setText("");
		txtVenda.setText("");
		txtEstoque.setText("");
	}
	public void	evento_btnExcluir() {
		try {
			ProdutoDao excluir = new ProdutoDao();
			excluir.excluirProduto(Integer.parseInt(codigo.getText()));
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
			ProdutoBean pro= new ProdutoBean();
			pro.setCodPro(Integer.parseInt(codigo.getText()));
			pro.setNomPro(txtNome.getText());
			pro.setDesPro(txtDescricao.getText());
			pro.setCusPro(Double.parseDouble(txtCusto.getText()));
			pro.setVenPro(Double.parseDouble(txtVenda.getText()));
			pro.setEstPro(Integer.parseInt(txtEstoque.getText()));
			
			ProdutoDao alterar = new ProdutoDao();
			alterar.alterarProduto(pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void	evento_btnSalvar(){
		try {
			ProdutoBean pro= new ProdutoBean();
			pro.setNomPro(txtNome.getText());
			pro.setDesPro(txtDescricao.getText());
			pro.setCusPro(Double.parseDouble(txtCusto.getText()));
			pro.setVenPro(Double.parseDouble(txtVenda.getText()));
			pro.setEstPro(Integer.parseInt(txtEstoque.getText()));
			ProdutoDao salvar = new ProdutoDao();
			salvar.cadastrarProduto(pro);
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
			jContentPane.add(getJPanelMenu(), null);
			jContentPane.add(getPainelTabs(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelMenu	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMenu() {
		if (jPanelMenu == null) {
			jPanelMenu = new JPanel();
			jPanelMenu.setLayout(null);
			jPanelMenu.setBounds(new java.awt.Rectangle(80,13,456,66));
			jPanelMenu.add(getRegistrar(), null);
			jPanelMenu.add(getBtnListar(), null);
			jPanelMenu.add(getBtnSair(), null);
		}
		return jPanelMenu;
	}

	/**
	 * This method initializes registrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrar() {
		if (registrar == null) {
			registrar = new JButton();
			registrar.setBounds(new java.awt.Rectangle(25,22,113,22));
			registrar.setText("Registrar");
			registrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return registrar;
	}

	/**
	 * This method initializes btnListar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton();
			btnListar.setBounds(new java.awt.Rectangle(163,21,118,24));
			btnListar.setText("Listar");
			btnListar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			btnSair.setBounds(new java.awt.Rectangle(306,22,124,23));
			btnSair.setText("Sair");
			btnSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			painelTabs.setBounds(new java.awt.Rectangle(120,99,414,281));
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
			Est = new JLabel();
			Est.setBounds(new java.awt.Rectangle(28,170,65,22));
			Est.setText("Estoque:");
			Ven = new JLabel();
			Ven.setBounds(new java.awt.Rectangle(28,138,65,22));
			Ven.setText("Venda:");
			Cus = new JLabel();
			Cus.setBounds(new java.awt.Rectangle(28,106,65,22));
			Cus.setText("Custo:");
			Des = new JLabel();
			Des.setBounds(new java.awt.Rectangle(28,74,65,22));
			Des.setText("Descrição:");
			Nom = new JLabel();
			Nom.setBounds(new java.awt.Rectangle(28,42,65,22));
			Nom.setText("Nome:");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(28,10,65,22));
			jLabel.setText("Código:");
			painelCadastrar = new JPanel();
			painelCadastrar.setLayout(null);
			painelCadastrar.setName("");
			painelCadastrar.add(jLabel, null);
			painelCadastrar.add(Nom, null);
			painelCadastrar.add(Des, null);
			painelCadastrar.add(Cus, null);
			painelCadastrar.add(Ven, null);
			painelCadastrar.add(Est, null);
			painelCadastrar.add(getCodigo(), null);
			painelCadastrar.add(getTxtNome(), null);
			painelCadastrar.add(getTxtDescricao(), null);
			painelCadastrar.add(getTxtCusto(), null);
			painelCadastrar.add(getTxtVenda(), null);
			painelCadastrar.add(getTxtEstoque(), null);
			painelCadastrar.add(getBtnSalvar(), null);
			painelCadastrar.add(getBtnAlterar(), null);
			painelCadastrar.add(getBtnExcluir(), null);
			painelCadastrar.add(getBtnLimpar(), null);
			painelCadastrar.add(getTxtCusto(), null);
		}
		return painelCadastrar;
	}

	/**
	 * This method initializes codigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCodigo() {
		if (codigo == null) {
			codigo = new JTextField();
			codigo.setBounds(new java.awt.Rectangle(105,12,297,20));
		}
		return codigo;
	}

	/**
	 * This method initializes txtNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new java.awt.Rectangle(105,44,297,20));
		}
		return txtNome;
	}

	/**
	 * This method initializes txtDescricao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDescricao() {
		if (txtDescricao == null) {
			txtDescricao = new JTextField();
			txtDescricao.setBounds(new java.awt.Rectangle(105,76,297,20));
		}
		return txtDescricao;
	}

	/**
	 * This method initializes txtVenda	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtVenda() {
		if (txtVenda == null) {
			txtVenda = new JTextField();
			txtVenda.setBounds(new java.awt.Rectangle(105,140,297,20));
		}
		return txtVenda;
	}

	/**
	 * This method initializes txtEstoque	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEstoque() {
		if (txtEstoque == null) {
			txtEstoque = new JTextField();
			txtEstoque.setBounds(new java.awt.Rectangle(105,172,297,20));
		}
		return txtEstoque;
	}

	/**
	 * This method initializes painelConsultar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPainelConsultar() {
		if (painelConsultar == null) {
			NomeConsultar = new JLabel();
			NomeConsultar.setBounds(new java.awt.Rectangle(8,7,127,22));
			NomeConsultar.setText("Consultar por nome: ");
			painelConsultar = new JPanel();
			painelConsultar.setLayout(null);
			painelConsultar.add(NomeConsultar, null);
			painelConsultar.add(getTxtNomeConsultar(), null);
			painelConsultar.add(getPainelconsultar(), null);
		}
		return painelConsultar;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setBounds(new java.awt.Rectangle(17,205,79,33));
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
			btnAlterar.setBounds(new java.awt.Rectangle(108,205,85,33));
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
			btnExcluir.setBounds(new java.awt.Rectangle(205,205,87,33));
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
			btnLimpar.setBounds(new java.awt.Rectangle(304,205,96,33));
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
	 * This method initializes txtCusto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCusto() {
		if (txtCusto == null) {
			txtCusto = new JTextField();
			txtCusto.setBounds(new java.awt.Rectangle(105,107,295,21));
		}
		return txtCusto;
	}

	/**
	 * This method initializes txtNomeConsultar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNomeConsultar() {
		if (txtNomeConsultar == null) {
			txtNomeConsultar = new JTextField();
			txtNomeConsultar.setBounds(new java.awt.Rectangle(141,6,258,24));
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
			painelconsultar.setBounds(new java.awt.Rectangle(8,34,392,215));
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
