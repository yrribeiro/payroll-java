# Payroll system
This is a work in progress...

## Detected code smells
| ID |             Code smell              |        Location        | Progress| Issue Number |
| -------- | -------------------------------| :---:|:---:|:---:|
|     1    |  Negative conditional              |(x2) CreatePayment; FindEmployee| :x: |:---:|
|     2    |  Long method               | FindEmployee | :x: |:---:|
|     3    |  Duplication               |(x2) TimeCard; FindEmployee | :heavy_check_mark:; :x: |#14; #13|
|     4    |  Logic conditional not encapsulated               | FindEmployee | :x: |:---:|
|     5    |  Long import               | AddEmployee |:heavy_check_mark: |#15|
