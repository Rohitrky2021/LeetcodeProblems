 class Solution1 {
      public int timeRequiredToBuy(int[] tickets, int k) {
        int c = 0, n = tickets.length, ans = 0,u=0;
        int x=0;

        for (int i : tickets) {
            if (i > tickets[k]) c++;
            if (i > tickets[k] && x>k) u++;
             
            x++;
        }

        int ls =n-c;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] <= tickets[k] ) ans += tickets[i];
        }
        System.out.println(ans+" d  "+c+","+u);
        
         

        return (ans+(c-u) * tickets[k])+(tickets[k]-1)*u;
    }

}



class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]);
            } else {
                total += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return total;
    }
}

class Solution2 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for(int i=0;i<tickets.length;i++)
        {
            if(i<=k)
            {
                if(tickets[i]<=tickets[k]) ans+=tickets[i];
                else ans+=tickets[k];
            }
            else
            {
                if(tickets[i]<tickets[k]) ans+=tickets[i];
                else ans+=tickets[k]-1;
            }
            
        }

        return ans;
    }
}

class Solution3 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result=0;
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]<tickets[k]) result+=tickets[i];
            else if(i<=k&&tickets[i]>=tickets[k]) result+=(tickets[k]);
            else result+=tickets[k]-1;
        }
        return result;
    }
}