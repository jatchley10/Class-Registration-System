# Class-Registration-System
## Overview of the project
This is a program written in java which uses the Model-View-Control design pattern. It takes in a tab seperated value file and creates different class objects out of the information given. This file is included in the repository and is titled `project1input.csv`. It then split the cells in the file on the tab character. This is shown in the block below.

```
Scanner in = new Scanner(Paths.get("project1input.csv"),"UTF-8");
 while(in.hasNextLine()){
    values = in.nextLine();
    courseData = new ArrayList(Arrays.asList(values.split("\t")));
```
