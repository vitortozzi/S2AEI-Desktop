
package Model;

import java.util.List;

public class Aluno extends Usuario {
    
    private String matricula;
    private String curso;
    private int periodo;
    private List<Projeto> projetosParticipa;
    private Projeto projetoLidera;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public List<Projeto> getProjetosParticipa() {
        return projetosParticipa;
    }

    public void setProjetosParticipa(List<Projeto> projetosParticipa) {
        this.projetosParticipa = projetosParticipa;
    }

    public Projeto getProjetoLidera() {
        return projetoLidera;
    }

    public void setProjetoLidera(Projeto projetoLidera) {
        this.projetoLidera = projetoLidera;
    }
    
    
    
}
