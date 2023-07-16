In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains a list of skills that the person has.

Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.

For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
Return any sufficient team of the smallest possible size, represented by the index of each person. You may return the answer in any order.

It is guaranteed an answer exists.

 

Example 1:

Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]
Example 2:

Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
Output: [1,2]
 

Constraints:

1 <= req_skills.length <= 16
1 <= req_skills[i].length <= 16
req_skills[i] consists of lowercase English letters.
All the strings of req_skills are unique.
1 <= people.length <= 60
0 <= people[i].length <= 16
1 <= people[i][j].length <= 16
people[i][j] consists of lowercase English letters.
All the strings of people[i] are unique.
Every skill in people[i] is a skill in req_skills.
It is guaranteed a sufficient team exists.





  class Solution {
    List<Integer> mainTeam = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for( String skill : req_skills) 
            map.put(skill,i++);

        int reqSkills = (1<<i) -1;
        //System.out.println(reqSkills);
        int skills[] = getPeopleSkillsMask(people, map);
        List<Integer> localTeam = new ArrayList<>();
        findTeam(reqSkills, skills, 0, 0, localTeam);
        //System.out.println("mt"+mainTeam);
        return convertListToArray();

    }
    int[] getPeopleSkillsMask(List<List<String>> people,HashMap<String, Integer> map )
    {
        int len = people.size();
        int skills[] = new int[len];
        for( int i = 0; i < len; i++)
        {
            for( String skill : people.get(i)) 
                skills[i] |= (1<<map.get(skill));
            //System.out.println(i+" , "+skills[i]);
        }
        return skills;
    }

    void findTeam(int reqSkills, int[] skills, int teamSkills, int person, List<Integer> localTeam )
    {
        if( mainTeam.size() >0 && localTeam.size() >= mainTeam.size()-1 ||  person == skills.length)//early stopping
            return ;

        //taking current person into team
        localTeam.add(person);

        if( (teamSkills|skills[person]) == reqSkills)
        {
            // if( mainTeam.size() == 0 || localTeam.size() < mainTeam.size())
            mainTeam = new ArrayList<Integer>(localTeam);
            //System.out.println(teamSkills+" , "+person+" , "+localTeam+" mt "+mainTeam);
            localTeam.remove(localTeam.size()-1);
            return;
        }
        else if( (teamSkills|skills[person]) > teamSkills){
            //System.out.println(teamSkills+" , "+person+" , "+localTeam+" mt "+mainTeam);
            findTeam(reqSkills, skills, teamSkills|skills[person], person+1, localTeam );
        }

        localTeam.remove(localTeam.size()-1);

        findTeam(reqSkills, skills, teamSkills, person+1, localTeam );
    }
    int[] convertListToArray()
    {
        int len = mainTeam.size();
        int skills[] = new int[len];
        //System.out.println("arra"+mainTeam);
        for( int i = 0; i < len; i++)
            skills[i] = mainTeam.get(i);
        return skills;
    }
}
