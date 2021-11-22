/* Lab 2 - Task 1
   Author: Mahmoud Kamal
   Date:   03-11-2021
*/
#include <stdio.h>
#include <stdlib.h>

int main()
{
    /* Variables Declaration */
    float num1,num2,num3,num4,num5;
    float max,min;

    /* User Inputs */
    printf("Enter The Number #1: ");
    scanf("%f",&num1);
    printf("Enter The Number #2: ");
    scanf("%f",&num2);
    printf("Enter The Number #3: ");
    scanf("%f",&num3);
    printf("Enter The Number #4: ");
    scanf("%f",&num4);
    printf("Enter The Number #5: ");
    scanf("%f",&num5);

    /* Maximum Operation */
    if (num1 > num2)
    {
      if (num1 > num3)
      {
          if (num1 > num4)
          {
              if (num1 > num5)
              {
                  max = num1;
              }
              else
              {
                  max = num5;
              }
          }
          else
          {
              if (num4 > num5)
              {
                 max = num4;
              }
              else
              {
                 max = num5;
              }
          }
      }
      else
      {
          if (num3 > num4)
          {
              if (num3 > num5)
              {
                  max = num3;
              }
              else
              {
                  max = num5;
              }
          }
          else
          {
              if (num4 > num5)
              {
                 max = num4;
              }
              else
              {
                max = num5;
              }
          }
      }
    }
    else
    {
        if (num2 > num3)
      {
          if (num2 > num4)
          {
              if (num2 > num5)
              {
                  max = num2;
              }
              else
              {
                  max = num5;
              }
          }
          else
          {
              if (num4 > num5)
              {
                 max = num4;
              }
              else
              {
                max = num5;
              }
          }
      }
      else
      {
          if (num3 > num4)
          {
              if (num3 > num5)
              {
                  max = num3;
              }
              else
              {
                  max = num5;
              }
          }
          else
          {
              if (num4 > num5)
              {
                 max = num4;
              }
              else
              {
                max = num5;
              }
          }
      }
    }

    /* Minimum Operation */
    if (num1 < num2)
    {
      if (num1 < num3)
      {
          if (num1 < num4)
          {
              if (num1 < num5)
              {
                  min = num1;
              }
              else
              {
                  min = num5;
              }
          }
          else
          {
              if (num4 < num5)
              {
                 min = num4;
              }
              else
              {
                 min = num5;
              }
          }
      }
      else
      {
          if (num3 < num4)
          {
              if (num3 < num5)
              {
                  min = num3;
              }
              else
              {
                  min = num5;
              }
          }
          else
          {
              if (num4 < num5)
              {
                 min = num4;
              }
              else
              {
                 min = num5;
              }
          }
      }
    }
    else
    {
        if (num2 < num3)
      {
          if (num2 < num4)
          {
              if (num2 < num5)
              {
                  min = num2;
              }
              else
              {
                  max = num5;
              }
          }
          else
          {
              if (num4 < num5)
              {
                 min = num4;
              }
              else
              {
                 min = num5;
              }
          }
      }
      else
      {
          if (num3 < num4)
          {
              if (num3 < num5)
              {
                  min = num3;
              }
              else
              {
                  min = num5;
              }
          }
          else
          {
              if (num4 < num5)
              {
                 min = num4;
              }
              else
              {
                 min = num5;
              }
          }
      }
    }

    /* Outputs */
    printf("\nMaximum = %0.2f",max);
    printf("\nMinimum = %0.2f",min);

    return 0;
}
