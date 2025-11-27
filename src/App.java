import java.util.Scanner;
import java.sql.Date;
import java.sql.Time;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        Participante participante = new Participante(0, "", "", "", "", "", "");
        Leilao leilao = new Leilao(0, null, null, null, null, false);
        ItemLeilao item = new ItemLeilao(0, null, "", 0.0, false, null);
        Lance lance = new Lance(0, null, null, 0.0, null, null);


        int opc = 0;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Registrar Participante");
            System.out.println("2 - Login Participante");
            System.out.println("3 - Registrar Leilão");
            System.out.println("4 - Consultar Leilão");
            System.out.println("5 - Iniciar Leilão");
            System.out.println("6 - Encerrar Leilão");
            System.out.println("7 - Registrar Item");
            System.out.println("8 - Arrematar Item");
            System.out.println("9 - Listar Participantes");
            System.out.println("10 - Listar Leilões");
            System.out.println("11 - Listar Itens");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {

                case 1:
                    System.out.println("\n--- REGISTRAR PARTICIPANTE ---");
                    System.out.print("ID: ");
                    int idP = teclado.nextInt(); teclado.nextLine();
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("Login: ");
                    String login = teclado.nextLine();
                    System.out.print("Senha: ");
                    String senha = teclado.nextLine();
                    System.out.print("Email: ");
                    String email = teclado.nextLine();
                    System.out.print("Endereço: ");
                    String end = teclado.nextLine();
                    System.out.print("Telefone: ");
                    String tel = teclado.nextLine();

                    Participante novo = new Participante(idP, nome, login, senha, email, end, tel);
                    novo.registrarParticipante(novo);
                    System.out.println("Participante registrado!");
                    break;

                case 2:
                    System.out.println("\n--- LOGIN PARTICIPANTE ---");
                    System.out.print("Login: ");
                    String log = teclado.nextLine();
                    System.out.print("Senha: ");
                    String sen = teclado.nextLine();

                    // cria objeto só com login/senha para testar no método
                    Participante loginP = new Participante(0, "", log, sen, "", "", "");

                    Participante logado = loginP.loginParticipante(log);

                    if (logado != null) {
                        System.out.println("Login OK! Bem-vindo: " + logado.getNomeParticipante());
                    } else {
                        System.out.println("Login INVÁLIDO.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- REGISTRAR LEILÃO ---");
                    System.out.print("ID do leilão: ");
                    int idL = teclado.nextInt(); teclado.nextLine();

                    System.out.print("Data início (AAAA-MM-DD): ");
                    Date di = Date.valueOf(teclado.nextLine());

                    System.out.print("Hora início (HH:MM:SS): ");
                    Time hi = Time.valueOf(teclado.nextLine());

                    System.out.print("Data fim (AAAA-MM-DD): ");
                    Date df = Date.valueOf(teclado.nextLine());

                    System.out.print("Hora fim (HH:MM:SS): ");
                    Time hf = Time.valueOf(teclado.nextLine());

                    Leilao novoL = new Leilao(idL, di, hi, df, hf, false);
                    novoL.registrarLeilao(novoL);

                    System.out.println("Leilão registrado!");
                    break;

                case 4:
                    System.out.println("\n--- CONSULTAR LEILÃO ---");
                    System.out.print("ID do leilão: ");
                    int idLC = teclado.nextInt();

                    Leilao leilaoC = leilao.consultarLeilao(idLC);

                    if (leilaoC.getIdLeilao() != 0) {
                        leilaoC.mostrar();
                    } else {
                        System.out.println("Leilão não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- INICIAR LEILÃO ---");
                    System.out.print("ID: ");
                    int idI = teclado.nextInt();

                    leilao.iniciarLeilao(idI);
                    System.out.println("Leilão iniciado!");
                    break;

                case 6:
                    System.out.println("\n--- ENCERRAR LEILÃO ---");
                    System.out.print("ID: ");
                    int idE = teclado.nextInt();

                    leilao.encerrarLeilao(idE);
                    System.out.println("Leilão encerrado!");
                    break;

                case 7:
                    System.out.println("\n--- REGISTRAR ITEM ---");
                    System.out.print("ID do item: ");
                    int idItem = teclado.nextInt(); teclado.nextLine();

                    System.out.print("ID do leilão do item: ");
                    int idLeilaoItem = teclado.nextInt(); teclado.nextLine();
                    Leilao leilaoItem = new Leilao(idLeilaoItem, null, null, null, null, false);

                    System.out.print("Descrição: ");
                    String desc = teclado.nextLine();

                    System.out.print("Lance mínimo: ");
                    Double lanceMin = teclado.nextDouble();

                    ItemLeilao novoItem = new ItemLeilao(idItem, leilaoItem, desc, lanceMin, false, null);
                    novoItem.registrarItem(novoItem);

                    System.out.println("Item registrado!");
                    break;

                case 8:
                    System.out.println("\n--- ARREMATAR ITEM ---");
                    System.out.print("ID do item: ");
                    int idA = teclado.nextInt();

                    System.out.print("Valor do lance: ");
                    double valorL = teclado.nextDouble();

                    item.arrematarItem(idA, valorL);
                    System.out.println("Item arrematado!");
                    break;

                case 9:
                    System.out.println("\n--- LISTAR PARTICIPANTES ---");
                    for (Participante p : participante.listarParticipantes()) {
                        p.mostrar();
                    }
                    break;

                case 10:
                    System.out.println("\n--- LISTAR LEILÕES ---");
                    for (Leilao l : leilao.listarLeiloes()) {
                        l.mostrar();
                    }
                    break;

                case 11:
                    System.out.println("\n--- LISTAR ITENS ---");
                    for (ItemLeilao it : item.listarItens()) {
                        it.mostrar();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opc != 0);

        teclado.close();
    }
}
