package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Marca;
import br.unitins.tp1.repositories.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    public List<Marca> listarTodasMarcas() {
        return marcaRepository.listarTodas();
    }

    public Marca buscarMarcaPorId(Long id) {
        return marcaRepository.buscarPorId(id);
    }

    public Marca salvarMarca(Marca marca) {
        return marcaRepository.salvar(marca);
    }

    public Marca atualizarMarca(Long id, Marca marca) {
        return marcaRepository.atualizar(id, marca);
    }

    public boolean excluirMarca(Long id) {
        return marcaRepository.excluir(id);
    }
}
