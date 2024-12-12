package com.example.tarea4.model.converters;

import com.example.tarea4.model.EstadoDispositivo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true) // Aplica automáticamente a cualquier atributo del tipo EstadoDispositivo
public class EstadoDispositivoConverter implements AttributeConverter<EstadoDispositivo, String> {

    @Override
    public String convertToDatabaseColumn(EstadoDispositivo attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case FUNCIONA_PERFECTO:
                return "funciona perfecto";
            case FUNCIONA_A_MEDIAS:
                return "funciona a medias";
            case NO_FUNCIONA:
                return "no funciona";
            default:
                throw new IllegalArgumentException("Estado desconocido: " + attribute);
        }
    }

    @Override
    public EstadoDispositivo convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        switch (dbData) {
            case "funciona perfecto":
                return EstadoDispositivo.FUNCIONA_PERFECTO;
            case "funciona a medias":
                return EstadoDispositivo.FUNCIONA_A_MEDIAS;
            case "no funciona":
                return EstadoDispositivo.NO_FUNCIONA;
            default:
                throw new IllegalArgumentException("Valor desconocido en la base de datos: " + dbData);
        }
    }
}
