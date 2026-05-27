package com.universidad.post1_u11.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universidad.post1_u11.model.Pedido;
import com.universidad.post1_u11.model.Producto;
import com.universidad.post1_u11.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired // Code Smell: inyeccion en campo
    private PedidoRepository repo;

    // Long Method: valida, calcula, notifica y persiste en un solo metodo
    public String procesarPedido(Long clienteId, String clienteNombre,
            String clienteEmail, String clienteTelefono,
            String clienteDireccion, String clienteCiudad,
            String clienteCodigoPostal, List<Long> productosIds,
            List<Integer> cantidades, String metodoPago,
            boolean esUrgente, String codigoDescuento) {
        // Validacion del cliente (deveria ser metodo separado)
        if (clienteId == null || clienteNombre == null
                || clienteNombre.isBlank() || clienteEmail == null
                || !clienteEmail.contains("@")) {
            return "ERROR_CLIENTE";
        }
        // Calculo de total (Long Method smell)
        double total = 0;
        for (int i = 0; i < productosIds.size(); i++) {
            Producto p = repo.findProductoById(productosIds.get(i));
            if (p == null)
                return "ERROR_PRODUCTO";
            total += p.getPrecio() * cantidades.get(i);
        }
        // Descuento (logica de negocio mezclada)
        if (codigoDescuento != null && codigoDescuento.equals("VIP10")) {
            total = total * 0.90;
        } else if (codigoDescuento != null &&
                codigoDescuento.equals("NEW20")) {
            total = total * 0.80;
        }
        // Notificacion (responsabilidad ajena)
        System.out.println("Enviando email a: " + clienteEmail);
        System.out.println("Pedido urgente: " + esUrgente);
        Pedido pedido = new Pedido(clienteId, clienteNombre, total);
        return "OK_" + repo.save(pedido).getId();
    }
}
