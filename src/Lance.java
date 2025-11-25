import java.sql.Date;
import java.sql.Time;

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
}
