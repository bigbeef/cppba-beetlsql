package com.cppba.entity;

public class UserCard {
    private Integer id ;
    private Integer userId ;
    private Integer cardId ;

    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }

    public Integer getUserId(){
        return  userId;
    }
    public void setUserId(Integer userId ){
        this.userId = userId;
    }

    public Integer getCardId(){
        return  cardId;
    }
    public void setCardId(Integer cardId ){
        this.cardId = cardId;
    }
}
