package br.com.marcioviana.gerenciadordemultas.controler;

import br.com.marcioviana.gerenciadordemultas.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequest {
    @NotBlank
    @Length(min = 25, max = 25)
    private String nome;
    @NotBlank
    @Length(min = 25, max = 25)
    private String sobrenome;

    @CPF
    @NotBlank
    private String cpf;
    @Positive
    @NotNull
    private Integer rg;
    @NotBlank
    @Length(min = 30, max = 200)
    private String endereco;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 14, max = 14)
    private String telefone;

    public ClienteRequest(String nome, String sobrenome, String cpf, Integer rg, String endereco, String email, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente paraCliente(){
        return new Cliente(nome, sobrenome, cpf, rg, endereco, email, telefone);
    }

    public ClienteRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
