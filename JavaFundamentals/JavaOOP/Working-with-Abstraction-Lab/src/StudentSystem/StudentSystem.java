package StudentSystem;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[]args)
    {
        if (args[0].equals("Create"))
        {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade =Double.parseDouble(args[3]);
            if (!repo.containsKey(name))
            {
                Student student = null;
                if (grade >= 5.00){
                    student = new ExcellentStudent(name, age, grade);
                } else if (grade < 5.00 && grade >= 3.50) {
                    student = new AverageStudent(name, age, grade);
                } else {
                    student = new WeakStudent(name, age, grade);
                }
                repo.put(name,student);
            }
        }
        else if (args[0].equals("Show"))
        {
            String name = args[1];
            if (repo.containsKey(name))
            {
                Student student = repo.get(name);

                System.out.println(student.toString());
            }
        }
    }
}
