
package Model;

import java.util.List;

public class Professor extends Usuario{
    
    private String departamento;
    private String disciplinaPrincipal;
    private List<Projeto> projetosOrientados;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDisciplinaPrincipal() {
        return disciplinaPrincipal;
    }

    public void setDisciplinaPrincipal(String disciplinaPrincipal) {
        this.disciplinaPrincipal = disciplinaPrincipal;
    }

    public List<Projeto> getProjetosOrientados() {
        return projetosOrientados;
    }

    public void setProjetosOrientados(List<Projeto> projetosOrientados) {
        this.projetosOrientados = projetosOrientados;
    }
    
    
    
}
