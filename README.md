# Algorithms2_MaxSubRectangle

The idea behind this project is as follows : 
- Given a two dimensional array , we are looking to go through this array and with the minimum time complexity, we want to 
locate the Maximum Sub Rectangle of that specific matrix:
For example, let's look at the matrix :
{{0,1,2,3},
 {0,0,5,3},
 {0,1,2,4}}

So , when running this code, we will find that the Max Sub-Reactangle is this matrix is :
{{2,3},
 {5,3},
 {2,4}} , because when we sum up those digits, we can see that this is the highest values that forms a subrectangle of this given Matrix

And all this with a minimum time complexity.

To run the code, create a main function.
The input is quite special. This input represents at which line and which column each value is located in the matrix.
The input should look like this:
First column for i, second for j and third for value.
Example of input : 

int arr[][] = {{0,3,1},
               {1,2,1},
               {1,3,2},
               {1,4,-4},
               {2,1,2},
               {2,2,-3},
               {2,3,3},
               {2,4,3},
               {2,5,1},
               {3,0,-2},
               {3,1,10},
               {3,2,9},
               {3,3,-2},
               {3,4,4},
               {3,5,5},
               {3,6,-11}};
               
This matrix represents a given area in the matrix. For example, the first line of this array means that at emplacement [0][3], we have the value 1 ans so on.
To run the code , in main function :

MaxSubRectangle m = new MaxSubRectangle(arr);

Enjoy :)

                
