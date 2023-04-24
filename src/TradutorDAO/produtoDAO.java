/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.cadastrocl;
import classes.produto;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.CatchNode;
import static sun.security.jgss.GSSUtil.login;
/**
 *
 * @author Laboratorio EEQS 02
 */
public class produtoDAO {
    
    
    public boolean inserirProduto(produto pr) {

        String sql = "INSERT INTO produtos (codproduto,datafabricacao,datavalidade,descricao,fabricante,nomeproduto,preco)VALUES(?,?,?,?,?,?,?);";
        boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, pr.getCodproduto());
            pst.setString(2, pr.getDatafabricacao());
            pst.setString(3, pr.getDatavalidade());
            pst.setString(4, pr.getDescricao());
            pst.setString(5, pr.getFabricante());
            pst.setString(6, pr.getNome());
            pst.setString(7, pr.getPreco());
            
           

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao inserir Produto!!!", "Erro;", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;

    
}
         public List<produto> listarproduto(){
      List<produto> retorno = new ArrayList<produto>();
     
      String sql = "SELECT * FROM produtos";
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
      
      try {
          ResultSet res = pst.executeQuery();
          while(res.next())
          {
              
          produto item = new produto();
         
          item.setCodproduto(res.getString("codproduto"));
          item.setDatafabricacao(res.getString("datafabricacao"));
          item.setDatavalidade(res.getString("datavalidade"));
          item.setDescricao(res.getString("descricao"));
          item.setNome(res.getString("nomeproduto"));
          item.setFabricante(res.getString("fabricante"));
          item.setPreco(res.getString("preco"));
          retorno.add(item);
          }
       }catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        return retorno;
     
      
      
      
      }
}