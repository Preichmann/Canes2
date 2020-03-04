/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author gabriel.rvital
 */
public class Pergunta {
    private int idPergunta;
    private String pergunta;

    public Pergunta() {
    }

    
    public Pergunta(int idPergunta, String pergunta) {
        this.idPergunta = idPergunta;
        this.pergunta = pergunta;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
