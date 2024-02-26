class Solution {

//Challo to bhai log, iss question mei, contest mei lag gyi. 
//But ye hai kaffi easy.
//Binary search aata hai? Aata nhi hai to padhlo jakar.

//Ab tum ye socho ki bhai answer ki range kya ho skti hai ?
//Socho..
//Are soch le, aage padhta jayega kya..
//To range ho skta hai 1 second se lekar changeIndices ke length tkk.
//Question mei bhi likha hai 's' is in order from '1' to 'm'.

//Ab range hogya hai [1,m]
//Humare programming ki duniya mei countng 0 se start hoti hai to 
//range thoda sa badal dete hain
//[0,m-1]

// Range ki 'lower' = 0 and 'upper' = m-1.
// Ab mannlo koi bhi number uthalo range mei, let say 't'.

//Agar tum 't' time mei saare array ke elements ko mark kar diye.
// to 't+1' mei kr hi doge? To 't' answer ho skta hai.
// But bhai log ye socho ki 't' se kam mei bhi ho skta hai ho jaye, 
//to 't' ko answer banalo, but usse neeche bhi check kro, 
//mltb aur optimised answer dhundho tum [0,t-1] range mei.

// Ab socho ki tum 't' time mei nahi kar pare saare elements ko mark, 
//to tumhe 't' se zyada time lagega na!
// Isliye answer ko [t+1,m-1] mei dhundho ab.

//Isko kehte hai "Binary Search on Answer".
//Ye kaam isliye krra kyuki humara answer monotonic hai, 
//monotonic mtlb ya to increasing ya decreasing hai

//Ab dikkat ki baat kya hai?? Kaise pta krein ki time 't'  pe possible 
//hai ya nahi !

// Ek function banate hai 
// isPossible(int time, int[] nums, int[] changedIndices)
// Ye bta dega.


    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        
        int ans = -1;

        int l = 0; 
        int u = changeIndices.length-1;
        while(l<=u) {
            int m = l + (u-l)/2;
            if(isPossible(m, nums, changeIndices)){
                ans = m; 
                u = m-1;
            } else {
                l = m+1;
            }
        }

        return ans==-1?-1:ans+1;
    }

//Mehnat krne ka time aagya sher !
//Ye rha wo function jo jadu krega

//Sbse pehle to ye socho ki.
//ek index hai 'i'
// Ye to changeIndices mei kayi baar aayega.
// But lets say 100 baar aaya, 
// tumhe iss index 'i' ko mark kab krna chahiye?
// obviously jab ye last baar aaye tb !
// Kyuki baaki bache huwe 99 baar mei tum kuch aur skte ho, 
// kyuki ye to aage aayega hi !

//Isliye ek array mei ye store krlo ki indices last baar kab aayenge

//Ab challo process kro changeIndices ko from [0,time]
//Kyuki itte hi time mei sab mark krna hai 
//isliye loop time tkk chalao

// Ye socho ki ye jo index hai nums ka, agar wo aaage bhi aayega. 
// To tum,
// iss time pe kisi ko decrement kr skte ho. 
// To ek variable mei store krlo
// ki '1' operation hai tumhare pass of decrementing, 
// kisko kroge decrement, future ki baat h.

//Ab ye dekho ki yr, agar current jo indx hai wo last baar hai, 
// aage nahi aayega

// Tbto mark hi krna hai boss. Ab nhi kiya to gye, aage aayega nhi
// Ab ye dekho ki mark krne ke liye kya hona chahiye value
// Lets say ki value '0' hai tb to badhiya hai !
// But value kuch 'x' hai, 
// mtlb ki tumhe iss element ko 'x' baar decrement krna tha 
// takki mark kr sko. 

// But kya itte 'operations' the tumahre pass ?
// Agar the to mark krdo, operations ghata do
// Nahi the to tata bye bye, nahi possble hai boss.

    private boolean isPossible(int time, int[] arr, int[] chngInd) {

        int operations = 0;
        int marked = 0;

      
//Ismie last baar kab aayega index process hora        
        Integer[] last = new Integer[arr.length];      
        for(int index = 0; index<=time; index++) {
            last[chngInd[index]-1] = index;
        }

        for(int i = 0; i <=time ; i++) {
            
            int index = chngInd[i]-1;
//Agar ye index last baar aara, to mark krne ka try krte hain.
            if(last[index]!=null && last[index]==i) {

                // Agar operation available hai, to mark krdo.
                // Aur operations use krliye tmne to ghata do.
                if(operations>=arr[index]){
                    marked++;
                    operations -= arr[index];
                } 
                //nahi hai to Tata Bye Bye
                else {
                    return false;
                }
            } 
//Agar last baar nhi aara hai to operations badha lo decrement ke.         
            else 
            {
                operations++;
            }

        }

//Agar tm mark kr paye saare elements to mazze wrna unsuccessful.
        return marked == arr.length;
    }
}