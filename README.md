# Student Management API Documentation

<a href="https://github.com/byts-india/springboot-todo-project/blob/main/collections/task-02-post-man-collection.json" download> click here to donwload the postman collection </a>

## 1. Student Table Schema

| Field Name           | Data Type | Constraints                 | Description               |
| -------------------- | --------- | --------------------------- | ------------------------- |
| id                   | Long      | Primary Key, Auto Increment | Unique student identifier |
| name                 | String    | Not Null                    | Student full name         |
| email                | String    | Unique, Not Null            | Student email address     |
| age                  | Integer   | Not Null                    | Student age               |
| gender               | String    | Not Null                    | Male / Female / Other     |
| department           | String    | Not Null                    | Department name           |
| marks                | Double    | Default 0                   | Student marks             |
| attendancePercentage | Double    | Default 0                   | Attendance percentage     |
| feesPaid             | Boolean   | Default false               | Fee payment status        |
| status               | String    | Default ACTIVE              | Student current status    |
| city                 | String    | Nullable                    | Student city              |
| phoneNumber          | String    | Unique                      | Contact number            |

---

## 2. Allowed JpaRepository Default Methods

Only these methods should be used:

| Method            | Purpose            |
| ----------------- | ------------------ |
| save()            | Insert / Update    |
| saveAll()         | Bulk insert        |
| findAll()         | Fetch all          |
| findById()        | Fetch one by ID    |
| findAllById()     | Fetch multiple IDs |
| existsById()      | Check existence    |
| count()           | Count records      |
| deleteById()      | Delete one         |
| deleteAll()       | Delete all         |
| findAll(Pageable) | Pagination         |
| findAll(Sort)     | Sorting            |

---

## 3. API Documentation

| No | Method | Endpoint                                     | Request Type              | Payload / Params  | Internal Logic                        |
| -- | ------ | -------------------------------------------- | ------------------------- | ----------------- | ------------------------------------- |
| 1  | POST   | `/students`                                  | RequestBody               | Student JSON      | save()                                |
| 2  | POST   | `/students/bulk`                             | RequestBody               | List<Student>     | saveAll()                             |
| 3  | GET    | `/students`                                  | None                      | None              | findAll()                             |
| 4  | GET    | `/students/{id}`                             | PathVariable              | id                | findById()                            |
| 5  | PUT    | `/students/{id}`                             | PathVariable + Body       | id + Student JSON | findById() + save()                   |
| 6  | PATCH  | `/students/{id}/marks`                       | PathVariable + QueryParam | id, marks         | findById() + save()                   |
| 7  | PATCH  | `/students/{id}/attendance`                  | PathVariable + QueryParam | id, attendance    | findById() + save()                   |
| 8  | PATCH  | `/students/{id}/status`                      | PathVariable + QueryParam | id, status        | findById() + save()                   |
| 9  | PATCH  | `/students/{id}/fees`                        | PathVariable + QueryParam | id, feesPaid      | findById() + save()                   |
| 10 | DELETE | `/students/{id}`                             | PathVariable              | id                | deleteById()                          |
| 11 | DELETE | `/students`                                  | None                      | None              | deleteAll()                           |
| 12 | GET    | `/students/department/{department}`          | PathVariable              | department        | findAll() + stream().filter()         |
| 13 | GET    | `/students/city/{city}`                      | PathVariable              | city              | findAll() + stream().filter()         |
| 14 | GET    | `/students/status/{status}`                  | PathVariable              | status            | findAll() + stream().filter()         |
| 15 | GET    | `/students/filter/marks`                     | QueryParam                | minMarks          | findAll() + stream().filter()         |
| 16 | GET    | `/students/filter/attendance`                | QueryParam                | maxAttendance     | findAll() + stream().filter()         |
| 17 | GET    | `/students/filter/age`                       | QueryParam                | minAge, maxAge    | findAll() + stream().filter()         |
| 18 | GET    | `/students/filter/fees-paid`                 | None                      | None              | findAll() + stream().filter()         |
| 19 | GET    | `/students/top-5`                            | None                      | None              | findAll() + stream().limit(5)         |
| 20 | GET    | `/students/top-10`                           | None                      | None              | findAll() + stream().limit(10)        |
| 21 | GET    | `/students/page`                             | QueryParam                | page, size        | findAll(Pageable)                     |
| 22 | GET    | `/students/sort/name`                        | QueryParam                | direction         | findAll(Sort)                         |
| 23 | GET    | `/students/sort/marks`                       | QueryParam                | direction         | findAll(Sort)                         |
| 24 | GET    | `/students/count`                            | None                      | None              | count()                               |
| 25 | GET    | `/students/count/department/{department}`    | PathVariable              | department        | findAll() + stream().filter().count() |
| 26 | GET    | `/students/count/status/{status}`            | PathVariable              | status            | findAll() + stream().filter().count() |
| 27 | GET    | `/students/count/fees-paid`                  | None                      | None              | findAll() + stream().filter().count() |
| 28 | GET    | `/students/exists/{id}`                      | PathVariable              | id                | existsById()                          |
| 29 | GET    | `/students/multiple`                         | QueryParam                | ids               | findAllById()                         |
| 30 | GET    | `/students/limit-by-department/{department}` | PathVariable + QueryParam | department, limit | findAll() + stream().filter().limit() |

---

## 4. Sample Payload Structure

### Create / Update Student Payload

```json
{
  "name": "Avi",
  "email": "avi@example.com",
  "age": 21,
  "gender": "Male",
  "department": "CSE",
  "marks": 87.5,
  "attendancePercentage": 91.2,
  "feesPaid": true,
  "status": "ACTIVE",
  "city": "Coimbatore",
  "phoneNumber": "9876543210"
}
```

---

## 5. Query Parameter Examples

### Pagination

`GET /students/page?page=0&size=10`

### Sorting

`GET /students/sort/marks?direction=desc`

### Filter Marks

`GET /students/filter/marks?minMarks=75`

### Filter Age

`GET /students/filter/age?minAge=18&maxAge=22`

### Update Marks

`PATCH /students/5/marks?marks=95`

### Get Top 5

`GET /students/top-5`

### Count by Department

`GET /students/count/department/CSE`

### Limited Department Students

`GET /students/limit-by-department/CSE?limit=3`
