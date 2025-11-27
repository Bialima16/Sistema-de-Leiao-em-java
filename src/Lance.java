import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Lance {
    private int idLance;
    private Participante participante;
    private ItemLeilao itemLeilao;
    private Double valorLance;
    private Date dataLance;
    private Time horaLance;

    public int getIdlance(){
        return this.idLance;
    }
    public void setIdLance(int idLance){
       this.idLance = idLance;
    }

     public Participante getParticipante(){
        return this.participante;
    }
    public void setParticipante(Participante participante){
       this.participante = participante;
    }

    public ItemLeilao getItemLeilao(){
        return this.itemLeilao;
    }
    public void setItemLeilao(ItemLeilao itemLeilao){
       this.itemLeilao = itemLeilao;
    }

     public Double getValorLance(){
        return this.valorLance;
    }
    public void setValorLance(Double valorLance){
       this.valorLance = valorLance;
    }

    public Date getDataLance(){
        return this.dataLance;
    }
    public void setDataLance(Date dataLance){
       this.dataLance = dataLance;
    }

    public Time getHoraLance(){
        return this.horaLance;
    }
    public void setHoraLance(Time horaLance){
       this.horaLance = horaLance;
    }

    public Lance(int idLance, Participante participante, ItemLeilao itemLeilao, Double valorLance, Date dataLance, Time horaLance){
        this.idLance = idLance;
        this.participante = participante;
        this.itemLeilao = itemLeilao;
        this.valorLance = valorLance;
        this.dataLance = dataLance;
        this.horaLance = horaLance;  
    }

    public void mostrar(){
        System.out.println(this.toString());
    }

    public Boolean registarLance(Lance lance) throws Exception{
      FileWriter fw = new FileWriter("lance.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);

      String linha = lance.getIdlance() + ";" + lance.getValorLance() + ";" + lance.getItemLeilao() + ";" + lance.getDataLance() + ";" + 
      lance.getHoraLance() + ";" + lance.getParticipante();

      bw.write(linha);
      bw.newLine();
      bw.close();
      return true;
    }

    public ArrayList <Lance> listarLances() throws Exception{
      ArrayList<Lance> lances = new ArrayList<>();
      FileReader fr = new FileReader("lance.txt");
      BufferedReader br = new BufferedReader(fr);
      String linha = "";
      while ((linha = br.readLine()) != null){
         String[] dados = linha.split(";");
         Lance p1 = new Lance(Integer.parseInt(dados[0]), null, null, Double.valueOf(dados[1]), Date.valueOf(dados[3]), Time.valueOf(dados[4]));
         lances.add(p1);
      }
      br.close();
      return lances;
    }

}
