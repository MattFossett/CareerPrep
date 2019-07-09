# Stack versus Heap write up 

> Referenced from geeksforgeeks.org 

Memory can be allocated on a Stack or on a Heap. They are used for different cases. 

**Stack Allocation:** Contiguous blocks of memory are allocated on the stack. 
The size of memory is known at compile time and when a funciton is called its variables are placed on the stack. 
Once the function call is over the stack essentially pops these variables, deallocating them. 
As far as C or C++ is concerned, the programmer does **not** need to worry about deallocation. 

Here are some variables that would be found allocated on the stack:
```C++
    int a;
    int b[20];
    int n=20;
    int c[n];
```

**Heap Allocation:** Memory allocated during the runtime of the program. 
Unfortunately the heap is **not** called this based on the Data Structure, but because it is a heap of available memory.
The heap is where memory leaks are found since the programmer is in charge of allocating and deallocating memory. 

Here is a variable that could be found on the heap. The "new" keyword makes this use heap memory. 
```C++
int *prt = new int[10];
```

| Parameter | Stack | Heap |
| --------- | ----- | ---- |
| Concept | Memory all allocated on contiguous block | Memory randomly allocated | 
| Alloc/Dealloc | Automatic by compiler | Manual by programmer |
| Cost | Less | More |
| Access Time | Faster | Slower |
| Issues | Shortage of memory | Fragmentation and potential memory leaks by programmer |
| Flexibility | Fixed size | Able to resize |

**Key Differences:**
* Stack automatically alloc/dealloc's and the heap is done by the programmer.
* Handling the heap is more expensive
* The Stack is more likely to run out of memory, but the Heap can have issues with fragmentation 
(free and alloc'd memory scattered where allocating large chunks may not be possible)
* Stack is more cache friendly while the heap frames are dispersed through memory, making cache misses more common. 
* Stack is **not** flexible, allotted memory is fixed. Heap is dynamic. 
* Takes more time to access heap data
