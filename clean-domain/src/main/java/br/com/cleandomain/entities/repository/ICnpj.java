package br.com.cleandomain.entities.repository;

public interface ICnpj {
    String getNumber();
    void setNumber(String number);

    boolean equals(Object o);
    int hashCode();
    String toString();
}
