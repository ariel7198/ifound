/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ariel
 */

public class Recados {
    private static final long serialVersionUID = 123L;
    private int id_recados;
    private String data;
    private String conteudo;
    private int fk_turma;

    public Recados(String data, String conteudo) {
        this.data = data;
        this.conteudo = conteudo;
    }

    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getFk_turma() {
        return fk_turma;
    }

    public void setFk_turma(int fk_turma) {
        this.fk_turma = fk_turma;
    }
    private int getId_recados() {
        return id_recados;
    }

    public void setId_recados(int id_recados) {
        this.id_recados = id_recados;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
