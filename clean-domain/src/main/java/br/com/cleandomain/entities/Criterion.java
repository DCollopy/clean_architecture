package br.com.cleandomain.entities;

public class Criterion {
    private String title;
    private String description;
    private int pmd;
    private int weight;

    public Criterion(int pmd, int weight, String title, String description) {
        if(pmd <=0 || pmd >= 6){
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if(weight <=0 || weight >= 5){
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if(title.isEmpty()) {
            throw new IllegalArgumentException("Entre com o titulo!");
        }

        this.pmd = pmd;
        this.weight = weight;
        this.title = title;
        this.description = description;
    }
}
