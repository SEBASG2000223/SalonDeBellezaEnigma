package com.proyectoEnigma.dao;

import com.proyectoEnigma.domain.Accesorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccesoriosDao extends JpaRepository<Accesorios, Long> {

    @Query(value = "SELECT a FROM Accesorios a WHERE LOWER(a.nombreAccesorio) LIKE CONCAT(:texto, '%') ORDER BY a.nombreAccesorio")
    public List<Accesorios> consultaJPQLPorNombreAccesorio(String texto);

}
