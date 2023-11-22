class Solution1 {  // Using Single array spaced saved 
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



class Solution2 { // Using 2 array L and R  spaced  
  public int candy(int[] ratings) {
    final int n = ratings.length;

    int ans = 0;
    int[] l = new int[n];
    int[] r = new int[n];
    Arrays.fill(l, 1);
    Arrays.fill(r, 1);

    for (int i = 1; i < n; ++i)
      if (ratings[i] > ratings[i - 1])
        l[i] = l[i - 1] + 1;

    for (int i = n - 2; i >= 0; --i)
      if (ratings[i] > ratings[i + 1])
        r[i] = r[i + 1] + 1;

    for (int i = 0; i < n; ++i)
      ans += Math.max(l[i], r[i]);

    return ans;
  }
}


class Solution3 {  // This is Not passing all but can see this reduced logic 
    public int candy(int[] ratings) {
        final int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Combined forward and backward pass
        for (int i = 1; i < n; ++i) {
            // Forward pass
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
            
            // Backward pass
            int j = n - 1 - i;
            if (ratings[j] > ratings[j + 1]) {
                candies[j] = Math.max(candies[j], candies[j + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}

 
class Solution4 {  // Uisng Single Pass without any space of Array 
    public int candy(int[] ratings) {
        final int n = ratings.length;
        if (n == 0) {
            return 0;
        }

        int candies = 0;
        int up = 0, down = 0, oldSlope = 0;

        for (int i = 1; i < n; ++i) {
            int newSlope = Integer.compare(ratings[i], ratings[i - 1]);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += countCandies(up) + countCandies(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }

        candies += countCandies(up) + countCandies(down) + Math.max(up, down) + 1;

        return candies;
    }

    private int countCandies(int n) {
        return n * (n + 1) / 2;
    }
}


class Solution {
    public int candy(int[] ratings) {
        final int n = ratings.length;
        if (n == 0) {
            return 0;
        }

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Forward pass
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Backward pass
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}

