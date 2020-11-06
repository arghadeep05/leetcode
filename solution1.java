class Solution {
    public String longestPalindrome(String str) {
        //Manacher's Algorithm
        char[] s = str.toCharArray();
        int[] f=new int[2*s.length+1];
        int c=0, r=0, tc=0, tr=0;
        for(int i=1,x=0,y=0;i<f.length;++i)
        {
            if(i<r)
                f[i]=Math.min(r-i,f[(c<<1)-i]);
            x=i+f[i]+1;
            y=(i<<1)-x;
            while((x & 1)==0 || (y>=0 && x<f.length && s[x>>1]==s[y>>1]))
            {
                f[i]++;
                x++;
                y--;
            }
            if(i+f[i]>r)
            {
                c=i;
                r=i+f[i];
            }
            if(f[i]>tr-tc)
            {
                tc=c;
                tr=r;
            }
        }
        return str.substring(((tc<<1)-tr)/2,tr/2);
    }
}