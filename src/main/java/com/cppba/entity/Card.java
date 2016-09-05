package com.cppba.entity;


public class Card  {
    private Integer id ;
    private String cardName ;
    private String cardNumber ;

    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }

    public String getCardName(){
        return  cardName;
    }
    public void setCardName(String cardName ){
        this.cardName = cardName;
    }

    public String getCardNumber(){
        return  cardNumber;
    }
    public void setCardNumber(String cardNumber ){
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
