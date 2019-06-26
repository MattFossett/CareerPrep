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

**LEFT OFF AT PAGE 45**
 
