select
===
select * from User user where 1=1
@if(!isEmpty(age)){
and age = #age#
@}
@if(!isEmpty(name)){
and name = #name#
@}
@orm.lazyMany({"id":"userId"},"user.selectCard","Card");
@orm.lazyMany({"id":"userId"},"user.selectUserCard","UserCard");

selectCard
===
select card.* from UserCard userCard left join Card card on userCard.cardId=card.id
where userCard.userId=#userId#

selectUserCard
===
select userCard.* from UserCard userCard left join Card card on userCard.cardId=card.id
where userCard.userId=#userId#

selectUser
===
select * from User user where 1=1
@if(!isEmpty(user.age)){
and age = #user.age#
@}
@if(!isEmpty(user.name)){
and name = #user.name#
@}