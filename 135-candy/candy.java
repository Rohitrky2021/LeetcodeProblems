class Solution {
 public int candy(int[] ratings) {
        int sum=0;
        int[] a=new int[ratings.length];
        for(int i=0;i<a.length;i++)
        {
            a[i]=1;
        }
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i+1]>ratings[i])
            {
                a[i+1]=a[i]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i])
            {
                if(a[i-1]<(a[i]+1))
                {
                    a[i-1]=a[i]+1;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
        }
        return sum;
    }
}
// class Solution {
//   public int candy(int[] ratings) {
//     final int n = ratings.length;

//     int ans = 0;
//     int[] l = new int[n];
//     int[] r = new int[n];
//     Arrays.fill(l, 1);
//     Arrays.fill(r, 1);

//     for (int i = 1; i < n; ++i)
//       if (ratings[i] > ratings[i - 1])
//         l[i] = l[i - 1] + 1;

//     for (int i = n - 2; i >= 0; --i)
//       if (ratings[i] > ratings[i + 1])
//         r[i] = r[i + 1] + 1;

//     for (int i = 0; i < n; ++i)
//       ans += Math.max(l[i], r[i]);

//     return ans;
//   }
// }
