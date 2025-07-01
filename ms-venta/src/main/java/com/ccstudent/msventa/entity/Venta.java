package com.ccstudent.msventa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "idTipoVenta", nullable = false)
    private Long tipoVentaId;

    @Column(name = "idFormaPago", nullable = false)
    private Long formaPagoId;

    @Column(name = "fechaventa")
    private LocalDateTime fechaventa;

    @PrePersist
    public void prePersist() {
        this.fechaventa = LocalDateTime.now();
    }

    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
}
