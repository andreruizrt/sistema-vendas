package main.service;

import main.domain.Pessoa;
import main.domain.Produto;
import main.repository.ProdutoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    ProdutoRepository produtoRepository = new ProdutoRepository();

    public List<Produto> carregaProdutos() throws SQLException {
        return produtoRepository.carregaProdutos();
    }

    public void cadastraProduto() throws IOException {
        Produto produto = new Produto();

        System.out.print("Digite a descrição do produto: ");
        produto.setDescricao(in.readLine());

        System.out.print("Digite o código de barras: ");
        produto.setCodigoBarras(in.readLine());

        System.out.print("Digite o fabricante: ");
        produto.setFabricante(in.readLine());

        System.out.print("Informe a quantidade em estoque: ");
        produto.setQtdEstoque(sc.nextInt());

        System.out.print("Digite o preço do produto: ");
        produto.setPreco(sc.nextDouble());

        produtoRepository.cadatraProduto(produto);
    }

    public void printIdEDescricao(List<Produto> produtos) {
        for (Produto produto : produtos) {
            System.out.println(produto.getId() + ") " + produto.getDescricao());
        }
    }
}
