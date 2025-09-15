package com.mballem.curso.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {
    @Override
    public BigDecimal convert(String source) {
        if (source == null || source.trim().isEmpty()) {
            return null;
        }
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
            Number number = format.parse(source.trim());
            return new BigDecimal(number.toString());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Valor inválido para BigDecimal: " + source, e);
        }
    }
}