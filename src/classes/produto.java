/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laboratorio EEQS 02
 */
public class produto {
    private String codproduto;
    private String nome;
    private String datavalidade;
    private String datafabricacao;
    private String fabricante;
    private String preco;
    private String descricao;

    /**
     * @return the codproduto
     */
    public String getCodproduto() {
        return codproduto;
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(String codproduto) {
        this.codproduto = codproduto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the datavalidade
     */
    public String getDatavalidade() {
        return datavalidade;
    }

    /**
     * @param datavalidade the datavalidade to set
     */
    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    /**
     * @return the datafabricacao
     */
    public String getDatafabricacao() {
        return datafabricacao;
    }

    /**
     * @param datafabricacao the datafabricacao to set
     */
    public void setDatafabricacao(String datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
   public class TabelaAluno extends AbstractTableModel{

    private List<produto> linha;
    private String[] colunas= new String[]{"Código produto","Nome","Data Validade","Data fabricação","Fabricante","Preço","Descrição"};
   
    public TabelaAluno (){
        linha = new ArrayList<produto>();
    
    }

    public TabelaAluno(List<produto> linha) {
        this.linha = linha;
    }

    @Override
    public int getRowCount() {
        return linha.size();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return colunas.length;  //To change body of generated methods, choose Tools | Templates.
    }
                 
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        produto p = linha.get(linhaIndex);
        
        
        switch (colunaIndex) {
                   case 0:
                           return p.getCodproduto();
                    case 1:
                            return p.getNome();
                     case 2:
                             return p.getDatavalidade();                    
                      case 3:
                              return p.getDatafabricacao();                   
                       case 4:
                               return p.getFabricante();
                        case 5:
                                return p.getPreco(); 
                        case 6: 
                                return p.getDescricao();
            default:
                throw new IndexOutOfBoundsException("erro ao buscar coluna");
    }
    }
    /**
     * @return the linha
     */
    public List<produto> getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(List<produto> linha) {
        this.linha = linha;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       switch (columnIndex){
       
           case 0:
                return String.class;
            case 1:
                 return String.class;
             case 2:
                  return String.class;
              case 3:
                   return String.class;
               case 4:
                    return String.class;
                case 5:
                     return String.class;
                 case 6:
                     return String.class;
       default:
              return String.class;
       
    }  
    }
}
}
