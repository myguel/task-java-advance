/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.core.dao;

import java.util.List;
import pe.edu.cibertec.core.domain.Auditoria;

/**
 *
 * @author jpadilla
 */
public interface AuditoriaDAO {

    public List<Auditoria> list();

    public Auditoria getById(Integer id);

    public void insert(Auditoria auditoria);

    public void update(Auditoria auditoria);

    public void delete(Auditoria auditoria);
}
