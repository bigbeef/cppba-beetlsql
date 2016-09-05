select
===
select * from user user where 1=1
@if(!isEmpty(age)){
and age = #age#
@}
@if(!isEmpty(name)){
and name = #name#
@}
@ orm.many({"id":"userId"},"user.selectCard","Card");
@ orm.many({"id":"userId"},"user.selectUserCard","UserCard");

selectCard
===
select c.* from UserCard uc left join Card c on uc.cardId=c.id
where uc.userId=#userId#

selectUserCard
===
select uc.* from UserCard uc left join Card c on uc.cardId=c.id
where uc.userId=#userId#