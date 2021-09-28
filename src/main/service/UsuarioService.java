package main.service;

import main.domain.Usuario;
import main.repository.UsuarioRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UsuarioService {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void cadastraUsuario() throws IOException {
        PessoaService pessoaService = new PessoaService();
        Usuario usuario = new Usuario();

        System.out.print("Digite o usuário: ");
        usuario.setUsuario(in.readLine());

        System.out.print("Informe uma senha: ");
        String senha = in.readLine();

        System.out.print("Confirme a senha: ");
        String confirmeSenha = in.readLine();

        if( senha.equalsIgnoreCase(confirmeSenha)) {
            usuario.setSenha(senha);
        } else {
            System.out.println("As senhas não são correspondentes.");
            return;
        }

        System.out.println("****VENDEDORES****");
        pessoaService.printIdENome(pessoaService.carregaPessoaPorTipo("V"));
        System.out.print("\nDigite o ID do vendedor: ");
        usuario.setIdVendedor(sc.nextInt());
        if(pessoaService.findPessoaById(usuario.getIdVendedor(), "V") != null) {
            usuarioRepository.cadastraUsuario(usuario);
        } else {
            System.out.println("Vendedor não encontrado!");
            return;
        }
    }

    public Usuario autenticaUsuario() throws IOException {
        Usuario usuario = new Usuario();
        int tentativas = 0;

        while (true) {
            if(tentativas > 0) {
                System.out.println("Usuário ou senha errado!");
            }
            System.out.print("Usuario: ");
            usuario.setUsuario(in.readLine());

            System.out.print("Senha: ");
            usuario.setSenha(in.readLine());

            usuario = usuarioRepository.verificaCredenciais(usuario);

            if(usuario != null) {
                return usuario;
            }
            else {
                usuario = new Usuario();
                tentativas++;
                System.out.println( (3 - tentativas) + " tentativas restantes");
                if( tentativas > 2) System.exit(0);
            }
        }
    }
}
