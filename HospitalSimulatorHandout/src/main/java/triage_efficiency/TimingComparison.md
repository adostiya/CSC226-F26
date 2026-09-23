Dataset Size Linear Search Time Binary Search Time Alt O(log n) Time
100 patients 111718 ns 5810 ns 33602 ns
1,000 patients 1069477 ns 5701 ns 51196 ns
10,000 patients 4881072 ns 9698 ns 38502 ns
100,000 patients 9333866 ns 40566 ns 66474 ns

Answer these three questions in your report:
1. As the dataset grows by 10x each time, how does each algorithm's time change on
average?
Linear Search gets much slower as the data grows.
Binary Search changes much more slowly as the dataset grows. 
Exponential Search its measured time fluctuates between tests.

2. Carroll Memorial Hospital sees about 50,000 patients per year. Which search algorithm
would you recommend, and why?
Binary Search because with around 50,000 patients, it can find a patient without checking most of the records, faster than Linear. 

3. Is measuring time in nanoseconds this way actually the best way to assess
algorithmic efficiency? Why or why not?
No, because results affected by enviroment, but it can show you overall difference. 
