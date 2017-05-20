package metricas.acoplamentoaferente;

import java.util.Date;

import enums.CommitType;


public class AcoplamentoAferenteViewHelper {
    private  String pathProject;
    private  String pathFile;
    private  CommitType commitType;
    private  String commit;
    private  String commitFrom;
    private  String commitTo;
    
    private Date dataInicio;
    private Date dataFim;
    
    public AcoplamentoAferenteViewHelper(){
	popularCampos();
    }
    
    private void popularCampos() {
	pathProject = "";
	pathFile = "";
	commitType = CommitType.getByCodigo(1);
	commit = "";
	commitFrom = "";
	commitTo = "";
	dataInicio = new Date();
	dataFim = new Date();
    }

    public String getPathProject() {
        return pathProject;
    }
    public void setPathProject(String pathProject) {
        this.pathProject = pathProject;
    }
    public String getPathFile() {
        return pathFile;
    }
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
    public CommitType getCommitType() {
        return commitType;
    }
    public void setCommitType(CommitType commitType) {
        this.commitType = commitType;
    }
    public String getCommit() {
        return commit;
    }
    public void setCommit(String commit) {
        this.commit = commit;
    }
    public String getCommitFrom() {
        return commitFrom;
    }
    public void setCommitFrom(String commitFrom) {
        this.commitFrom = commitFrom;
    }
    public String getCommitTo() {
        return commitTo;
    }
    public void setCommitTo(String commitTo) {
        this.commitTo = commitTo;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    
}
