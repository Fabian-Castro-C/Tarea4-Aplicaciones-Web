package com.example.tarea4.model.converters;

import com.example.tarea4.model.TipoDispositivo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true) // Aplica automáticamente a cualquier atributo del tipo TipoDispositivo
public class TipoDispositivoConverter implements AttributeConverter<TipoDispositivo, String> {

    @Override
    public String convertToDatabaseColumn(TipoDispositivo attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case PANTALLA:
                return "pantalla";
            case NOTEBOOK:
                return "notebook";
            case TABLET:
                return "tablet";
            case CELULAR:
                return "celular";
            case CONSOLA:
                return "consola";
            case MOUSE:
                return "mouse";
            case TECLADO:
                return "teclado";
            case IMPRESORA:
                return "impresora";
            case PARLANTE:
                return "parlante";
            case AUDIFONOS:
                return "audífonos";
            case OTRO:
                return "otro";
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + attribute);
        }
    }

    @Override
    public TipoDispositivo convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        switch (dbData) {
            case "pantalla":
                return TipoDispositivo.PANTALLA;
            case "notebook":
                return TipoDispositivo.NOTEBOOK;
            case "tablet":
                return TipoDispositivo.TABLET;
            case "celular":
                return TipoDispositivo.CELULAR;
            case "consola":
                return TipoDispositivo.CONSOLA;
            case "mouse":
                return TipoDispositivo.MOUSE;
            case "teclado":
                return TipoDispositivo.TECLADO;
            case "impresora":
                return TipoDispositivo.IMPRESORA;
            case "parlante":
                return TipoDispositivo.PARLANTE;
            case "audífonos":
                return TipoDispositivo.AUDIFONOS;
            case "otro":
                return TipoDispositivo.OTRO;
            default:
                throw new IllegalArgumentException("Valor desconocido en la base de datos: " + dbData);
        }
    }
}
