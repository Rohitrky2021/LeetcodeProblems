# Write your MySQL query statement below
# SELECT eu.unique_id , e.name FROM 
# Employees e  LEFT JOIN EmployeeUNI eu 
# USING(id)

# # Write your MySQL query statement below
# select 
# eu.unique_id as unique_id, e.name as name
# from Employees e left join EmployeeUNI eu on e.id = eu.id


# Write your MySQL query statement below
select unique_id, name from Employees as e
left join EmployeeUNI as c
on e.id = c.id