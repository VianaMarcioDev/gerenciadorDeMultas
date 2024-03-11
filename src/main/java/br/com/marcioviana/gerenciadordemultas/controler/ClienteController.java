package br.com.marcioviana.gerenciadordemultas.controler;

import br.com.marcioviana.gerenciadordemultas.model.Cliente;
import br.com.marcioviana.gerenciadordemultas.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;


    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest, UriComponentsBuilder uriComponentsBuilder){
        Cliente novoCliente = clienteRequest.paraCliente();

        clienteRepository.save(novoCliente);

        URI caminho = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(caminho).build();
    }
}
