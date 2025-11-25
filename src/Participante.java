import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Participante {
    private int idParticipante;
    private String nomeParticipante;
    private String loginParticipante;
    private String senhaParticipante;
    private String emailParticipante;
    private String enderecoParticipante;
    private String telefoneParticipante;

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
        return this.telefoneParticipante;
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

    public void mostrar(){
      System.out.println(this.toString());
    }

    public Participante loginParticipante(String participante)throws Exception{
      FileReader fr = new FileReader("participantes.txt");
      BufferedReader br = new BufferedReader(fr);
      String linha = "";
      while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            if(loginParticipante.equals(dados[1]) && senhaParticipante.equals(dados[2])){
                Participante p1 = new Participante(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
                br.close();
                return p1;
            }
      }
         br.close();
         return null;
                
    }

    public Boolean registrarParticipante(Participante participante) throws Exception{
      FileWriter fw = new FileWriter("participantes.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);

      String linha = participante.getEmailParticipante() + ";" + participante.getEnderecoParticipante() + ";" + participante.getIdParticipante() + ";" + participante.getLoginParticipante() + ";" + 
      participante.getNomeParticipante() + ";" + participante.getSenhaParticipante() + ";" + participante.getTelefoneParticipante();

      bw.write(linha);
      bw.newLine();
      bw.close();

      return true;
    }

    public ArrayList <Participante> listarParticipantes() throws Exception{
      ArrayList<Participante> participantes = new ArrayList<>();
      FileReader fr = new FileReader("participantes.txt");
      BufferedReader br = new BufferedReader(fr);
      String linha = "";
      while ((linha = br.readLine()) != null){
         String[] dados = linha.split(";");
         Participante p1 = new Participante(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
         participantes.add(p1);
      }
      return participantes;
    }
}
