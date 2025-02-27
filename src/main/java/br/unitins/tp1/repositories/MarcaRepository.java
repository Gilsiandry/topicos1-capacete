package br.unitins.tp1.repositories;

import java.util.List;

import br.unitins.tp1.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    // Método para buscar todas as marcas
    public List<Marca> listarTodas() {
        return listAll();
    }

    // Método para buscar marca por ID
    public Marca buscarPorId(Long id) {
        return findById(id);
    }

    // Método para salvar uma nova marca
    @Transactional
    public Marca salvar(Marca marca) {
        persist(marca);
        return marca;
    }

    // Método para atualizar a marca
    @Transactional
    public Marca atualizar(Long id, Marca marca) {
        Marca marcaExistente = findById(id);
        if (marcaExistente != null) {
            marcaExistente.setNome(marca.getNome());
            persist(marcaExistente);
            return marcaExistente;
        }
        return null;
    }

    // Método para excluir uma marca
    public boolean excluir(Long id) {
        Marca marca = findById(id);
        if (marca != null) {
            delete(marca);
            return true;
        }
        return false;
    }
}
