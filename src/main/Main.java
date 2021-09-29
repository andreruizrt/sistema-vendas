/**
 * AUTOR: ANDRE RUIZ
 */

package main;

import main.domain.*;
import main.service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        UsuarioService usuarioService = new UsuarioService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();

        Usuario usuario = null;

        // TODO criar usuário default
        // Usuario: admin
        // Senha: admin
        while (usuario == null) {
            usuario = usuarioService.autenticaUsuario();
        }

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
                    compraService.realizarCompra();
                    break;
                case 7:
                    vendaService.realizarVenda();
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
        System.out.println("7 - Usuario          |");
        System.out.println("**********************");
        System.out.println("8 - Voltar           |");
        System.out.println("9 - Sair             |");
        System.out.print("Digite a opção: ");
    }

    private static void menuCadatrar() throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();
        UsuarioService usuarioService = new UsuarioService();

        int opcao = 0;

        while(opcao != 8) {
            printSubmenu();
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
                    vendaService.realizarVenda();
                    break;
                case 7:
                    usuarioService.cadastraUsuario();
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

    private static void menuPesquisar() {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();
        UsuarioService usuarioService = new UsuarioService();


        int opcao = 0;

        while(opcao != 8) {
            printSubmenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Pessoa pessoa = pessoaService.findPessoaById("C");
                    if(pessoa != null) {
                        pessoaService.printPessoa(pessoa);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 2:
                    pessoa = pessoaService.findPessoaById("V");
                    if(pessoa != null) {
                        pessoaService.printPessoa(pessoa);
                    } else {
                        System.out.println("Vendedor não encontrado!");
                    }
                    break;
                case 3:
                    pessoa = pessoaService.findPessoaById("F");
                    if(pessoa != null) {
                        pessoaService.printPessoa(pessoa);
                    } else {
                        System.out.println("Fornecedor não encontrado!");
                    }
                    break;
                case 4:
                    Produto produto = produtoService.findProdutoById();
                    if(produto != null) {
                        produto.toString();
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 5:
                    Compra compra = compraService.findCompraById();
                    if(compra != null) {
                        compra.toString();
                    } else {
                        System.out.println("Compra não encontrada!");
                    }
                    break;
                case 6:
                    Venda venda = vendaService.findVendaById();
                    if(venda != null) {
                        venda.toString();
                    } else {
                        System.out.println("Venda não encontrada!");
                    }
                    break;
                case 7:
                    Usuario usuario = usuarioService.findUsuarioById();
                    if(usuario != null) {
                        usuario.toString();
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
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

    private static void menuEditar() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        UsuarioService usuarioService = new UsuarioService();


        int opcao = 0;

        while(opcao != 8) {
            printSubmenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    pessoaService.updatePessoaById("C");
                    break;
                case 2:
                    pessoaService.updatePessoaById("V");
                    break;
                case 3:
                    pessoaService.updatePessoaById("F");
                    break;
                case 4:
                    produtoService.updateProdutoById();
                    break;
                case 5:
                    usuarioService.updateUsuarioById();
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

    private static void menuExcluir() {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();
        UsuarioService usuarioService = new UsuarioService();

        int opcao = 0;

        while(opcao != 8) {
            printSubmenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    pessoaService.deletePessoaById("C");
                    break;
                case 2:
                    pessoaService.deletePessoaById("V");
                    break;
                case 3:
                    pessoaService.deletePessoaById("F");
                    break;
                case 4:
                    produtoService.deleteProdutoById();
                    break;
                case 5:
                    compraService.deleteCompraById();
                    break;
                case 6:
                    vendaService.deleteVendaById();
                    break;
                case 7:
                    usuarioService.deleteUsuarioById();
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
        PessoaService pessoaService = new PessoaService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();
        UsuarioService usuarioService = new UsuarioService();

        System.out.println("[*] GERANDO RELATÓRIO");
        List<Compra> compras = new ArrayList<>();
    }
}

