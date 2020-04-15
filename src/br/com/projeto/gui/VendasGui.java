package br.com.projeto.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import br.com.projeto.bean.ClienteBean;
import br.com.projeto.bean.ItemVendaBean;
import br.com.projeto.bean.ProdutoBean;
import br.com.projeto.bean.VendaBean;
import br.com.projeto.dao.ClienteDao;
import br.com.projeto.dao.ProdutoDao;
import br.com.projeto.dao.VendaDao;
import br.com.projeto.validador.Validador;

@SuppressWarnings("serial")
public class VendasGui extends JFrame {

	private JPanel jContentPane = null;
	private JLabel jlCliente = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCliente = null;
	private JLabel jlProduto = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cboProduto = null;
	private JTextField txtValorUnit = null;
	private JTextField txtQuantidade = null;
	private JLabel jlValor = null;
	private JLabel jlQuantidade = null;
	private JScrollPane jScrollPane = null;
	private JTable TabelaProdutos = null;
	private JButton btnAdicionar = null;
	private JButton btnRemover = null;
	private JButton btnLimpar = null;
	private JLabel jlAcrescimo = null;
	private JLabel jlDesconto = null;
	private JLabel jlTotal = null;
	private JTextField txtAcrescimo = null;
	private JTextField txtDesconto = null;
	private JTextField txtTotal = null;
	private JButton btnConcluir = null;
	private JButton btnCancelar = null;
	
	private DefaultTableModel tabelaModeloVendas;
	private javax.swing.UIManager.LookAndFeelInfo looks[];
	private List<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
	private List<ProdutoBean> listaProdutos = new ArrayList<ProdutoBean>();
	private List<ItemVendaBean> listaItens = new ArrayList<ItemVendaBean>();
	private VendaDao objVenda = new VendaDao();



	/**
	 * This method initializes cboCliente	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox getCboCliente() {
		if (cboCliente == null) {
			cboCliente = new JComboBox();
			cboCliente.setBounds(new java.awt.Rectangle(29,26,201,25));
		}
		return cboCliente;
	}

	/**
	 * This method initializes cboProduto	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox getCboProduto() {
		if (cboProduto == null) {
			cboProduto = new JComboBox();
			cboProduto.setBounds(new java.awt.Rectangle(29,71,200,25));
			cboProduto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					preencherValor();
				}
			});
		}
		return cboProduto;
	}

	/**
	 * This method initializes txtValorUnit	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtValorUnit() {
		if (txtValorUnit == null) {
			txtValorUnit = new JTextField();
			txtValorUnit.setBounds(new java.awt.Rectangle(247,73,75,25));
			txtValorUnit.setEnabled(false);
		}
		return txtValorUnit;
	}

	/**
	 * This method initializes txtQuantidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtQuantidade() {
		if (txtQuantidade == null) {
			txtQuantidade = new JTextField();
			txtQuantidade.setBounds(new java.awt.Rectangle(341,72,75,25));
		}
		return txtQuantidade;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(30,122,388,239));
			jScrollPane.setViewportView(getTabelaProdutos());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes TabelaProdutos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaProdutos() {
		if (TabelaProdutos == null) {
			TabelaProdutos = new JTable();
		}
		return TabelaProdutos;
	}

	/**
	 * This method initializes btnAdicionar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAdicionar() {
		if (btnAdicionar == null) {
			btnAdicionar = new JButton();
			btnAdicionar.setBounds(new java.awt.Rectangle(435,123,44,38));
			btnAdicionar.setText("+");
			btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addproduto();
				}
			});
		}
		return btnAdicionar;
	}

	/**
	 * This method initializes btnRemover	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRemover() {
		if (btnRemover == null) {
			btnRemover = new JButton();
			btnRemover.setBounds(new java.awt.Rectangle(485,123,44,38));
			btnRemover.setText("-");
			btnRemover.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					removerproduto();
				}
			});
		}
		return btnRemover;
	}

	/**
	 * This method initializes btnLimpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new java.awt.Rectangle(535,123,44,38));
			btnLimpar.setText("..");
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					limparcampos();
				}
			});
		}
		return btnLimpar;
	}

	/**
	 * This method initializes txtAcrescimo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAcrescimo() {
		if (txtAcrescimo == null) {
			txtAcrescimo = new JTextField();
			txtAcrescimo.setBounds(new java.awt.Rectangle(436,205,146,27));
			txtAcrescimo.setBackground(new java.awt.Color(51,153,255));
			txtAcrescimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtAcrescimo.setText("0");
			txtAcrescimo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					double acrec = Double.parseDouble(txtAcrescimo.getText());
					double desc = Double.parseDouble(txtDesconto.getText());
					double total=0;
					total = (total + acrec) - desc;
					txtTotal.setText(String.valueOf(calcularTotal()));				}
			});
		}
		return txtAcrescimo;
	}

	/**
	 * This method initializes txtDesconto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDesconto() {
		if (txtDesconto == null) {
			txtDesconto = new JTextField();
			txtDesconto.setBounds(new java.awt.Rectangle(436,253,146,27));
			txtDesconto.setBackground(new java.awt.Color(255,51,51));
			txtDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDesconto.setText("0");

			txtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					double acrec = Double.parseDouble(txtAcrescimo.getText());
					double desc = Double.parseDouble(txtDesconto.getText());
					double total=0;
					total = (total + acrec) - desc;
					txtTotal.setText(String.valueOf(calcularTotal()));				}
			});
		}
		return txtDesconto;
	}

	/**
	 * This method initializes txtTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setBounds(new java.awt.Rectangle(436,304,146,52));
			txtTotal.setEditable(false);
			txtTotal.setBackground(new java.awt.Color(62,173,37));
			txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtTotal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 18));
			txtTotal.setText("0.0");
		}
		return txtTotal;
	}

	/**
	 * This method initializes btnConcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnConcluir() {
		if (btnConcluir == null) {
			btnConcluir = new JButton();
			btnConcluir.setBounds(new java.awt.Rectangle(436,377,146,28));
			btnConcluir.setText("Concluir");
			btnConcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					concluirvenda();
				}
			});
		}
		return btnConcluir;
	}

	/**
	 * This method initializes btnCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBounds(new java.awt.Rectangle(32,377,383,28));
			btnCancelar.setText("Cancelar");
			btnCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
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
	public VendasGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(628, 465);
		this.setContentPane(getJContentPane());
		this.setTitle("Vendas Rodrigo");
		
		lookAndFeel(1);
		defineModeloTabela();
		preencherClientes("");
		preencherProdutos("");
	}
	
	
	public void concluirvenda() {
		VendaBean objVendaBean = new VendaBean();
		objVendaBean.setDatavenda(new Date());
		objVendaBean.setAcrescimo(Double.parseDouble(txtAcrescimo.getText()));
		objVendaBean.setDesconto(Double.parseDouble(txtDesconto.getText()));
		objVendaBean.setTotal(Double.parseDouble(txtTotal.getText()));
		
		if (cboCliente.getSelectedIndex() != 0) {
			objVendaBean.setCliente((ClienteBean) cboCliente.getSelectedItem());
		} else {
			JOptionPane.showMessageDialog(null, "Selecione Cliente", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
			cboCliente.requestFocusInWindow();
			return;
		}
		if (!listaItens.isEmpty()) {
			objVendaBean.setVenItens(listaItens);
		} else {
			JOptionPane.showMessageDialog(null, "Adicione Produtos à Venda", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			objVenda.cadastrarVenda(objVendaBean);
			JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!", "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
			limparTabela();
			cboCliente.setSelectedIndex(0);
			cboProduto.setSelectedIndex(0);
			txtValorUnit.setText("0");
			txtQuantidade.setText("1");
			txtAcrescimo.setText("0");
			txtDesconto.setText("0");
			txtTotal.setText("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void limparcampos(){
			limparTabela();
			txtAcrescimo.setText("0");
			txtDesconto.setText("0");
			txtTotal.setText("0");
			txtValorUnit.setText("0");
			txtQuantidade.setText("0");
	}
	
	private void limparTabela() {
		listaItens.removeAll(listaItens);
		int tamanho = tabelaModeloVendas.getRowCount();
        for (int i = 0; i < tamanho; i++) {
            tabelaModeloVendas.removeRow(0);
        }
	}

	
	
	protected void removerproduto() {
		if(TabelaProdutos.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(null,"Selecione um item da venda");
		}else{
			listaItens.remove(TabelaProdutos.getSelectedRow());
			tabelaModeloVendas.removeRow(TabelaProdutos.getSelectedRow());
		}
		
		// calcula o total
		txtTotal.setText(String.valueOf(calcularTotal()));
	}

	
	public void addproduto(){
			String nome = null;
			int qtde;
			double preco = 0, total;
			//se selecionou "Selecionou" , termina
			if (cboProduto.getSelectedIndex() == 0)
				return;
			Object selectedItem = cboProduto.getSelectedItem();
			if(!Validador.numero(txtQuantidade.getText())) {
				JOptionPane.showMessageDialog(null, "Quantidade Inválida!", "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
				txtQuantidade.requestFocusInWindow();
				return;
			} 
			qtde = Integer.parseInt(txtQuantidade.getText());
			// add item na lista
			ItemVendaBean objItem = new ItemVendaBean();
			if (selectedItem instanceof ProdutoBean) {
				//converte selectedItem para RefeicaoBean
				ProdutoBean objProd = (ProdutoBean) selectedItem;
				objProd.getEstPro();
				//altera o item da venda
				objItem.setProduto(objProd);
				objItem.setQuant(qtde);
				
				//obtem dados para a tabela da interface gráfica
				nome = objProd.getNomPro();
				preco = objProd.getVenPro();
			}
			//add item na lista de itens
			listaItens.add(objItem);
			total = preco * qtde;
			//add linha na tabela
			Vector<String> linha = new Vector<String>();
	        linha.add(nome);
	        linha.add(String.valueOf(preco));
	        linha.add(String.valueOf(qtde));
	        linha.add(String.valueOf(total));
			tabelaModeloVendas.addRow(linha);
			// calcula o total
			txtTotal.setText(String.valueOf(calcularTotal()));
		}
	
	
	private double calcularTotal() {
	     double total = 0;
	     // pra cada item da lista 
			for (ItemVendaBean objItem : listaItens) {
				//esse item contém Servico
				if (objItem.getProduto() != null) {
					//obtem refeicao
					ProdutoBean objProduto = objItem.getProduto();
					total = total + (objProduto.getVenPro() * objItem.getQuant());
				}
			}
				double acrec = Double.parseDouble(txtAcrescimo.getText());
				double desc = Double.parseDouble(txtDesconto.getText());
				total = (total + acrec) - desc;
				return total;
		}

	
	
	public void preencherValor(){
					double valor;
					Object itemSelecionado = cboProduto.getSelectedItem();
					if(itemSelecionado instanceof ProdutoBean){
						ProdutoBean objServ = (ProdutoBean) itemSelecionado;
						valor = objServ.getVenPro();
						txtValorUnit.setText(String.valueOf(valor));
					}else{
						txtValorUnit.setText("0");
					}
		}
	
	@SuppressWarnings("unchecked")
	private void preencherProdutos(String nome) {
		cboProduto.removeAllItems();
		cboProduto.addItem("Selecione");
		
		
		try {
			ProdutoDao consult = new ProdutoDao();
			listaProdutos = consult.consultarProduto(nome);
			
			for(ProdutoBean objServ : listaProdutos){
				cboProduto.addItem(objServ);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro Interno!", "Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}

	
	@SuppressWarnings("unchecked")
	private void preencherClientes(String nome) {
		cboCliente.removeAllItems();
		cboCliente.addItem("Selecione");
		try {
			ClienteDao consultar = new ClienteDao();
			listaClientes = consultar.consultarCliente(nome);
			
			for(ClienteBean objCliente: listaClientes){
				cboCliente.addItem(objCliente);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro Interno!", "Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
	}

	
	private void defineModeloTabela() {
        //define o modelo e o titulo das colunas
        tabelaModeloVendas = new DefaultTableModel();
        TabelaProdutos.setModel(tabelaModeloVendas);
        
        Vector<String> titulo = new Vector<String>();
        titulo.add("Produto");
        titulo.add("Preço");
        titulo.add("Quantidade");
        titulo.add("Total");
        
        tabelaModeloVendas.setColumnIdentifiers(titulo);
        TabelaProdutos.getTableHeader().setReorderingAllowed(false);
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



	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jlTotal = new JLabel();
			jlTotal.setBounds(new java.awt.Rectangle(436,288,145,16));
			jlTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jlTotal.setText("Total:");
			jlDesconto = new JLabel();
			jlDesconto.setBounds(new java.awt.Rectangle(436,235,145,16));
			jlDesconto.setText("Valor Desconto R$");
			jlAcrescimo = new JLabel();
			jlAcrescimo.setBounds(new java.awt.Rectangle(436,187,145,16));
			jlAcrescimo.setText("Valor Acréscimo R$");
			jlQuantidade = new JLabel();
			jlQuantidade.setBounds(new java.awt.Rectangle(343,56,87,16));
			jlQuantidade.setText("Quantidade");
			jlValor = new JLabel();
			jlValor.setBounds(new java.awt.Rectangle(247,56,82,16));
			jlValor.setText("Valor Unitário");
			jlProduto = new JLabel();
			jlProduto.setBounds(new java.awt.Rectangle(29,56,76,16));
			jlProduto.setText("Produto:");
			jlCliente = new JLabel();
			jlCliente.setBounds(new java.awt.Rectangle(29,10,59,16));
			jlCliente.setText("Cliente:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jlCliente, null);
			jContentPane.add(getCboCliente(), null);
			jContentPane.add(jlProduto, null);
			jContentPane.add(getCboProduto(), null);
			jContentPane.add(getTxtValorUnit(), null);
			jContentPane.add(getTxtQuantidade(), null);
			jContentPane.add(jlValor, null);
			jContentPane.add(jlQuantidade, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getBtnAdicionar(), null);
			jContentPane.add(getBtnRemover(), null);
			jContentPane.add(getBtnLimpar(), null);
			jContentPane.add(jlAcrescimo, null);
			jContentPane.add(jlDesconto, null);
			jContentPane.add(jlTotal, null);
			jContentPane.add(getTxtAcrescimo(), null);
			jContentPane.add(getTxtDesconto(), null);
			jContentPane.add(getTxtTotal(), null);
			jContentPane.add(getBtnConcluir(), null);
			jContentPane.add(getBtnCancelar(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
