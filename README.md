# Metro Card Java Project

This is a Java solution for the Metro Card System problem on GeekTrust.

## How to Run

1. Place the input commands in `input.txt`
2. Run `Main.java` in your IDE (Eclipse/IntelliJ)
3. Output will print to console

## Features

- Balance top-up via `BALANCE`
- Travel with `CHECK_IN` using passenger type and station
- 50% discount on return journey
- 2% penalty on insufficient balance
- Final summary output with totals and passenger counts

## Sample Input
BALANCE MC1 600
CHECK_IN MC1 ADULT CENTRAL
PRINT_SUMMARY

## Sample Output
TOTAL_COLLECTION CENTRAL 200 0
PASSENGER_TYPE_SUMMARY
ADULT 1
