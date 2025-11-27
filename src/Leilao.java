import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Leilao {
    private int idLeilao;
    private Date dataInicioLeiao;
    private Time horaInicioLeilao;
    private Date dataFimLeilao;
    private Time horaFimLeilao;
    private Boolean statusLeilao;

     public int getIdLeilao(){
        return this.idLeilao;
    }
    public void setIdLeilao(int idLeilao){
       this.idLeilao = idLeilao;
    }

     public Date getDataInicioLeiao(){
        return this.dataInicioLeiao;
    }
    public void setDataInicioLeiao(Date dataInicioLeiao){
       this.dataInicioLeiao = dataInicioLeiao;
    }

    public Time getHoraInicioLeilao(){
        return this.horaInicioLeilao;
    }
    public void setHoraInicioLeilao(Time horaInicioLeilao){
       this.horaInicioLeilao = horaInicioLeilao;
    }

     public Date getDataFimLeilao(){
        return this.dataFimLeilao;
    }
    public void setDataFimLeilao(Date dataFimLeilao){
       this.dataFimLeilao = dataFimLeilao;
    }

    public Time getHoraFimLeilao(){
        return this.horaFimLeilao;
    }
    public void setHoraFimLeilao(Time horaFimLeilao){
       this.horaFimLeilao = horaFimLeilao;
    }

     public Boolean getStatusLeilao(){
        return this.statusLeilao;
    }
    public void setStatusLeilao(Boolean statusLeilao){
       this.statusLeilao = statusLeilao;
    }

    public Leilao (int idLeilao, Date dataInicioLeiao, Time horaInicioLeilao, Date dataFimLeilao, Time horaFimLeilao, Boolean statusLeilao ){
        this.idLeilao = idLeilao;
        this.dataInicioLeiao = dataInicioLeiao;
        this.horaInicioLeilao = horaInicioLeilao;
        this.dataFimLeilao = dataFimLeilao;
        this.horaFimLeilao = horaFimLeilao;
        this.statusLeilao = statusLeilao;
    }

    public void mostrar(){
      System.out.println(this.toString());
    }

    public Leilao  consultarLeilao(int idLeilao) throws Exception {
        FileReader fr = new FileReader("leilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";

        Leilao leilao = new Leilao(0, null, null, null, null, null);

         while ((linha = br.readLine()) != null) {
               String[] dados = linha.split(",");
               if (idLeilao == Integer.parseInt(dados[0])) {
                  leilao.setIdLeilao(Integer.parseInt(dados[0]));
                  leilao.setDataInicioLeiao(Date.valueOf(dados[1]));
                  leilao.setHoraInicioLeilao(Time.valueOf(dados[2]));
                  leilao.setDataFimLeilao(Date.valueOf(dados[3]));
                  leilao.setHoraFimLeilao(Time.valueOf(dados[4]));
                  leilao.setStatusLeilao(Boolean.valueOf(dados[5]));
                  
                  break;
               }
         }
         br.close();
         fr.close();
         return leilao;
    }

    public Boolean registrarLeilao(Leilao leilao) throws Exception{
      FileWriter fw = new FileWriter("leilao.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);

      String linha = leilao.getIdLeilao() + ";" + leilao.getDataInicioLeiao() + ";" + leilao.getHoraInicioLeilao() + ";" + leilao.getDataFimLeilao() + ";" + 
      leilao.getHoraFimLeilao() + ";" + leilao.getStatusLeilao();

      bw.write(linha);
      bw.newLine();
      bw.close();
      return true;
    }

    public Boolean iniciarLeilao(int idLeilao) throws Exception { 
        FileReader fr = new FileReader("leilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        StringBuilder sb = new StringBuilder(); //Montar um novo conteúdo do arquivo depois de modificado 

         while ((linha = br.readLine()) != null) {
               String[] dados = linha.split(";");
               if (idLeilao == Integer.parseInt(dados[0])) {
                  dados[5] = "true"; // Atualiza o status do leilão para true 
               }
               sb.append(String.join(";", dados)).append("\n"); // Montar a linha com o conteúdo atualizado
         }
         br.close();
         fr.close();

         // Reescreve o arquivo com o status atualizado
         FileWriter fw = new FileWriter("leilao.txt");
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(sb.toString());
         bw.close();

         return true;
    }
    
    public Boolean encerrarLeilao(int idLeilao) throws Exception {
        FileReader fr = new FileReader("leilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        StringBuilder sb = new StringBuilder();

         while ((linha = br.readLine()) != null) {
               String[] dados = linha.split(";");
               if (idLeilao == Integer.parseInt(dados[0])) {
                  dados[5] = "false"; // Atualiza o status do leilão para false (encerrado)
               }
               sb.append(String.join(";", dados)).append("\n");
         }
         br.close();
         fr.close();

         // Reescreve o arquivo com o status atualizado
         FileWriter fw = new FileWriter("leilao.txt");
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(sb.toString());
         bw.close();

         return true;
    }

    public ArrayList <Leilao> listarLeiloes() throws Exception{
      ArrayList<Leilao> leiloes = new ArrayList<>();
      FileReader fr = new FileReader("leilao.txt");
      BufferedReader br = new BufferedReader(fr);
      String linha = "";
      while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            Leilao l1 = new Leilao(Integer.parseInt(dados[0]), Date.valueOf(dados[1]), Time.valueOf(dados[2]), Date.valueOf(dados[3]), Time.valueOf(dados[4]), Boolean.valueOf(dados[5]));
            leiloes.add(l1);
      }
         br.close();
         return leiloes;
    }

}
