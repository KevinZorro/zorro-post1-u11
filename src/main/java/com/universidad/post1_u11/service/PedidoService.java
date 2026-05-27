package com.universidad.post1_u11.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;

import com.universidad.post1_u11.model.CodigoDescuento;
import com.universidad.post1_u11.model.DatosCliente;
import com.universidad.post1_u11.model.LineaPedido;
import com.universidad.post1_u11.model.Pedido;
import com.universidad.post1_u11.repository.PedidoRepository;

@Service
public class PedidoService {
 private final PedidoRepository repo;
 private final NotificacionService notificacion;
 public PedidoService(PedidoRepository repo,
 NotificacionService notificacion) {
 this.repo = repo;
 this.notificacion = notificacion;
 }


    public String procesarPedido(DatosCliente cliente,
        LineaPedido[] lineas,
        boolean esUrgente,
        CodigoDescuento descuento) {
        double total = calcularTotal(lineas);
        double totalConDescuento = aplicarDescuento(total, descuento);
        notificarCliente(cliente, esUrgente);
        return persistirPedido(cliente, totalConDescuento);
    }

    private double calcularTotal(LineaPedido[] lineas) {
        return Arrays.stream(lineas)
                .mapToDouble(l -> l.getPrecioUnitario() * l.getCantidad())
                .sum();
    }

    private double aplicarDescuento(double total, CodigoDescuento d) {
        return d != null ? total * (1 - d.getPorcentaje()) : total;
    }

    private void notificarCliente(DatosCliente cliente, boolean esUrgente) {
        this.notificacion.notificarPedido(cliente, esUrgente);
    }

    private String persistirPedido(DatosCliente cliente, double total) {
        Pedido pedido = new Pedido(1L, cliente.getNombre(), total);
        return "OK_" + repo.save(pedido).getId();
    }
}
