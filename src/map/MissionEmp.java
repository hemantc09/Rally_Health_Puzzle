/*
 * *
 * Thursday June 2 2016
 * Programmer: Hemant Choudhari
 * Phone no- 669 243 0277
 * email: hemantc09@gmail.com
 */
package map;

import java.util.*;
import java.io.*;

public class MissionEmp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of inputs");
		int n = sc.nextInt(); // number of inputs
		int mission_id; // mission id
		String emp_name; // employee name
		// list to store the input mission id and employee name
		List<String> missionAndEmployees = new LinkedList<>();
		for (int i = 0; i < n; i++) // get the input from use and store it
		{
			System.out.println("Enter the mission id");
			mission_id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the employee name");
			emp_name = sc.nextLine();
			String temp;
			temp = mission_id + "," + emp_name;
			missionAndEmployees.add(temp);
		}

		// map to store data based key=employee name , value=mission id
		Map<String, Set<String>> missionsByEmployeeNameAsKey = new HashMap<String, Set<String>>();
		// map to store data based key=mission id , value=employee name
		Map<String, Set<String>> employeesByMissionIdAsKey = new HashMap<String, Set<String>>();
		// map to store the results
		Map<String, String> result = new HashMap<String, String>();

		// System.out.println("missionAndEmployees size"+missionAndEmployees.size());
		for (int j = 0; j < missionAndEmployees.size(); j++)// iterate all list
		{
			// get the list element in the variable mAE i.e. Mission And
			// Employees
			String mAE = missionAndEmployees.get(j);
			StringTokenizer token = new StringTokenizer(mAE, ",");
			String mission = token.nextToken(); // get the mission id
			String name = token.nextToken(); // get the employee name

			// Prepare map of Employees by mission ids
			if (missionsByEmployeeNameAsKey.containsKey(name)) {
				missionsByEmployeeNameAsKey.get(name).add(mission);
			}
			// else create new set and add it in the missionsByEmployee set
			else {
				Set<String> missionSet = new HashSet<String>();
				missionSet.add(mission);
				missionsByEmployeeNameAsKey.put(name, missionSet);
			}

			// Prepare map of missions by Employee Name
			if (employeesByMissionIdAsKey.containsKey(mission)) {
				employeesByMissionIdAsKey.get(mission).add(name);
			}
			// else create new set and add it in the employeesByMission set
			else {
				Set<String> nameSet = new HashSet<String>();
				nameSet.add(name);
				employeesByMissionIdAsKey.put(mission, nameSet);
			}
		}

		// System.out.println(missionsByEmployeeNameAsKey);
		// System.out.println();
		// System.out.println(employeesByMissionIdAsKey);

		// Loop over unique mission ids and get all missions completed by
		// employees
		for (String mission : employeesByMissionIdAsKey.keySet()) {
			// create cumulative set which contain values as a mission id
			Set<String> cumulativeMissions = new HashSet<String>();
			for (String employee : employeesByMissionIdAsKey.get(mission)) {
				cumulativeMissions.addAll(missionsByEmployeeNameAsKey
						.get(employee));
			}

			// System.out.println("cumulativeMissions"+cumulativeMissions);
			// Exclude current mission from the cumulativeMissions set because
			// we want only unique value no repetition [2,4,5,6] and key is 2
			// then remove 2 from value
			cumulativeMissions.remove(mission);

			// Add mission id and corresponding count of missions by other
			// employees in the result set
			result.put(mission, String.valueOf(cumulativeMissions.size()));
		}

		// Display Output by mission ids and no. of other mission
		System.out.println("\nMission Id \t # of other missions");

		for (String mission : result.keySet()) {
			System.out.println(mission + "\t\t" + result.get(mission));
		}
	}
}
