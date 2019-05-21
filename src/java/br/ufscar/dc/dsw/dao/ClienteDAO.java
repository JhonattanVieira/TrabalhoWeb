/**
 *
 * @author Flash
 */
import br.ufscar.dc.dsw.pojo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
 
public class ClienteDAO extends GenericDAO<Cliente> {
 
    @Override
    Cliente get(Long id) {
        EntityManager em = this.getEntityManager();
        Cliente usuario = em.find(Cliente.class, id);
        em.close();
        return usuario;
    }
 
    @Override
    public List<Cliente> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findAll");
        List<Cliente> lista = q.getResultList();
        em.close();
        return lista;
    }
 
    @Override
    public void save(Cliente usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }
 
    @Override
    void update(Cliente usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }
 
    @Override
    public void delete(Cliente usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Cliente.class, usuario.getId());
        tx.begin();
        em.remove(usuario);
        tx.commit();
    }
 
    public Cliente getByNome(String nome) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByNome", Cliente.class);
        q.setParameter("nome", nome);
        return q.getSingleResult();
    }
}
