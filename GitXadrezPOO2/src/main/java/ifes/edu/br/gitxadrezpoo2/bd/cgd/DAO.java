package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import java.util.List;

public interface DAO<T> {
    public T salvar(T obj);
    public boolean excluir(T obj);
    public List<T> obter(Class<T> classe);    
}
