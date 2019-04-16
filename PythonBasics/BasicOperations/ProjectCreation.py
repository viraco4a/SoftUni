architectName = input()
projectNumber = int(input())
hoursPerProject = 3
hoursNeeded = projectNumber * hoursPerProject;

print('The architect {} will need {} hours to complete {} project/s.'.format(architectName, hoursNeeded, projectNumber))