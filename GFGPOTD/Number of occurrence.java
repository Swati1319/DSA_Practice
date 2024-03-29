class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int l=0,r=n-1;
        int lb=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]<x){
                l=mid+1;
            }else{
                lb=mid;
                r=mid-1;
            }
        }
        if(lb==-1 || arr[lb]!=x)return 0;
        l=0;
        r=n-1;
        int ub=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]<=x){
                ub=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ub-lb+1;
    }
}
