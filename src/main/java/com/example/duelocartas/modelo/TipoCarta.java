package com.example.duelocartas.modelo;

import com.example.duelocartas.excepcion.InvalidTipoCartaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCarta {
    MAGIA,
    CRIATURA,
    TRAMPA;

    @JsonCreator
    public static TipoCarta fromValue(String value) {
        for (TipoCarta tipo : TipoCarta.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new InvalidTipoCartaException("TipoCarta inválido: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}