import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Lance {
    private int idLance;
    private Participante participante;
    private ItemLeilao itemLeilao;
    private Double valorLance;
    private String dataLance;
    private String horaLance;

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

    public String getDataLance(){
        return this.dataLance;
    }
    public void setDataLance(String dataLance){
       this.dataLance = dataLance;
    }

    public String getHoraLance(){
        return this.horaLance;
    }
    public void setHoraLance(String horaLance){
       this.horaLance = horaLance;
    }

    public Lance(int idLance, Participante participante, ItemLeilao itemLeilao, Double valorLance, String dataLance, String horaLance){
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
         Lance p1 = new Lance(Integer.parseInt(dados[0]), null, null, Double.valueOf(dados[1]), String.valueOf(dados[3]), String.valueOf(dados[4]));
         lances.add(p1);
      }
      br.close();
      return lances;
    }

}
