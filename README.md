# Decision-making in conditions of full information. The task of packing into containers

## 🪄 To run the app:
* Make sure Node.js and npm are installed on your computer.
* From the command line in the './frontend' folder, run the command 'npm install' to install all necessary dependencies.
* After installing the dependencies, build the project by running 'npm run build'.
* After launching the Spring Boot application, open a browser and go to the address 'http://localhost:8080' (or another port on which Spring Boot works by default).

## Results

Based on the obtained results, it can be said that if the calculation speed is important and the order of the data does not need to be taken into account and there is no need to optimize the number of containers, NFA is the best choice. Algorithms FFA, WFA, BFA in almost all cases show the same results of determining the number of containers, but at the same time there is a noticeable difference in computational complexity: the complexity of the BFA algorithm is almost 2 times greater than that of FFA and WFA. This is because the BFA algorithm, when searching for the most suitable container, at each iteration of the loop checks not only whether the current container can contain the item, but also whether it has a minimum free space so that the load can still be placed. However, on the other hand, BFA guarantees the most optimized number of containers.

Regarding the method of data ordering, the worst results of determining the number of containers can be observed with the input data ordered in ascending order. This is because smaller loads are placed in one container and many small containers are created for larger loads that come later.

The studied algorithms showed the best results on input data ordered in descending order. This order of elements allows to reduce the number of containers used, due to more efficient placement of large loads. However, it is worth remembering that in this case a larger number of comparisons is required.
