import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ItemLeilao {
  private int idItem;
  private Leilao leilao;
  private String descricaoItem;
  private Double lanceMinimoItem;
  private Boolean itemArrematado;
  private Lance lanceArrematante;

  public int getIdItem() {
    return this.idItem;
  }
  public void setIdItem(int idItem) {
    this.idItem = idItem;
  }

  public Leilao getLeilao() {
    return this.leilao;
  }
  public void setLeilao(Leilao leilao) {
    this.leilao = leilao;
  }

  public String getDescricaoItem() {
    return this.descricaoItem;
  }
  public void setDescricaoItem(String descricaoItem) {
    this.descricaoItem = descricaoItem;
  }

  public Double getLanceMinimoItem() {
    return this.lanceMinimoItem;
  }
  public void setLanceMinimoItem(Double lanceMinimoItem) {
    this.lanceMinimoItem = lanceMinimoItem;
  }

  public Boolean getItemArrematado() {
    return this.itemArrematado;
  }
  public void setItemArrematado(Boolean itemArrematado) {
    this.itemArrematado = itemArrematado;
  }

  public Lance getLanceArrematante() {
    return this.lanceArrematante;
  }
  public void setLanceArrematante(Lance lanceArrematante) {
    this.lanceArrematante = lanceArrematante;
  }

  public ItemLeilao(int idItem, Leilao leilao, String descricaoItem, Double lanceMinimoItem, Boolean itemArrematado, Lance lanceArrematante) {
    this.idItem = idItem;
    this.leilao = leilao;
    this.descricaoItem = descricaoItem;
    this.lanceMinimoItem = lanceMinimoItem;
    this.itemArrematado = itemArrematado;
    this.lanceArrematante = lanceArrematante;
  }


  public void mostrar() {
    System.out.println(this.toString());
  }

  public Boolean registrarItem(ItemLeilao item) throws Exception {
    FileWriter fw = new FileWriter("itemleilao.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(item.getIdItem() + ";" + item.getLeilao().getIdLeilao() + ";" + item.getDescricaoItem() + ";" + item.getLanceMinimoItem() + ";" + item.getItemArrematado() + ";" + (item.getLanceArrematante() != null ? item.getLanceArrematante().getIdlance() : "null"));
    bw.newLine();
    bw.close();
    return true;
  }

  public ItemLeilao consultarItem(int idItem) throws Exception {
    FileReader fr = new FileReader("itemleilao.txt");
    BufferedReader br = new BufferedReader(fr);
    String linha = "";

    ItemLeilao item = null;

    while ((linha = br.readLine()) != null) {
      String[] dados = linha.split(";");
      if (idItem == Integer.parseInt(dados[0])) {
        item = new ItemLeilao(Integer.parseInt(dados[0]), null, dados[2], Double.valueOf(dados[3]), Boolean.valueOf(dados[4]), null);
        break;
      }
    }
    br.close();
    fr.close();
    return item;
  }
 public boolean arrematarItem(int idItem, double valorLance) throws Exception {
    FileReader fr = new FileReader("itensLeilao.txt");
    BufferedReader br = new BufferedReader(fr);
    String linha = "";
    StringBuilder sb = new StringBuilder();

    while ((linha = br.readLine()) != null) {
        String[] dados = linha.split(";");
        if (idItem == Integer.parseInt(dados[0])) {
            dados[4] = "true";     
            dados[5] = valorLance + ""; 
        }
        sb.append(String.join(";", dados)).append("\n");
    }

    br.close();
    fr.close();

    FileWriter fw = new FileWriter("itensLeilao.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(sb.toString());
    bw.close();
    return true;
}
  public ArrayList<ItemLeilao> listarItens() throws Exception {
    ArrayList<ItemLeilao> itens = new ArrayList<>();
    FileReader fr = new FileReader("itemleilao.txt");
    BufferedReader br = new BufferedReader(fr);
    String linha = "";
    while ((linha = br.readLine()) != null) {
      String[] dados = linha.split(";");
      ItemLeilao item = new ItemLeilao(Integer.parseInt(dados[0]), null, dados[2], Double.valueOf(dados[3]), Boolean.valueOf(dados[4]), null);
      itens.add(item);
    }
    br.close();
    return itens;
  }

}
