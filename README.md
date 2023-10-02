# Decision-making in conditions of full information. The task of packing into containers

## 🪄 To run the app:
* Make sure Node.js and npm are installed on your computer.
* From the command line in the './frontend' folder, run the command 'npm install' to install all necessary dependencies.
* After installing the dependencies, build the project by running 'npm run build'.
* After launching the Spring Boot application, open a browser and go to the address 'http://localhost:8080' (or another port on which Spring Boot works by default).

## Results

# Analytical Calculation (Number of Containers)

| Data | Row 1 | Row 2 | Row 3 | Row 1+2+3 |
|------|-------|-------|-------|----------|
| Number of Containers | 9 | 10 | 13 | 31 |

# Data - Number of Containers and Computational Complexity

## Without Sorting

| Data | Number of Containers | Computational Complexity |
|------|----------------------|--------------------------|
|       | NFA | FFA | WFA | BFA | NFA | FFA | WFA | BFA |
|------|-----|-----|-----|-----|-----|-----|-----|-----|
| Row 1 | 12 | 10 | 10 | 10 | 20 | 73 | 91 | 150 |
| Row 2 | 13 | 11 | 12 | 11 | 20 | 84 | 116 | 171 |
| Row 3 | 15 | 15 | 15 | 15 | 20 | 132 | 163 | 290 |
| Row 1+2+3 | 40 | 35 | 37 | 35 | 60 | 779 | 949 | 1747 |

## Sorted in Ascending Order

| Data | Number of Containers | Computational Complexity |
|------|----------------------|--------------------------|
|       | NFA | FFA | WFA | BFA | NFA | FFA | WFA | BFA |
|------|-----|-----|-----|-----|-----|-----|-----|-----|
| Row 1 | 12 | 12 | 12 | 12 | 80 | 146 | 157 | 223 |
| Row 2 | 11 | 11 | 11 | 11 | 80 | 135 | 145 | 200 |
| Row 3 | 15 | 15 | 15 | 15 | 80 | 185 | 199 | 304 |
| Row 1+2+3 | 39 | 39 | 39 | 39 | 306 | 1047 | 1085 | 1826 |

## Sorted in Descending Order

| Data | Number of Containers | Computational Complexity |
|------|----------------------|--------------------------|
|       | NFA | FFA | WFA | BFA | NFA | FFA | WFA | BFA |
|------|-----|-----|-----|-----|-----|-----|-----|-----|
| Row 1 | 12 | 10 | 10 | 10 | 80 | 148 | 210 | 324 |
| Row 2 | 11 | 10 | 10 | 10 | 80 | 136 | 153 | 215 |
| Row 3 | 15 | 14 | 14 | 14 | 80 | 205 | 244 | 391 |
| Row 1+2+3 | 39 | 33 | 33 | 33 | 306 | 1156 | 1493 | 2629 |
