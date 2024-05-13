## How to install
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

The database has been automatically populated with the following exemplary data:

#### Promo Codes

| ID | Code       | Expiry               | Max Allowed Usages | Discount Amount | Currency | Percentage |
|----|------------|----------------------|--------------------|-----------------|----------|------------|
| 1  | 50USD      | 2024-05-15 00:00:00  | 2                  | 50.55           | USD      |            |
| 2  | 20EUR      | 2024-06-30 00:00:00  | 10                 | 20.75           | EUR      |            |
| 3  | 15PERCENT  | 2024-07-01 00:00:00  | 15                 |                 |          | 15.5       |
| 4  | 9PERCENT   | 2024-08-15 00:00:00  | 3                  |                 |          | 9.25       |

#### Products

| ID | Name       | Description            | Price Amount | Currency |
|----|------------|------------------------|--------------|----------|
| 1  | Shoes      | Size: 9 US             | 100.25       | USD      |
| 2  | TV         | Screen Size: 50 inches | 75.55        | EUR      |
| 3  | Large Hat  |                        | 15.23        | EUR      |

### Exemplary Usage

#### Create a new product

- **URL:** `POST localhost:8080/api/product`
- **Sample Query:** `POST localhost:8080/api/product`
- **Request Body:**
    ```json
    {
        "name": "T-Shirt",
        "description": "Boxy cut",
        "price": {
            "amount": 80.55,
            "currency": "PLN"
        }
    }
    ```

#### Get all products

- **URL:** `GET localhost:8080/api/product`
- **Sample Query:** `GET localhost:8080/api/product`

#### Update product data

- **URL:** `PUT localhost:8080/api/product/{productId}`
- **Sample Query:** `PUT localhost:8080/api/product/1`
- **Request Body:**
    ```json
    {
        "name": "White Shoes",
        "description": "Size 44",
        "price": {
            "amount": 89.22,
            "currency": "EUR"
        }
    }
    ```

#### Create a new promo code

#### Create Promo Code with fixed amount

- **URL:** `POST localhost:8080/api/promocode/fixed-amount`
- **Sample Query:** `POST localhost:8080/api/promocode/fixed-amount`
- **Request Body:**
    ```json
    {
        "code": "EXTRA100EURO",
        "expiry": "2025-05-14T15:30:00",
        "maxAllowedUsages": 1,
        "discount": {
            "amount": 100.00,
            "currency": "EUR"
        }
    }
    ```

#### Create Promo Code with percentage

- **URL:** `POST localhost:8080/api/promocode/percentage`
- **Sample Query:** `POST localhost:8080/api/promocode/percentage`
- **Request Body:**
    ```json
    {
        "code": "HALFOFPRICE",
        "expiry": "2026-05-14T15:30:00",
        "maxAllowedUsages": 5,
        "percentage": 50.00
    }
    ```

#### Get all promo codes

- **URL:** `GET localhost:8080/api/promocode`
- **Sample Query:** `GET localhost:8080/api/promocode`

#### Get one promo code's details

- **URL:** `GET localhost:8080/api/promocode/{code}`
- **Sample Query:** `GET localhost:8080/api/promocode/20EUR`

#### Get the discounted price

- **URL:** `GET localhost:8080/api/product/{productId}?promocode={code}`
- **Sample Query:** `GET localhost:8080/api/product/2?promocode=20EUR`

#### Simulate purchase

- **URL:** `POST localhost:8080/api/purchase/{productId}?promocode={code}`
- **1. Sample Query:** `POST localhost:8080/api/purchase/3?promocode=9PERCENT`
- **2. Sample Query:** `POST localhost:8080/api/purchase/3`

#### Sales report

- **URL:** `GET localhost:8080/api/report`
- **Sample Query:** `GET localhost:8080/api/report`
