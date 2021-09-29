package main.service;

import main.domain.Venda;
import main.domain.Produto;
import main.domain.Venda;
import main.repository.ControleEstoqueRepository;
import main.repository.VendaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendaService {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    PessoaService pessoaService = new PessoaService();
    VendaRepository vendaRepository = new VendaRepository();
    ControleEstoqueRepository controleEstoqueRepository = new ControleEstoqueRepository();

    public void realizarVenda() throws SQLException, IOException {
        ProdutoService produtoService = new ProdutoService();
        Venda venda = new Venda();

        pessoaService.printIdENome(pessoaService.carregaPessoaPorTipo("V"));
        System.out.print("Informe o id do vendedor: ");
        venda.setIdVendedor(sc.nextInt());

        pessoaService.printIdENome(pessoaService.carregaPessoaPorTipo("C"));
        System.out.print("Informe o id do cliente: ");
        venda.setIdCliente(sc.nextInt());

        venda.setDtVenda(new Timestamp(System.currentTimeMillis()));
        venda.setId(vendaRepository.registaVenda(venda));

        List<Produto> produtoVendidos = new ArrayList<>();

        while(true) {
            Produto produto = new Produto();

            produtoService.printIdEDescricao(produtoService.carregaProdutos());
            System.out.print("informe o id do produto: ");
            produto.setId(sc.nextInt());

            System.out.print("informe a quantidade vendida: ");
            produto.setQtdEstoque(sc.nextInt());

            produtoVendidos.add(produto);
            controleEstoqueRepository.saidaEstoque(produto.getId(), produto.getQtdEstoque());

            System.out.println("Deseja inserir outro produto a lista de vendas? [SIM/NÃO]");
            String resposta = in.readLine();

            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Insira o próximo produto\n");
            } else {
                vendaRepository.inserirVendaItens(venda.getId(), produtoVendidos);
                break;
            }
        }
    }

    public Venda findVendaById() {
        System.out.println("Informe o id: ");
        int id = sc.nextInt();

        return vendaRepository.findVendaById(id);
    }

    public void deleteVendaById() {
        System.out.println("Informe o id: ");
        int id = sc.nextInt();

        vendaRepository.deleteVendaById(id);
    }
}
