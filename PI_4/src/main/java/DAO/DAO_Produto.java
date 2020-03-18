/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Categorias;
import Classes.ImagemProduto;
import Classes.Objetivo;
import Classes.Pergunta;
import Classes.Produto;
import Classes.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class DAO_Produto {

    public int daoSalvarProduto(Produto produto) {
        int idProd = 0;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PRODUTO(NOME,DESCRICAO,STATUS,VALOR_UNIT,QUANTIDADE,FK_ID_USUARIO)\n"
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setString(2, produto.getDescricao());
            comandoSQL.setBoolean(3, produto.isStatus());
            comandoSQL.setDouble(4, produto.getPreco());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, 1);

            comandoSQL.executeUpdate();
            ResultSet getId = comandoSQL.getGeneratedKeys();
            while (getId.next()) {
                idProd = Integer.parseInt(getId.getString(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            idProd = 0;
        }
        return idProd;
    }

    public boolean daoAlterarProduto(Produto produto) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.PRODUTO\n"
                    + "SET NOME = ?, DESCRICAO = ?, STATUS = ?, VALOR_UNIT = ?, QUANTIDADE = ?\n"
                    + "WHERE ID_PRODUTO = ?");

            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setString(2, produto.getDescricao());
            comandoSQL.setBoolean(3, produto.isStatus());
            comandoSQL.setDouble(4, produto.getPreco());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, produto.getIdProd());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean salvarRespostas(Resposta r, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.RESPOSTA_PROD_PERG(RESPOSTA,FK_ID_PRODUTO,FK_ID_PERGUNTA)\n"
                    + "VALUES (?,?,?)");

            comandoSQL.setString(1, r.getResposta());
            comandoSQL.setInt(2, idProd);
            comandoSQL.setInt(3, r.getIdPergunta());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean alterarRespostas(Resposta r, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.RESPOSTA_PROD_PERG\n"
                    + "SET RESPOSTA = ?\n"
                    + "WHERE FK_ID_PRODUTO = ? and FK_ID_PERGUNTA = ?;");

            comandoSQL.setString(1, r.getResposta());
            comandoSQL.setInt(2, idProd);
            comandoSQL.setInt(3, r.getIdPergunta());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean salvarObjetivo(int idObjetivo, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PROD_OBJETIVO(FK_ID_OBJETIVO,FK_ID_PRODUTO)\n"
                    + "VALUES (?,?)");

            comandoSQL.setInt(1, idObjetivo);
            comandoSQL.setInt(2, idProd);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean deletarObjetivos(int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM SUPLEMENTOS.PROD_OBJETIVO\n"
                    + "WHERE FK_ID_PRODUTO = ?");

            comandoSQL.setInt(1, idProd);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean salvarCategorias(int idCategoria, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PROD_CATEGORIA(FK_ID_CATEGORIA,FK_ID_PRODUTO)\n"
                    + "VALUES (?,?)");

            comandoSQL.setInt(1, idCategoria);
            comandoSQL.setInt(2, idProd);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean deletarCategorias(int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM SUPLEMENTOS.PROD_CATEGORIA\n"
                    + "WHERE FK_ID_PRODUTO = ?");

            comandoSQL.setInt(1, idProd);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean salvarImgs(ArrayList<ImagemProduto> imagens, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTO.IMAGEMPRODUTO(NOME,CAMINHO,STATUS,ID_PRODUTO)\n"
                    + "VALUES (?,?,?,?)");
            for (ImagemProduto img : imagens) {
                comandoSQL.setString(1, img.getNome());
                comandoSQL.setString(2, img.getCaminho());
                comandoSQL.setBoolean(3, img.isStatus());
                comandoSQL.setInt(4, idProd);
            }

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public ArrayList<Pergunta> getPergunta() {
        Conexao conec = new Conexao();
        ArrayList<Pergunta> listaPergunta = new ArrayList<Pergunta>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_PERGUNTA, PERGUNTA from SUPLEMENTOS.PERGUNTA;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pergunta p = new Pergunta();
                    p.setIdPergunta(rs.getInt("ID_PERGUNTA"));
                    p.setPergunta(rs.getString("PERGUNTA"));
                    listaPergunta.add(p);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaPergunta;
    }

    public ArrayList<Objetivo> getObjetivo() {
        Conexao conec = new Conexao();
        ArrayList<Objetivo> listaObjetivo = new ArrayList<Objetivo>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_OBJETIVO, NOME from SUPLEMENTOS.OBJETIVO;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Objetivo o = new Objetivo();
                    o.setIdObjetivo(rs.getInt("ID_OBJETIVO"));
                    o.setDescricaoObj(rs.getString("NOME"));
                    listaObjetivo.add(o);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaObjetivo;
    }

    public ArrayList<Categorias> getCategoria() {
        Conexao conec = new Conexao();
        ArrayList<Categorias> listaCategorias = new ArrayList<Categorias>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_CATEGORIA, NOME  from SUPLEMENTOS.CATEGORIA;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Categorias c = new Categorias();
                    c.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                    c.setNome(rs.getString("NOME"));
                    listaCategorias.add(c);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaCategorias;
    }

    public boolean salvarImagem(String fileName, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PROD_IMG (FK_ID_PRODUTO,NOME)\n"
                    + "VALUES (?,?)");

            comandoSQL.setInt(1, idProd);
            comandoSQL.setString(2, fileName);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public ArrayList<Produto> getProdutosDisponiveis() {
        Conexao conec = new Conexao();
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_PRODUTO, NOME, VALOR_UNIT FROM SUPLEMENTOS.PRODUTO WHERE STATUS = 1;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProd(rs.getInt("ID_PRODUTO"));
                    p.setNome(rs.getString("NOME"));
                    p.setPreco(rs.getDouble("VALOR_UNIT"));
                    listaProduto.add(p);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaProduto;
    }

    public ArrayList<Produto> getProdutosTotal() {
        Conexao conec = new Conexao();
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_PRODUTO, NOME, VALOR_UNIT FROM SUPLEMENTOS.PRODUTO ;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProd(rs.getInt("ID_PRODUTO"));
                    p.setNome(rs.getString("NOME"));
                    p.setPreco(rs.getDouble("VALOR_UNIT"));
                    listaProduto.add(p);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaProduto;
    }

    public Produto getProduto(int idProd) {
        Conexao conec = new Conexao();
        Produto prod = new Produto();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT PROD.ID_PRODUTO, PROD.NOME AS NOME_PRODUTO, PROD.DESCRICAO, PROD.VALOR_UNIT, PROD.QUANTIDADE, PROD.FK_ID_USUARIO, PROD.STATUS, IMG.NOME AS NOME_IMG "
                    + "FROM SUPLEMENTOS.PRODUTO PROD \n"
                    + "LEFT JOIN SUPLEMENTOS.PROD_IMG IMG \n"
                    + "ON PROD.ID_PRODUTO = IMG.FK_ID_PRODUTO \n"
                    + "WHERE PROD.ID_PRODUTO = " + idProd + ";");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    prod.setIdProd(rs.getInt("ID_PRODUTO"));
                    prod.setNome(rs.getString("NOME_PRODUTO"));
                    prod.setDescricao(rs.getString("DESCRICAO"));
                    prod.setPreco(rs.getDouble("VALOR_UNIT"));
                    prod.setQuantidade(rs.getInt("QUANTIDADE"));
                    prod.setIdUsuário(rs.getInt("FK_ID_USUARIO"));
                    prod.setStatus(rs.getBoolean("STATUS"));
                    prod.setNomeImg(rs.getString("NOME_IMG"));
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return prod;
    }

    public ArrayList<ImagemProduto> getImagem(int idProd) {
        Conexao conec = new Conexao();
        ArrayList<ImagemProduto> img = new ArrayList<ImagemProduto>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_IMG, FK_ID_PRODUTO, NOME FROM SUPLEMENTOS.PROD_IMG PROD WHERE FK_ID_PRODUTO = " + idProd + ";");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ImagemProduto image = new ImagemProduto();
                    image.setIdImg(rs.getInt("ID_IMG"));
                    image.setIdProd(rs.getInt("FK_ID_PRODUTO"));
                    image.setNome(rs.getString("NOME"));
                    img.add(image);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return img;
    }

    public ArrayList<ImagemProduto> getImagensTotal() {
        Conexao conec = new Conexao();
        ArrayList<ImagemProduto> img = new ArrayList<ImagemProduto>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_IMG, FK_ID_PRODUTO, NOME "
                    + "FROM SUPLEMENTOS.PROD_IMG PROD;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ImagemProduto image = new ImagemProduto();
                    image.setIdImg(rs.getInt("ID_IMG"));
                    image.setIdProd(rs.getInt("FK_ID_PRODUTO"));
                    image.setNome(rs.getString("NOME"));
                    img.add(image);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return img;
    }


    public ArrayList<Resposta> getRespostas(int idProd) {
        Conexao conec = new Conexao();
        ArrayList<Resposta> listaResposta = new ArrayList<>();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    PERG.ID_PERGUNTA,\n"
                    + "    PERG.PERGUNTA,\n"
                    + "    RES.ID_RESPOSTA,\n"
                    + "    RES.RESPOSTA\n"
                    + "FROM\n"
                    + "    SUPLEMENTOS.PRODUTO PRO\n"
                    + "		LEFT JOIN\n"
                    + "    SUPLEMENTOS.RESPOSTA_PROD_PERG RES ON RES.FK_ID_PRODUTO = PRO.ID_PRODUTO\n"
                    + "        LEFT JOIN\n"
                    + "    SUPLEMENTOS.PERGUNTA PERG ON PERG.ID_PERGUNTA = RES.FK_ID_PERGUNTA\n"
                    + "WHERE\n"
                    + "    PRO.ID_PRODUTO =" + idProd + " AND PRO.STATUS = 1;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Resposta resp = new Resposta();
                    resp.setIdPergunta(rs.getInt("ID_PERGUNTA"));
                    resp.setPergunta(rs.getString("PERGUNTA"));
                    resp.setIdResposta(rs.getInt("ID_RESPOSTA"));
                    resp.setResposta(rs.getString("RESPOSTA"));
                    listaResposta.add(resp);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaResposta;
    }

    public ArrayList<Categorias> getCategoriaProduto(int idProd) {
        Conexao conec = new Conexao();
        ArrayList<Categorias> listaCategorias = new ArrayList<>();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    CATEG.ID_CATEGORIA,\n"
                    + "    CATEG.NOME AS NOME_CATEGORIA\n"
                    + "FROM\n"
                    + "    SUPLEMENTOS.PRODUTO PRO\n"
                    + "        LEFT JOIN\n"
                    + "    SUPLEMENTOS.PROD_CATEGORIA CATPROD ON PRO.ID_PRODUTO = CATPROD.FK_ID_PRODUTO\n"
                    + "        LEFT JOIN\n"
                    + "    SUPLEMENTOS.CATEGORIA CATEG ON CATEG.ID_CATEGORIA = CATPROD.FK_ID_CATEGORIA\n"
                    + "WHERE\n"
                    + "    PRO.ID_PRODUTO = " + idProd + " AND PRO.STATUS = 1;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Categorias cate = new Categorias();
                    cate.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                    cate.setNome(rs.getString("NOME_CATEGORIA"));
                    listaCategorias.add(cate);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaCategorias;
    }

    public ArrayList<Objetivo> getObjetivoProduto(int idProd) {
        Conexao conec = new Conexao();
        ArrayList<Objetivo> listaObjetivo = new ArrayList<>();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    OBJ.ID_OBJETIVO,\n"
                    + "    OBJ.NOME AS NOME_OBJETIVO\n"
                    + " FROM\n"
                    + "    SUPLEMENTOS.PRODUTO PRO\n"
                    + "        LEFT JOIN\n"
                    + "    SUPLEMENTOS.PROD_OBJETIVO OBJPRO ON PRO.ID_PRODUTO = OBJPRO.FK_ID_PRODUTO\n"
                    + "        LEFT JOIN\n"
                    + "    SUPLEMENTOS.OBJETIVO OBJ ON OBJ.ID_OBJETIVO = OBJPRO.FK_ID_OBJETIVO\n"
                    + "WHERE\n"
                    + "    PRO.ID_PRODUTO=" + idProd + " AND PRO.STATUS = 1;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Objetivo obje = new Objetivo();
                    obje.setIdObjetivo(rs.getInt("ID_OBJETIVO"));
                    obje.setDescricaoObj(rs.getString("NOME_OBJETIVO"));
                    listaObjetivo.add(obje);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaObjetivo;
    }

    public String getImagemLastName(int idImagem) {
        Conexao conec = new Conexao();
        String imageName = null;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT SUBSTRING(NOME, INSTR(NOME, '_') + 1, LENGTH(NOME)) AS LAST_NOME FROM SUPLEMENTOS.PROD_IMG WHERE ID_IMG = " + idImagem + ";");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    imageName = (rs.getString("LAST_NOME"));
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return imageName;
    }

    public boolean excluirImagem(int idImg) {
        boolean retorno = false;
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM SUPLEMENTOS.PROD_IMG WHERE ID_IMG = " + idImg + ";");

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean disableProduto(int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.PRODUTO \n"
                    + " SET STATUS = ? \n"
                    + " WHERE ID_PRODUTO = ?");

            comandoSQL.setBoolean(1, false);
            comandoSQL.setInt(2, idProd);

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
}
