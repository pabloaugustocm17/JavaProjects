# Java Projects

## 1 - Currency Converter

This a system of converter a currency from one to another using Spring Boot.

### Classes


```java
public class Currency{
    
    private String name_from;
    private String name_to;
    private Double value_conversion;
}
```


```java
public class Transaction{
    
    private Currency currency;
    private User user_send; 
    private User user_recieve;  
    private Date date_conversion;
}
```


```java
public class User{
    
    private String name;
    private String email;
    private String senha;
}
```
```java
public class Wallet{
    
    private String from;
    private Double money;
    private User user;
}
```

### Sequence Diagram

![seq-diagram-realize-transaction-v1.svg](assets%2Fseq-diagram-realize-transaction-v1.svg)

By: https://sequencediagram.org

# Font

https://www.geeksforgeeks.org/top-50-java-project-ideas-for-beginners-advanced/