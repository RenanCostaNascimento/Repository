package ifes.poo1.xadrez.view.cih;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Tela {

    Scanner scanner = new Scanner(System.in);

    public int menuInicial() {
        System.out.println("1. Iniciar uma nova partida\n"
                + "2. Dados das partidas\n"
                + "3. Sair\n"
                + "4. Jogos salvos");
        return scanner.nextInt();
    }

    public int novoJogo() {
        System.out.println("1. Singleplayer\n"
                + "2. Multiplayer");
        return scanner.nextInt();
    }

    public String[] singlePlayer() {
        String nomeJogadores[] = new String[2];

        System.out.println("Digite seu nome, jogador branco:");
        nomeJogadores[0] = scanner.next();
        System.out.println("Seu oponente, o jogador preto, se chamara ZEUS!");
        nomeJogadores[1] = "ZEUS";

        apresentarJogadores(nomeJogadores);

        return nomeJogadores;
    }

    public String[] multiPlayer() {
        String nomeJogadores[] = new String[2];

        System.out.println("Digite seu nome, jogador branco:");
        nomeJogadores[0] = scanner.next();
        System.out.println("Digite seu nome, jogador preto:");
        nomeJogadores[1] = scanner.next();

        apresentarJogadores(nomeJogadores);

        return nomeJogadores;
    }

    private void apresentarJogadores(String[] nomeJogadores) {
        System.out.println("A partida se dara entre os jogadores " + nomeJogadores[0] + " e " + nomeJogadores[1] + "!\n"
                + "BEGIN!\n");
    }

    public void opcaoInvalida() {
        System.out.println("Digite um numero dentre as opcoes possiveis!");
    }

    public void mostrarMenuSair() {
        System.out.println("------- GAME OVER -------");
        Runtime.getRuntime().exit(0);

    }

    public void mostrarMenuDadosPartidas(List<HistoricoPartida> partidas, List<HistoricoJogador> jogadores) {

        StringBuffer buffer = new StringBuffer();
        
        if (partidas.isEmpty()) {
            buffer.append("Ainda não houve nenhuma partida!\n");
            System.out.println("Ainda não houve nenhuma partida!");
        } else {
            int quantPartidas = 1;
            int quantJogadores = 1;
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            buffer.append("Partidas realizadas...");
            System.out.println("Partidas realizadas...");
            buffer.append("N°  -  Inicio  -  Fim  -  Vencedor");
            System.out.println("N°  -  Inicio  -  Fim  -  Vencedor");
            for (HistoricoPartida partida : partidas) {
                buffer.append(quantPartidas + "  -  " + formatoData.format(partida.getDataHoraInicio()) + "  -  " + formatoData.format(partida.getDataHoraFim()) + "  -  " + partida.getVencedor());
                System.out.println(quantPartidas + "  -  " + formatoData.format(partida.getDataHoraInicio()) + "  -  " + formatoData.format(partida.getDataHoraFim()) + "  -  " + partida.getVencedor());
                quantPartidas++;
            }
            buffer.append("... e os seus jogadores...");
            System.out.println("... e os seus jogadores...");
            buffer.append("N°  -  Nome  -  Vitorias  -  Empates  -  Derrotas");
            System.out.println("N°  -  Nome  -  Vitorias  -  Empates  -  Derrotas");
            for (HistoricoJogador jogador : jogadores) {
                buffer.append(quantJogadores + "  -  " + jogador.getNome() + "  -  " + jogador.getVitorias() + "  -  " + jogador.getEmpates() + "  -  " + jogador.getDerrotas());
                System.out.println(quantJogadores + "  -  " + jogador.getNome() + "  -  " + jogador.getVitorias() + "  -  " + jogador.getEmpates() + "  -  " + jogador.getDerrotas());
                quantJogadores++;
            }
        }
        System.out.println();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarTabuleiro(Tabuleiro tabuleiro) {
        int numLinha = 8;
        System.out.print("\n");
        for (int linha = 7; linha >= 0; linha--) {
            System.out.print(numLinha + "   ");
            numLinha -= 1;
            for (int coluna = 0; coluna < 8; coluna++) {
                if (tabuleiro.getCasas(coluna, linha) == null) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" " + tabuleiro.getCasas(coluna, linha) + " ");
                }

            }
            System.out.print("\n");
        }
        System.out.print("\n    ");
        for (int numColuna = 1; numColuna < 9; numColuna++) {
            System.out.print(" " + numColuna + " ");
        }
        System.out.print("\n\n");
    }

    public String pegarComandoUsuario(Jogador jogador) {
        System.out.println("O que vai fazer agora, " + jogador.getNome() + "?");
        return scanner.next();
    }

    public int empatarDesistirPartida() {
        System.out.println("1. Sim\n"
                + "2. Nao");

        return scanner.nextInt();
    }

    public int promoverPeca() {
        System.out.println("1. Cavalo\n"
                + "2. Rainha");

        return scanner.nextInt();
    }

    public String controlarSalvarSairPartida() {

        System.out.println("Qual vai ser o nome da partida (nome sem espaços)?");

        return scanner.next();
    }

    public String controlarMenuJogosSalvos(List<Checkpoint> checkpoints) {

        if (checkpoints.isEmpty()) {
            System.out.println("Nenhum jogo salvo!");
        } else {
            System.out.println("NOME -- JOGADOR 1 X JOGADOR 2, DATA\n"
                    + "----------------------------");
            for (Checkpoint cp : checkpoints) {
                System.out.println(cp.toString());
            }

            System.out.println("Qual jogo deseja carregar?");
            return scanner.next();
        }

        return null;

    }

}
