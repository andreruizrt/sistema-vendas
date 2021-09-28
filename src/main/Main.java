package main;

import main.domain.Pessoa;
import main.domain.Produto;
import main.domain.Usuario;
import main.service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();
        UsuarioService usuarioService = new UsuarioService();

        List<Pessoa> fornecedores = new ArrayList<>();
        List<Pessoa> vendedores = new ArrayList<>();
        List<Pessoa> clientes = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();


        Usuario usuario = null;

        while (usuario == null) {
            usuario = usuarioService.autenticaUsuario();
        }

        Pessoa vendedorLogado = pessoaService
                .findPessoaById(usuario.getIdVendedor(), "V");

        System.out.println("\nBem vindo, " + vendedorLogado.getNome() + "!");

        fornecedores = pessoaService.carregaPessoaPorTipo("F");
        vendedores = pessoaService.carregaPessoaPorTipo("V");
        clientes = pessoaService.carregaPessoaPorTipo("C");

        int opcao = 0;

        while(opcao != 8) {
            printMenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuCadatrar();
                    break;
                case 2:
                    menuPesquisar();
                    break;
                case 3:
                    menuEditar();
                    break;
                case 4:
                    menuExcluir();
                    break;
                case 5:
                    menuRelatorios();
                    break;
                case 6:
//                    compraService.realizarCompra();
                    break;
                case 7:
//                    vendaService.realizarVenda();
                    break;
                case 8:
                    System.out.println("Voltando...");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Opção incorreta.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n***** MENU ******\n");
        System.out.println("1 - Cadastrar        |");
        System.out.println("2 - Pesquisar        |");
        System.out.println("3 - Editar           |");
        System.out.println("4 - Excluir          |");
        System.out.println("5 - Gerar relatórios |");
        System.out.println("6 - Realizar compra  |");
        System.out.println("7 - Realizar venda   |");
        System.out.println("**********************");
        System.out.println("8 - Voltar           |");
        System.out.println("9 - Fechar           |");
        System.out.print("Digite a opção: ");
    }

    private static void printSubmenu() {
        System.out.println("\n***** MENU ******\n");
        System.out.println("1 - Cliente          |");
        System.out.println("2 - Vendedor         |");
        System.out.println("3 - Fornecedor       |");
        System.out.println("4 - Produto          |");
        System.out.println("5 - Compra           |");
        System.out.println("6 - Venda            |");
        System.out.println("**********************");
        System.out.println("7 - Voltar           |");
        System.out.println("8 - Sair             |");
        System.out.print("Digite a opção: ");
    }

    private static void menuCadatrar() throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();

        printSubmenu();

        int opcao = 0;

        while(opcao != 7) {
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    pessoaService.cadastraPessoa("C");
                    break;
                case 2:
                    pessoaService.cadastraPessoa("V");
                    break;
                case 3:
                    pessoaService.cadastraPessoa("F");
                    break;
                case 4:
                    produtoService.cadastraProduto();
                    break;
                case 5:
                    compraService.realizarCompra();
                    break;
                case 6:
//                  vendaService.realizarVenda();
                    break;
                case 7:
                    System.out.println("Voltando...");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Opção incorreta.");
            }
        }


    }

    private static void menuPesquisar() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        printSubmenu();

        int opcao = 0;

        while(opcao != 8) {
            printMenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuCadatrar();
                    break;
                case 2:
                    menuPesquisar();
                    break;
                case 3:
                    menuEditar();
                    break;
                case 4:
                    menuExcluir();
                    break;
                case 5:
                    menuRelatorios();
                    break;
                case 6:
//                    compraService.realizarCompra();
                    break;
                case 7:
//                    vendaService.realizarVenda();
                    break;
                case 8:
                    System.out.println("Voltando...");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Opção incorreta.");
            }
        }
    }

    private static void menuRelatorios() {
        printSubmenu();
    }

    private static void menuExcluir() {
        printSubmenu();
    }

    private static void menuEditar() {
        printSubmenu();
    }
}

