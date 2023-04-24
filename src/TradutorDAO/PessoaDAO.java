/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.PessoaCli;
import classes.cadastrocl;
import classes.cliente;
import classes.funcionario;
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
 * @author Laboratorio EEQS 03
 */
public class PessoaDAO {

    public boolean inserirCliente(cadastrocl cl) {

        String sql = "INSERT INTO logincl (telefone,cpf,nomecompleto,senha,login)VALUES(?,?,?,?,?);";
        boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, cl.getTelefone());
            pst.setString(2, cl.getCpf());
            pst.setString(3, cl.getNome());
            pst.setString(4, cl.getSenha());
            pst.setString(5, cl.getLogin());
           

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "erro ao inserir cliente!!!", "Erro;", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;

    }

    public boolean inseriFuncionario(funcionario fu) {
        String sql = "INSERT INTO loginfu (login,senha)VALUES(?,?);";
        boolean retorno = false;
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, fu.getLogin());
            ps.setString(2, fu.getSenha());
           

            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"erro ao inserir funcionario", "Erro;", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;
    }

    public int UltRegistro() {
        int valor = 0;
        String sql = "SELECT * FROM logincl";
        cliente retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            res.last();
            valor = Integer.parseInt(res.getString("cpf"));
            valor++;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Inserir cliente, Dados Incorretos!!!", "Acesso;", JOptionPane.ERROR_MESSAGE);
        }

        return valor;

    }

    public cliente buscarpessoa(String login, String senha) {

        String sql = "SELECT * From logincl Where login='"+login+"' AND senha='"+senha+"'" ;
        System.out.println(sql);
        cliente retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            
            ResultSet res = pst.executeQuery();

            if (res.next()) {

                retorno = new cliente();
                
                retorno.setCpf(res.getString("cpf")); 
                retorno.setLogin(res.getString("login"));
                retorno.setNcompleto(res.getString("nomecompleto"));
                retorno.setSenha(res.getString("senha"));
                retorno.setTelefone(res.getString("telefone"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
   
    
   
public boolean VerificarPessoa(String log){

 String sql = "SELECT * FROM logincl where cpf =?";
    boolean retorno = true;

PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, log);
            ResultSet res = pst.executeQuery();

            if (res.next()) {

                retorno=false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




        return retorno;

    }

public boolean VerificarLogin(String log,String senha){

 String sql = "SELECT * FROM logincl where login =?";
    boolean retorno = false;

PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, log);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                if(res.getString("senha").equalsIgnoreCase(senha)){
                    retorno=true;
                }
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




        return retorno;

    }
 public boolean excluirPessoa (String cpf){
 
     String sql="DELETE FROM logincl WHERE login=?";

      PreparedStatement pst = Conexao.getPreparedStatement (sql);
     
      Boolean retorno = false;
      
      try {

         pst.setString(1, cpf);

         while (pst.executeUpdate()>0){
         
         retorno = true;
         }
         
     } catch (SQLException e) { 
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
     }
       return retorno;
}
 public boolean VerificarLoginfu(String log,String senha){

 String sql = "SELECT * FROM loginfu where login =?";
    boolean retorno = false;

PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, log);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                if(res.getString("senha").equalsIgnoreCase(senha)){
                    retorno=true;
                }
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




        return retorno;

    }
 public funcionario buscarpessoafu (String fu) {

        String sql = "SELECT * From loginfu Where login=?";
        funcionario retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, fu);
            ResultSet res = pst.executeQuery();

            if (res.next()) {

              retorno.setLogin(res.getString("login"));
                
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public List <funcionario> listarfu() {
    
     List <funcionario> listarfu = new ArrayList<funcionario>();
     boolean retorno;
     
    String sql = "select login FROM loginfu";
     PreparedStatement pst = Conexao.getPreparedStatement (sql);
     
     
     try {
         ResultSet resFuncionario = pst.executeQuery();
         while (resFuncionario.next()) {
             pst.setString(1, resFuncionario.getString("login"));
            
             ResultSet res = pst.executeQuery();
             
            while (res.next()){
            funcionario linha = new funcionario ();
            linha.setLogin(res.getString("login"));
            }
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarfu;

        
    }
     public List <cliente> listarcl() {
    
     List <cliente> listarcl = new ArrayList<cliente>();
     boolean retorno;
     
    String sql = "select login FROM logincl";
     PreparedStatement pstcl = Conexao.getPreparedStatement (sql);
     
     
     try {
         ResultSet resCliente = pstcl.executeQuery();
         while (resCliente.next()) {
             //pst.setString(1, resFuncionario.getString("login"));
             pstcl.setString(1, resCliente.getString("login"));
             ResultSet res = pstcl.executeQuery();
             
            while (res.next()){
            cliente linhacl = new cliente();
            linhacl.setLogin(res.getString("login"));
            }
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarcl;

        
    }
     public List <PessoaCli> listartodos() {
    
     List <PessoaCli> listarcl = new ArrayList<PessoaCli>();
     boolean retorno;
     
    String sql = "select login FROM logincl,loginfu";
     PreparedStatement pstcl = Conexao.getPreparedStatement (sql);
     
     
     try {
         ResultSet resCliente = pstcl.executeQuery();
         while (resCliente.next()) {
             //pst.setString(1, resFuncionario.getString("login"));
             pstcl.setString(1, resCliente.getString("login"));
             ResultSet res = pstcl.executeQuery();
             
            while (res.next()){
            PessoaCli linhacf = new PessoaCli();
            linhacf.setLogin(res.getString("login"));
            linhacf.setCpf(res.getString("cpf"));
            linhacf.setNcompleto(res.getString("nomecompleto"));
            linhacf.setSenha(res.getString("senha"));
            linhacf.setTelefone(res.getString("telefone"));
            }
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarcl;

        
    }
}

