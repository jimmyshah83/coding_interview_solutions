package com.practice.coding.solutions.arrays;

/**
 * CRACKING the coding INTERVIEW 1.7
 * 
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * Explanation: https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
public class RotateMatrix {
	
	// An Inplace function to rotate a N x N matrix 
    // by 90 degrees in clockwise direction 
    static void rotateMatrixClockwise(int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) 
        { 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++) 
            { 
                // store current cell in temp variable 
                int temp = mat[x][y]; 
       
                // move values from left to bottom 
                mat[x][y] = mat[N-1-y][x]; 
       
                // move values from bottom to right 
                mat[N-1-y][x] = mat[N-1-x][N-1-y]; 
       
                // move values from right to top 
                mat[N-1-x][N-1-y] =  mat[y][N-1-x]; 
       
                // assign temp to left 
                mat[y][N-1-x]  = temp; 
            } 
        } 
    } 

	// An Inplace function to rotate a N x N matrix 
    // by 90 degrees in anti-clockwise direction 
    static void rotateMatrixAntiClockwise(int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) 
        { 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++) 
            { 
                // store current cell in temp variable 
                int temp = mat[x][y]; 
       
                // move values from right to top 
                mat[x][y] = mat[y][N-1-x]; 
       
                // move values from bottom to right 
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                // move values from left to bottom 
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                // assign temp to left 
                mat[N-1-y][x] = temp; 
            } 
        } 
    } 
  
    // Function to print the matrix 
    static void displayMatrix(int N, int mat[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + mat[i][j]); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    } 
       
    /* Driver program to test above functions */
    public static void main (String[] args)  
    { 
        int N = 4; 
          
        // Test Case 1 
        int mat[][] = 
        { 
            {1, 2, 3, 4}, 
            {5, 6, 7, 8}, 
            {9, 10, 11, 12}, 
            {13, 14, 15, 16} 
        }; 
       
        //rotateMatrixAntiClockwise(N,mat);
        rotateMatrixClockwise(N,mat);
       
        // Print rotated matrix 
        displayMatrix(N,mat);
        
        System.out.println("\n");
    } 
} 

