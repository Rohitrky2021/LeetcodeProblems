# Write your MySQL query statement below

SELECT Person.FirstName, Person.LastName, Address.City, Address.State from Person LEFT JOIN Address on Person.PersonId = Address.PersonId;

# SELECT `FirstName`, `LastName`, `City`, `State` FROM `Person`
#     LEFT JOIN `Address` USING(`PersonId`)



#     SELECT p.firstName, p.lastName, a.city, a.state 
# FROM Person p left join Address a
# ON p.personId = a.personId;



# SELECT p.firstName, p.lastName, a.city, a.state from Person p, Address a
# WHERE p.personId = a.personId
# UNION
# SELECT  p.firstName, p.lastName, null, null from Person p
# WHERE p.personId NOT IN (Select personId from Address);



# SELECT P.firstName, P.lastName, A.city, A.state
# FROM Person P
# LEFT JOIN Address A USING (personId)