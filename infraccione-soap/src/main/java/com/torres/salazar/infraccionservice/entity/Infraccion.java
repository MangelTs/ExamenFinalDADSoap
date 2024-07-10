package com.torres.salazar.infraccionservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="infracciones")
@Getter
@Setter
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "tipo_infraccion", nullable = false, length = 20)
    private String tipoInfraccion;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "monto_multa", nullable = false, precision = 8, scale = 2)
    private BigDecimal montoMulta;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}
