# promo-codes

### How to install
**Maven:** Verify that Maven is installed on your machine
```properties
mvn -v
```  
**Terminal:** Navigate the Project Directory:
```properties
cd spring-backend
```  
**Maven:** Build the Application:
```properties
mvn clean install
```  
**Java:** Run the Application
```properties
java -jar target/spring-backend-0.0.1-SNAPSHOT.jar
```

### Exemplary Data

#### Promo Codes

| ID | Code       | Expiry               | Max Allowed Usages | Discount Amount | Currency | Percentage |
|----|------------|----------------------|--------------------|-----------------|----------|------------|
| 1  | 50USD      | 2024-05-10 00:00:00  | 2                  | 50.55           | USD      |            |
| 2  | 20EUR      | 2024-06-30 00:00:00  | 3                  | 20.75           | EUR      |            |
| 3  | 15PERCENT  | 2024-07-01 00:00:00  | 15                 |                 |          | 15.5       |
| 4  | 9PERCENT   | 2024-08-15 00:00:00  | 3                  |                 |          | 9.25       |

#### Products

| ID | Name       | Description            | Price Amount | Currency |
|----|------------|------------------------|--------------|----------|
| 1  | Shoes      | Size: 9 US             | 100.25       | USD      |
| 2  | TV         | Screen Size: 50 inches | 75.55        | EUR      |
| 3  | Large Hat  |                        | 15.23        | EUR      |
