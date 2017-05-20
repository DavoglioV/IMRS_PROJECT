package enums;


public enum CommitType {
    ALL_COMMITS(1, "Todos os Commits"),
    SPECIFIC_COMMIT(2, "Commit especifico");
    
    private Integer codigo;
    private String descricao;
    
    private CommitType (Integer cod, String descricao){
	this.codigo = cod;
	this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static CommitType getByCodigo(Integer paramCodigo) {
        if (paramCodigo == null) {
            return null;
        }
        for (CommitType enumRetorno : CommitType.values()) {
            if (enumRetorno.codigo.equals(paramCodigo)) {
                return enumRetorno;
            }
        }
        return null;
    }
    
    /** 
     * Obtem o tipo de commit pela descrição
     **/
    public static CommitType getByDescricao(String paramDescricao) {
        if (paramDescricao == null) {
            return null;
        }
        for (CommitType enumRetorno : CommitType.values()) {
            if (enumRetorno.descricao.equals(paramDescricao)) {
                return enumRetorno;
            }
        }
        return null;
    }
    
    public CommitType[] getValues(){
	return this.getValues();
    }
    
}
