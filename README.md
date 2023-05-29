# JavaProjects
 Projects with Java
## 2- Attendance Management System

```Java
class Faculty{

    private String name;

    private String adress;

}
```
```Java
class User{

    private String name;
    
    private String email;
    
    private String password;
}
```

```Java
class Admin extends User{

    private Date last_acess;

}
```
```Java
class Student extends User{

    private Faculty faculty;

}
```