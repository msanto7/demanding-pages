//Michael Santoro 
//COSC Programming Assignment #4
//Due 5-15-16

#include <stdio.h>
# define MAX 25
 
 typedef struct page {  
   int frame;  
   int count[MAX];
   int current[MAX];
 }page ; 
//setup of page and frame structure 
 struct page p ;

 //Main Method 
 
 void pageReplacement(int pages,int page[]) ;  //prototype for fifo method 
 
 void main() {  
 
	int pages = 0;  //initialize to zero to start 
	int i;
	int j;
	int page[MAX];
	int frames = 0;
	char temp;   
  
			printf("Enter the length of our reference string(pages): \n");  
			scanf("%d",&pages) ;  
			printf("Reference string--> \n");  
			for(i = 0; i < pages; i++) { 
				scanf("%d", &page[i]) ;  
			}  
			printf("Enter how many frames will be used: \n");  
			scanf("%d", &p.frame);  
  
			pageReplacement(pages,page);    //xeceutes FIFO page replacement 

 }			
 
 //Method to execute the FIFO Simulation 
 void pageReplacement(int pages,int page[]) {  
 
  int i;
  int j;
  int k;
  int flag = 0;
  int temp = 0; 
  int fault = 0 ;
  
  for(i = 0; i < p.frame; i++) {  
     p.current[i] = -1 ;       //initialize for empty 
     p.count[i] = 100 ;  
  }   
  
  for(i = 0; i < pages; i++) {  
     flag = 0 ;  
     temp = 0 ;  
     for(j = 0; j < p.frame; j++) {  
           if(p.current[j] == page[i]) {     //hit, we are good to move on
             flag = 1;  
             break;  
           }  
           if(temp < p.count[j]) {   //
               temp = p.count[j];  
               k = j;  
           }  
     }  
     for(j = 0; j < p.frame; j++) {    //process through 
         if(flag == 0 && k == j) {     //increment, there has been a fault
           p.current[j] = page[i];  
           p.count[j] = 1;  
           fault++;  
         }   
         else if(j < fault)         //increase count and move on        
			 p.count[j]++;  
         if(p.current[j]!= -1)    //if not empty frame then print 
			 printf("\t%d\n", p.current[j]);  
     } 
	 
    printf("\n");
    printf("------------");
	printf("\n");	 
  }
  
  printf("Page Faults --> %d",fault);    //print final count 
  
 }  //Ends FIFO
