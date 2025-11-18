public class Participante {
    private int idParticipante;
    private String nomeParticipante;
    private String loginParticipante;
    private String senhaParticipante;
    private String emailParticipante;
    private String enderecoParticipante;
    private Strint telefoneParticipante;

    public int getIdParticipante(){
        return this.idParticipante;
    }
    public void setIdParticipante(int idParticipante){
       this.idParticipante = idParticipante;
    }

     public String getNomeParticipante(){
        return this.nomeParticipante;
    }
    public void setNomeParticipante(String nomeParticipante){
       this.nomeParticipante = nomeParticipante;
    }

     public String getLoginParticipante(){
        return this.loginParticipante;
    }
    public void setLoginParticipante(String loginParticipante){
       this.loginParticipante = loginParticipante;
    }

    public String getSenhaParticipante(){
        return this.senhaParticipante;
    }
    public void setSenhaParticipante(String senhaParticipante){
       this.senhaParticipante = senhaParticipante;
    }

     public String getEmailParticipante(){
        return this.emailParticipante;
    }
    public void setEmailParticipante(String emailParticipante){
       this.emailParticipante = emailParticipante;
    }

    public String getEnderecoParticipante(){
        return this.emailParticipante;
    }
    public void setEnderecoParticipante(String enderecoParticipante){
       this.enderecoParticipante = enderecoParticipante;
    }

     public String getTelefoneParticipante(){
        return this.emailParticipante;
    }
    public void setTelefoneParticipante(String telefoneParticipante){
       this.telefoneParticipante = telefoneParticipante;
    }

    public Participante(int idParticipante, String nomeParticipante, String loginParticipante, String senhaParticipante, String emailParticipante, String enderecoParticipante, String telefoneParticipante){
        this.idParticipante = idParticipante;
        this.nomeParticipante = nomeParticipante;
        this.loginParticipante = loginParticipante;
        this.senhaParticipante = senhaParticipante;
        this.emailParticipante = emailParticipante;
        this.enderecoParticipante = enderecoParticipante;
        this.telefoneParticipante = telefoneParticipante;
    }
}
