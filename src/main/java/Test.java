public class Test {
    public int[] solve(int[] A) {

        int n=A.length;
        //end initialized with -1 instead of 0
        int i=0,j=0,end=-1,start=0;
        while(i<n &&j<n){
            if(A[j]>=0)
                j++;
            else{
                    if(j-i>end-start+1){
                        start=i;
                        end=j-1;
                    }
                i=j+1;
                j++;
            }
        }
        //this condition is neccesary
        if(j-i>end-start+1){
            start=i;
            end=j-1;
        }

        int arr[]=new int [end-start+1];

        int indx=start;
        //it should be k++
        for(int k=0;k<end-start+1;k++)
            arr[k]=A[indx++];

      return arr;
    }
}