# Rally_Health_Puzzle
Rally_Helth_Puzzle  by Hemant Choudhari

Read me file Problem Statement: For each mission, how many other missions are also undertaken by employees who participate in that one?

Here’s an example (and how you can expect the incoming data to be formatted):
Mission ID   Employee
1             Sam
2             Ilya
2             Sue
3             Megan
4             Ilya
5             Ilya
5             Sue
6             Sue
7             Sam

Output:
Mission ID  # of other missions

1           1
2           3
3           0
4           2
5           3
6           2
7           1
You can assume all employees will go by their first name only, and that each first name is unique.

Algorithm:
1. Create input list
2. create set based on id
3. create set based on employee
4. create cumulative set which contain only the mission id unique
5. Print the result set
6. end
