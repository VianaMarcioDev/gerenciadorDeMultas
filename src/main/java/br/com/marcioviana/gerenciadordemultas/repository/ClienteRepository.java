package br.com.marcioviana.gerenciadordemultas.repository;

import br.com.marcioviana.gerenciadordemultas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
