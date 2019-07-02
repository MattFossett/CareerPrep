# Coding Interview Preparation

* Personal projects are obviously important. Be able to talk about these aspects of your own projects:
 ![Grid of Common questions about projects](https://www.itbusinessedge.com/imagesvr_ce/itbe/reports/images/ed/hall20110506-01.png)

* Be able to list some faults and concerns that you have as a developer or employee
  > "Sometimes I rush projects and don't pay close attention to detail"
* Have questions prepared for them as well, interviews *should* work both ways. Asking well thought tech questions are helpful.
  > "What should I expect the first months to be like as a new team member?"<br>
  > "What are some challenges that *you* faced when you started?<br>
  > "How do you solve this common issue with one of the technologies you're using?"<br>
  > "Why do you use *this* over *that*?"<br>
   
 ## Big O Notation: Concern for Algorithm runtime and space
 
 * Big O describes an upper bound on time
 * Big Omega describes a lower bound
 * Big theta says that an algorithm is only Θ(x) if it is O(x) and Omega(x)
 
 Big O can describe 3 different cases for an algorithm: Best, Worst and Expected
 
 * **Best**: Quicksort is **O(N)** if all elements are equal
 * **Worst**: Quicksort is **O(N^2)** if the pivot is consistantly the biggest element
 * **Expected**: Quicksort is **O(N log(n) )** in most cases
 
 When discussing size complexity we can say that an array of size N will be **O(N)**, and a two-dimensional array would be **O(N^2)**
 
 **Note:** We care about using more memory and keeping stack growth minimal but not all repeated function calls grow the stack.
 
 ![Graph of different Complexities](https://qph.fs.quoracdn.net/main-qimg-dc31e536ddf8f450632a848c33c5cc03)
 
 > When do we add runtimes versus multiply runtimes?<br>
 *Example a* 
 ```
 for (int a : arrA)
   print(a);
 for (int b : arrB)
   print(b);
 ```
  *Example b* 
 ```
 for (int a : arrA){
   for (int b : arrB)
     print(a + b);
 } 
 ```
 In this example we add the runtimes of *a* for O(A+B) and multiply the runtimes of *b* for O(A * B)
 **Rule of thumb:** If algorithm is "do this, then do that" you add, if it is "do this for every time we do that" then we multiply!
 
**Amortized Time:** Describes that the worst case of the algorithm *does* happen but it won't happen for a while longer since the cost is "amortized." 

* **Example:** A dynamic ArrayList will frequently have O(1) insertions but once the array needs to grow it will be an O(N) operation. The amortized time is O(1) though. 

**Log(N) Runtimes:** These are commonly the runtimes associated with algorithms that halve the problem each iteration, such as binary search. Tree operations are also commonly log(n) since they either go left or right and thus cut out half of the problem space in that iteration.

Many recursive functions that make multiple calls have runtimes like **O(branches^depth)**, where branches is how many branches are coming off of each call. A BST only has 2 calls per recursive routine so that has 2 branches. 

###
What are the runtimes of the following functions?
```C
void foo(int[] array){
  int sum = 0;
  int product = 1;
  for (int i=0; i<array.length; i++){
    sum += array[i];
  }
}
```
> O(N) time.

```Java
void printPairs(int[] array) {
  for (int i= 0; i < array.length; i++) {
    for (int j = 0; j < array.length; j++) {
      System.out.println(array[i] + "," + array[j]);
    }
  }
} 
```
> My guess: O(N^2), Solution: O(N^2) 

```Java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
  for (int i= 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      if (arrayA[i] < arrayB[j]) {
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
} 
```
> My guess: O(N^2), Solution: O(ab) since there are 2 different inputs. Since array A could have length==1 and B could have length==100000 we need to consider the difference. This makes a lot of sense. 

```Java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
  for (int i= 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      for (int k = 0; k < 100000; k++) {
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
} 
```
> My guess: O(ab) again since loop 1 runs A times, loop 2 runs B times, loop 3 is constant and the print is constant. AxBx1x1 <br>
> Solution: O(ab)

```Java
void reverse(int[] array) {
  for (int i= 0; i <array.length/ 2; i++) {
    int other= array.length - i - 1;
    int temp= array[i];
    array[i] = array[other];
    array[other] = temp;
  }
} 
```
> My guess: O(N) since the loop runs N/2 times and contains only constant instructions. Solution: O(N)

**Which of the following are O(N)**:
* O(N + P) where P<N/2;   
* O(2N)
* O(N + log N)
* O(N+M)

> All but number 4 are O(N). When working through these consider the dominant term and don't worry about the rest:

* O(N + P) where P<N/2; **P is not significant since it is less than N/2**  
* O(2N); **2 is not significant compared to the possibilities of N**
* O(N + log N); **N is a much higher runtime than log N so we discard log N**
* O(N+M); **We do not know the value of M so this would have to be O(N+M) still

**Given an array of strings, sort each string then sort the array. What is the complexity?**
```
for (i : array){  //N
  for (j : i){    //M
    comparison:
      swap
  }
for (i : arr){   // N
  comparison:
    swap
}
```
> My Guess: O(NM) which I first figured O(2NM) and then removed 2 <br> 
> Solution: I was completely off since I was using a primitive sorting method and complexity. if s is the length of the longest string and a is the length of the array we can now break this down into parts. First sorting each string is O(s log s). Next since we do this for every string we have **O(a * s log s)**. Finally we have to sort the array and to do this we need to consider every part, the length of the array and the length of the strings. Some may first think it is O(a log a) but this does not consider the string comparisons. Comparing strings is an O(S) operation, over (a log a) comparisons=> **O(a * s log a)**. Add up all of the complexities to arrive at **O(a * s(log a + log s)**

```Java
// Sums nodes in a balanced BST
int sum(Node node) {
  if (node == null) {
    return 0;
  }
  return sum(node.left) + node.value + sum(node.right);
} 
```
> My guess: O(log N) since we are cutting the problem space in half each iteration. Solution: O(N) since the code only touches each node once and does constant operations on each node... Another way to look at it is the rule of thumb where recursive calls follow complexity **O(branches^depth)**. In this case branches is 2 and depth is log N, and 2^log(n) actually deduces to N!

```Java
boolean isPrime(int n) {
  for (int x = 2; x * x <= n; x++) {
    if (n % x == 0) {
      return false;
    }
  }
  return true; 
}
```
> My guess: Not entirely sure, O(log N) fits my examples but I can't work out the logic of why. The loop stops when x == sqrt(n). Solution: O(sqrt(n)), I had considered this as an option but I suppose I was not convinced that sqrt(n) would be a viable complexity. Don't overthink!

This simply computes n!, factorial function:
```Java
int factorial(int n) {
  if (n < 0) {
    return -1;
  } else if (n == 0){
    return 1;
  } else {
    return n * factorial(n - 1);
  }
} 
```
> My guess: O(N), seems like linear calls with simple comparisons in each call. Solution: O(N)

This code counts all permutations of a string. Tricky one!
```Java
void permutation(String str) {
  permutation(str, "");
}
void permutation(String str, String prefix) {
  if (str.length() == 0) {
    System.out.println(prefix);
  } else {
    for (int i= 0; i < str.length(); i++) {
      String rem = str.substring(0, i) + str.substring(i + 1);
      permutation(rem, prefix + str.charAt(i));
    }
  }
} 
```
> My guess: O(2^n) but this one was really challenging and I'm really curious to see actual answer. Solution: First big thing I missed is that printing a string is a linear operation! String rem line is linear as well. So at this point the work required in one node is linear. Now to figure out how many function calls there are. There are n! leaves attached to a path of length n. There can not be more than n * n! nodes. Put these all together for O(N^2 * N!)

Fib time 
```Java
int fib(int n) {
  if (n <= 0) return 0;
  else if (n == 1) return 1;
  return fib(n - 1) + fib(n - 2);
}
```
> My guess: Based on the rule discussed with trees of O(branches^depth) and drawing out an example tree it should be O(2^N). Solution: O(2^N) although it does say the runtime could be tighter since the tree will always have a slight imbalance to it. 

**How could memoization help when iterating through the first 20 digits of fib?**
> If we cache each iteration of fib then we simply have to lookup the value instead of running through fib every time. This would make an algorithm to iterate through fib O(N)

**Here is my implementation:**
```C++
int
fast_fib(std::vector<int> &v, long n ){
    if (n > v.size()){
        v.resize(n*1.5, -1);
    }
    if (v[n] > -1 ) return v[n];
    // not cached
    if (n==0 || n==1) return n;
    v[n] = fast_fib(v, n-1) + fast_fib(v, n-2);
    return v[n];
}
```
