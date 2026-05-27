package com.universidad.post1_u11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.universidad.post1_u11.model.DatosCliente;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    private static final Logger logger = LoggerFactory.getLogger(NotificacionService.class);

    public void notificarPedido(DatosCliente cliente, boolean urgente) {
        // logica de notificacion (email, SMS, etc.)
        logger.info("Enviando email a: {}", cliente.getEmail());
        logger.info("Pedido urgente: {}", urgente);
    }
}
