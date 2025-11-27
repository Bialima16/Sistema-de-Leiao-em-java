import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        Participante participante = new Participante(0, "", "", "", "", "", "");
        Leilao leilao = new Leilao(0, "", "", "", "", false);
        ItemLeilao item = new ItemLeilao(0, null, "", 0.0, false, null);
        Lance lance = new Lance(0, null, null, 0.0, null, null);


       int opicao = -1;   // começar em um valor diferente de 0

while (opicao != 0) {
    System.out.println("MENU LEILÃO");
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

    opicao = teclado.nextInt();   // lê a opção
    teclado.nextLine();           // limpar a memoria

    switch (opicao) {

        case 1:
            System.out.println("REGISTRAR PARTICIPANTE");
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
            System.out.println("LOGIN PARTICIPANTE");
            System.out.print("Login: ");
            String log = teclado.nextLine();
            System.out.print("Senha: ");
            String sen = teclado.nextLine();

            Participante loginP = new Participante(0, "", log, sen, "", "", "");

            Participante logado = loginP.loginParticipante(log);

            if (logado != null) {
                System.out.println("Login OK! Bem-vindo: " + logado.getNomeParticipante());
            } else {
                System.out.println("Login INVÁLIDO.");
            }
            break;

        case 3:
            System.out.println("REGISTRAR LEILÃO");
            System.out.print("ID do leilão: ");
            int idL = teclado.nextInt(); teclado.nextLine();

            System.out.print("Data início: ");
            String di = teclado.nextLine();

            System.out.print("Hora início: ");
            String hi = teclado.nextLine();

            System.out.print("Data fim: ");
            String df = teclado.nextLine();

            System.out.print("Hora fim: ");
            String hf = teclado.nextLine();

            Leilao novoL = new Leilao(idL, di, hi, df, hf, false);
            novoL.registrarLeilao(novoL);
            System.out.println("Leilão registrado!");
            break;

        case 4:
            System.out.println("CONSULTAR LEILÃO");
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
            System.out.println("INICIAR LEILÃO");
            System.out.print("ID: ");
            int idI = teclado.nextInt();

            leilao.iniciarLeilao(idI);
            System.out.println("Leilão iniciado!");
            break;

        case 6:
            System.out.println("ENCERRAR LEILÃO ");
            System.out.print("ID: ");
            int idE = teclado.nextInt();

            leilao.encerrarLeilao(idE);
            System.out.println("Leilão encerrado!");
            break;

        case 7:
            System.out.println("REGISTRAR ITEM");
            System.out.print("ID do item: ");
            int idItem = teclado.nextInt(); teclado.nextLine();

            System.out.print("ID do leilão: ");
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
            System.out.println("ARREMATAR ITEM");
            System.out.print("ID do item: ");
            int idA = teclado.nextInt();

            System.out.print("Valor do lance: ");
            double valorL = teclado.nextDouble();

            item.arrematarItem(idA, valorL);
            System.out.println("Item arrematado!");
            break;

        case 9:
            System.out.println("LISTAR PARTICIPANTES");
            for (Participante p : participante.listarParticipantes()) {
                p.mostrar();
            }
            break;

        case 10:
            System.out.println("LISTAR LEILÕES");
            for (Leilao l : leilao.listarLeiloes()) {
                l.mostrar();
            }
            break;

        case 11:
            System.out.println("LISTAR ITENS");
            for (ItemLeilao it : item.listarItens()) {
                it.mostrar();
            }
            break;

        case 0:
            System.out.println("Saindo");
            break;

        default:
            System.out.println("Opção inválida");
    }
}

teclado.close();
    }
}