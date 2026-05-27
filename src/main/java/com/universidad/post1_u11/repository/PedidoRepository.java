package com.universidad.post1_u11.repository;

import com.universidad.post1_u11.model.Pedido;
import com.universidad.post1_u11.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Producto findProductoById(Long id);
}
