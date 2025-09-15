package com.br.enums;

public enum Category {
    CARRO("Carro"), MOTO("Moto");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
