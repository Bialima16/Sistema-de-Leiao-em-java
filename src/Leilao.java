import java.sql.Date;
import java.sql.Time;

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

}
