package main.service;

import main.domain.Pessoa;
import main.repository.PessoaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class PessoaService {
    PessoaRepository pessoaRepository = new PessoaRepository();

    public void cadastraPessoa(String tipoCVF) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.print("Digite um nome: ");
        pessoa.setNome(in.readLine());

        System.out.print("CPF ou CNPJ: ");
        pessoa.setCpfCnpj(in.readLine());

        System.out.print("EMAIL: ");
        pessoa.setEmail(in.readLine());

        System.out.print("TELEFONE: ");
        pessoa.setTelefone(in.readLine());

        System.out.print("RUA: ");
        pessoa.setRua(in.readLine());

        System.out.print("NUMERO: ");
        pessoa.setNumero(sc.nextInt());

        System.out.print("COMPLEMENTO: ");
        pessoa.setComplemento(in.readLine());

        System.out.print("BAIRRO: ");
        pessoa.setBairro(in.readLine());

        System.out.print("CIDADE: ");
        pessoa.setCidade(in.readLine());

        System.out.print("UF: ");
        pessoa.setUf(in.readLine());

        pessoaRepository.cadastraPessoa(pessoa, tipoCVF);
    }

    public List<Pessoa> carregaPessoaPorTipo(String tipo) {
        return pessoaRepository.carregaPessoaPorTipo(tipo);
    }

    public void printPessoa(Pessoa pessoa) {
        System.out.println(pessoa.getId() + ") " + pessoa.getNome());
        System.out.println("CPF ou CNPJ: " + pessoa.getCpfCnpj());
        System.out.println("EMAIL: " + pessoa.getEmail());
        System.out.println("TELEFONE: " + pessoa.getTelefone());
        System.out.println("RUA: " + pessoa.getRua());
        System.out.println("NUMERO: " + pessoa.getNumero());
        System.out.println("COMPLEMENTO: " + pessoa.getComplemento());
        System.out.println("BAIRRO: " + pessoa.getBairro());
        System.out.println("CIDADE: " + pessoa.getCidade());
        System.out.println("UF: " + pessoa.getUf());
    }

    public void printListaPessoas(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            this.printPessoa(pessoa);
        }
    }

    public void printIdENome(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId() + ") " + pessoa.getNome());
        }
    }

    public Pessoa findPessoaById(Integer id, String tipoCVF) {
        return pessoaRepository.findPessoaById(id, tipoCVF);
    }

}
